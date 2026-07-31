package com.sabrina.librarymanagementsystem.service;

import com.sabrina.librarymanagementsystem.controller.dto.LoanRequest;
import com.sabrina.librarymanagementsystem.controller.dto.LoanResponse;
import com.sabrina.librarymanagementsystem.entity.Book;
import com.sabrina.librarymanagementsystem.entity.Loan;
import com.sabrina.librarymanagementsystem.entity.LoanStatus;
import com.sabrina.librarymanagementsystem.entity.User;
import com.sabrina.librarymanagementsystem.exception.ResourceNotFoundException;
import com.sabrina.librarymanagementsystem.kafka.LoanEvent;
import com.sabrina.librarymanagementsystem.kafka.producer.LoanProducer;
import com.sabrina.librarymanagementsystem.mapper.LoanMapper;
import com.sabrina.librarymanagementsystem.repository.BookRepository;
import com.sabrina.librarymanagementsystem.repository.LoanRepository;
import com.sabrina.librarymanagementsystem.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final LoanProducer loanProducer;
    public LoanService(LoanRepository loanRepository, LoanMapper loanMapper, UserRepository userRepository, BookRepository bookRepository, LoanProducer loanProducer) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.loanProducer = loanProducer;
    }

    public LoanResponse createLoan(@Valid LoanRequest request){

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("User not found");
                });

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Book not found");
                });

        if(!book.getAvailable()) {
            throw new RuntimeException("Book is not available");
        }

        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setBorrowDate(LocalDate.now());
        loan.setLoanStatus(LoanStatus.BORROWED);

        book.setAvailable(false);

        bookRepository.save(book);

        Loan savedLoan = loanRepository.save(loan);

        LoanEvent event = LoanEvent.newBuilder()
                .setLoanId(savedLoan.getId())
                .setUserId(user.getId())
                .setBookId(book.getId())
                .setAction("BORROWED")
                .build();

        loanProducer.sendLoanEvent(event);

        return loanMapper.toResponse(savedLoan);
    }

    public List<LoanResponse> findAll(){
        return loanRepository.findAll()
                .stream()
                .map(loanMapper::toResponse)
                .toList();
    }

    public LoanResponse findById(Long id){
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        return loanMapper.toResponse(loan);
    }

    public LoanResponse returnBook(Long id){

        Loan loan = loanRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Loan not found"));

        if (loan.getLoanStatus() == LoanStatus.RETURNED) {
            throw new RuntimeException("Book already returned");
        }

        loan.setReturnDate(LocalDate.now());
        loan.setLoanStatus(LoanStatus.RETURNED);

        Book book = loan.getBook();
        book.setAvailable(true);

        bookRepository.save(book);

        Loan updatedLoan = loanRepository.save(loan);

        return loanMapper.toResponse(updatedLoan);

    }

    public void delete(Long id){

        if (!loanRepository.existsById(id)) {
            throw new ResourceNotFoundException("Loan not found");
        }
        loanRepository.deleteById(id);
    }
}
