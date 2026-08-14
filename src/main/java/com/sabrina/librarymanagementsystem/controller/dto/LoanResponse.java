package com.sabrina.librarymanagementsystem.controller.dto;

import java.time.LocalDateTime;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * LoanResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-12T16:37:40.985844203+02:00[Europe/Andorra]", comments = "Generator version: 7.15.0")
public class LoanResponse {

    private @Nullable Long id;

    private @Nullable String userName;

    private @Nullable String bookTitle;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private @Nullable LocalDateTime borrowDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private @Nullable LocalDateTime dueDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime returnDate;

    private @Nullable String loanStatus;

    public LoanResponse id(@Nullable Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     */

    @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("id")
    public @Nullable Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

    public LoanResponse userName(@Nullable String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Get userName
     * @return userName
     */

    @Schema(name = "userName", example = "Sabrina Moufok", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("userName")
    public @Nullable String getUserName() {
        return userName;
    }

    public void setUserName(@Nullable String userName) {
        this.userName = userName;
    }

    public LoanResponse bookTitle(@Nullable String bookTitle) {
        this.bookTitle = bookTitle;
        return this;
    }

    /**
     * Get bookTitle
     * @return bookTitle
     */

    @Schema(name = "bookTitle", example = "Clean Code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("bookTitle")
    public @Nullable String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(@Nullable String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public LoanResponse borrowDate(@Nullable OffsetDateTime borrowDate) {
        this.borrowDate = borrowDate.toLocalDateTime();
        return this;
    }

    /**
     * Get borrowDate
     * @return borrowDate
     */
    @Valid
    @Schema(name = "borrowDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("borrowDate")
    public @Nullable LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(@Nullable LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LoanResponse dueDate(@Nullable OffsetDateTime dueDate) {
        this.dueDate = dueDate.toLocalDateTime();
        return this;
    }

    /**
     * Get dueDate
     * @return dueDate
     */
    @Valid
    @Schema(name = "dueDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("dueDate")
    public @Nullable LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(@Nullable LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LoanResponse returnDate(OffsetDateTime returnDate) {
        return this;
    }

    /**
     * Get returnDate
     * @return returnDate
     */
    @Valid
    @Schema(name = "returnDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("returnDate")
    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public LoanResponse loanStatus(@Nullable String loanStatus) {
        this.loanStatus = loanStatus;
        return this;
    }

    /**
     * Get loanStatus
     * @return loanStatus
     */

    @Schema(name = "loanStatus", example = "BORROWED", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("loanStatus")
    public @Nullable String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(@Nullable String loanStatus) {
        this.loanStatus = loanStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoanResponse loanResponse = (LoanResponse) o;
        return Objects.equals(this.id, loanResponse.id) &&
                Objects.equals(this.userName, loanResponse.userName) &&
                Objects.equals(this.bookTitle, loanResponse.bookTitle) &&
                Objects.equals(this.borrowDate, loanResponse.borrowDate) &&
                Objects.equals(this.dueDate, loanResponse.dueDate) &&
                Objects.equals(this.loanStatus, loanResponse.loanStatus);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LoanResponse {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("    bookTitle: ").append(toIndentedString(bookTitle)).append("\n");
        sb.append("    borrowDate: ").append(toIndentedString(borrowDate)).append("\n");
        sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
        sb.append("    returnDate: ").append(toIndentedString(returnDate)).append("\n");
        sb.append("    loanStatus: ").append(toIndentedString(loanStatus)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}


