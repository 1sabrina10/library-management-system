package com.sabrina.librarymanagementsystem.repository;

import com.sabrina.librarymanagementsystem.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {
}
