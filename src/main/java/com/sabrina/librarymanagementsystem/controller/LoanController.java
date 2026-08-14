package com.sabrina.librarymanagementsystem.controller;

import com.sabrina.librarymanagementsystem.controller.api.LoansApi;
import com.sabrina.librarymanagementsystem.controller.dto.LoanResponse;
import com.sabrina.librarymanagementsystem.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class LoanController implements LoansApi {
    private final LoanService loanService;
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @Override
    public ResponseEntity<List<LoanResponse>> apiLoansGet() {
        return ResponseEntity.ok(loanService.findAll());
    }

    @Override
    public ResponseEntity<Void> apiLoansIdDelete(Long id) {
        loanService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<LoanResponse> apiLoansIdGet(Long id) {
        return ResponseEntity.ok(loanService.findById(id));
    }

    @Override
    public ResponseEntity<LoanResponse> apiLoansIdReturnPut(Long id) {
        return ResponseEntity.ok(loanService.returnBook(id));
    }

    @Override
    public ResponseEntity<LoanResponse> apiLoansPost(com.sabrina.librarymanagementsystem.controller.dto.LoanRequest loanRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(loanService.createLoan(loanRequest, currentUserEmail));
    }

}
