package com.sabrina.librarymanagementsystem.batch;

import java.time.LocalDateTime;

public class LoanNotification {

    private String email;
    private String userName;
    private String bookTitle;
    private LocalDateTime dueDate;

    public LoanNotification(
            String email,
            String userName,
            String bookTitle,
            LocalDateTime dueDate
    ) {
        this.email = email;
        this.userName = userName;
        this.bookTitle = bookTitle;
        this.dueDate = dueDate;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }
}
