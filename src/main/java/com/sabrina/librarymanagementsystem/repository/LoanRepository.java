package com.sabrina.librarymanagementsystem.repository;

import com.sabrina.librarymanagementsystem.entity.Loan;
import com.sabrina.librarymanagementsystem.entity.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {

    List<Loan> findByLoanStatusAndDueDateBetweenAndReminderSentFalse(
            LoanStatus loanStatus,
            LocalDateTime start,
            LocalDateTime end
    );
}
