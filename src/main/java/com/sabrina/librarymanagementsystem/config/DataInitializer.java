/*
package com.sabrina.librarymanagementsystem.config;

import com.sabrina.librarymanagementsystem.entity.Book;
import com.sabrina.librarymanagementsystem.entity.Loan;
import com.sabrina.librarymanagementsystem.entity.LoanStatus;
import com.sabrina.librarymanagementsystem.entity.User;
import com.sabrina.librarymanagementsystem.repository.BookRepository;
import com.sabrina.librarymanagementsystem.repository.LoanRepository;
import com.sabrina.librarymanagementsystem.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initLoan(
            UserRepository userRepository,
            BookRepository bookRepository,
            LoanRepository loanRepository
    ) {

        return args -> {

            User user = userRepository.findByEmail("user@library.com")
                    .orElseThrow(() -> new RuntimeException("User not found"));

            Book book = bookRepository.findById(2L)
                    .orElseThrow(() -> new RuntimeException("Book not found"));

            Loan loan = new Loan();
            loan.setUser(user);
            loan.setBook(book);
            loan.setBorrowDate(LocalDate.now());
            loan.setReturnDate(null);
            loan.setLoanStatus(LoanStatus.BORROWED);

            book.setAvailable(false);
            bookRepository.save(book);

            loanRepository.save(loan);
        };
    }
}
*/
