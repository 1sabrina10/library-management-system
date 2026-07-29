package com.sabrina.librarymanagementsystem.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * BookRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-28T16:29:55.315664277+02:00[Europe/Andorra]", comments = "Generator version: 7.15.0")
public class BookRequest {

  private String title;

  private String isbn;

  private Integer publicationYear;

  private Long authorId;

  private Long categoryId;

  public BookRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BookRequest(String title, String isbn, Integer publicationYear, Long authorId, Long categoryId) {
    this.title = title;
    this.isbn = isbn;
    this.publicationYear = publicationYear;
    this.authorId = authorId;
    this.categoryId = categoryId;
  }

  public BookRequest title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  @NotNull @Size(min = 1, max = 255) 
  @Schema(name = "title", example = "Clean Code", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BookRequest isbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  /**
   * Get isbn
   * @return isbn
   */
  @NotNull @Size(min = 10, max = 20) 
  @Schema(name = "isbn", example = "9780132350884", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("isbn")
  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public BookRequest publicationYear(Integer publicationYear) {
    this.publicationYear = publicationYear;
    return this;
  }

  /**
   * Get publicationYear
   * minimum: 1900
   * @return publicationYear
   */
  @NotNull @Min(1900) 
  @Schema(name = "publicationYear", example = "2008", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("publicationYear")
  public Integer getPublicationYear() {
    return publicationYear;
  }

  public void setPublicationYear(Integer publicationYear) {
    this.publicationYear = publicationYear;
  }

  public BookRequest authorId(Long authorId) {
    this.authorId = authorId;
    return this;
  }

  /**
   * Get authorId
   * minimum: 1
   * @return authorId
   */
  @NotNull @Min(1L) 
  @Schema(name = "authorId", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("authorId")
  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }

  public BookRequest categoryId(Long categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * Get categoryId
   * minimum: 1
   * @return categoryId
   */
  @NotNull @Min(1L) 
  @Schema(name = "categoryId", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("categoryId")
  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookRequest bookRequest = (BookRequest) o;
    return Objects.equals(this.title, bookRequest.title) &&
        Objects.equals(this.isbn, bookRequest.isbn) &&
        Objects.equals(this.publicationYear, bookRequest.publicationYear) &&
        Objects.equals(this.authorId, bookRequest.authorId) &&
        Objects.equals(this.categoryId, bookRequest.categoryId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, isbn, publicationYear, authorId, categoryId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookRequest {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    isbn: ").append(toIndentedString(isbn)).append("\n");
    sb.append("    publicationYear: ").append(toIndentedString(publicationYear)).append("\n");
    sb.append("    authorId: ").append(toIndentedString(authorId)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
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

