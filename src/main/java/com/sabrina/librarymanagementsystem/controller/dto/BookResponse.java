package com.sabrina.librarymanagementsystem.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import org.springframework.lang.Nullable;

import java.util.Objects;

/**
 * BookResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-26T19:55:51.535413611+02:00[Europe/Andorra]", comments = "Generator version: 7.15.0")
public class BookResponse {

  private @Nullable Long id;

  private @Nullable String title;

  private @Nullable String isbn;

  private @Nullable Integer publicationYear;

  private @Nullable Boolean available;

  private @Nullable String authorName;

  private @Nullable String categoryName;

  public BookResponse id(@Nullable Long id) {
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

  public BookResponse title(@Nullable String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  
  @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public @Nullable String getTitle() {
    return title;
  }

  public void setTitle(@Nullable String title) {
    this.title = title;
  }

  public BookResponse isbn(@Nullable String isbn) {
    this.isbn = isbn;
    return this;
  }

  /**
   * Get isbn
   * @return isbn
   */
  
  @Schema(name = "isbn", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isbn")
  public @Nullable String getIsbn() {
    return isbn;
  }

  public void setIsbn(@Nullable String isbn) {
    this.isbn = isbn;
  }

  public BookResponse publicationYear(@Nullable Integer publicationYear) {
    this.publicationYear = publicationYear;
    return this;
  }

  /**
   * Get publicationYear
   * @return publicationYear
   */
  
  @Schema(name = "publicationYear", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("publicationYear")
  public @Nullable Integer getPublicationYear() {
    return publicationYear;
  }

  public void setPublicationYear(@Nullable Integer publicationYear) {
    this.publicationYear = publicationYear;
  }

  public BookResponse available(@Nullable Boolean available) {
    this.available = available;
    return this;
  }

  /**
   * Get available
   * @return available
   */
  
  @Schema(name = "available", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("available")
  public @Nullable Boolean getAvailable() {
    return available;
  }

  public void setAvailable(@Nullable Boolean available) {
    this.available = available;
  }

  public BookResponse authorName(@Nullable String authorName) {
    this.authorName = authorName;
    return this;
  }

  /**
   * Get authorName
   * @return authorName
   */
  
  @Schema(name = "authorName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("authorName")
  public @Nullable String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(@Nullable String authorName) {
    this.authorName = authorName;
  }

  public BookResponse categoryName(@Nullable String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  /**
   * Get categoryName
   * @return categoryName
   */
  
  @Schema(name = "categoryName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categoryName")
  public @Nullable String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(@Nullable String categoryName) {
    this.categoryName = categoryName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookResponse bookResponse = (BookResponse) o;
    return Objects.equals(this.id, bookResponse.id) &&
        Objects.equals(this.title, bookResponse.title) &&
        Objects.equals(this.isbn, bookResponse.isbn) &&
        Objects.equals(this.publicationYear, bookResponse.publicationYear) &&
        Objects.equals(this.available, bookResponse.available) &&
        Objects.equals(this.authorName, bookResponse.authorName) &&
        Objects.equals(this.categoryName, bookResponse.categoryName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, isbn, publicationYear, available, authorName, categoryName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    isbn: ").append(toIndentedString(isbn)).append("\n");
    sb.append("    publicationYear: ").append(toIndentedString(publicationYear)).append("\n");
    sb.append("    available: ").append(toIndentedString(available)).append("\n");
    sb.append("    authorName: ").append(toIndentedString(authorName)).append("\n");
    sb.append("    categoryName: ").append(toIndentedString(categoryName)).append("\n");
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

