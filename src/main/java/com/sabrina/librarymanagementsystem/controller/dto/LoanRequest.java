package com.sabrina.librarymanagementsystem.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * LoanRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-08T22:13:59.993615634+02:00[Europe/Andorra]", comments = "Generator version: 7.15.0")
public class LoanRequest {

  private Long bookId;

  public LoanRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LoanRequest(Long bookId) {
    this.bookId = bookId;
  }

  public LoanRequest bookId(Long bookId) {
    this.bookId = bookId;
    return this;
  }

  /**
   * Get bookId
   * minimum: 1
   * @return bookId
   */
  @NotNull @Min(1L) 
  @Schema(name = "bookId", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bookId")
  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoanRequest loanRequest = (LoanRequest) o;
    return Objects.equals(this.bookId, loanRequest.bookId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoanRequest {\n");
    sb.append("    bookId: ").append(toIndentedString(bookId)).append("\n");
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

