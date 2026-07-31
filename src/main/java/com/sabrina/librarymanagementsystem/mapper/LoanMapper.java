package com.sabrina.librarymanagementsystem.mapper;

import com.sabrina.librarymanagementsystem.controller.dto.LoanResponse;
import com.sabrina.librarymanagementsystem.entity.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public LoanResponse toResponse(Loan loan) {

        LoanResponse response = new LoanResponse();

        response.setId(loan.getId());

        if (loan.getUser() != null) {
            response.setUserName(loan.getUser().getFirstname()
                    + " "
                    + loan.getUser().getLastname());
        }

        if(loan.getBook()!=null){
            response.setBookTitle(loan.getBook().getTitle());
        }

        response.setBorrowDate(loan.getBorrowDate());
        response.setReturnDate(loan.getReturnDate());
        response.setLoanStatus(loan.getLoanStatus().name());

        return response;
    }
}
