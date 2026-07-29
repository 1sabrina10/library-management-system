package com.sabrina.librarymanagementsystem.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.lang.Nullable;

import java.util.Objects;

/**
 * AuthorRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-28T17:23:10.024564934+02:00[Europe/Andorra]", comments = "Generator version: 7.15.0")
public class AuthorRequest {

  private String firstname;

  private String lastname;

  private @Nullable String biography;

  public AuthorRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AuthorRequest(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public AuthorRequest firstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  /**
   * Get firstname
   * @return firstname
   */
  @NotNull @Size(min = 2, max = 50) 
  @Schema(name = "firstname", example = "Robert", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("firstname")
  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public AuthorRequest lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  /**
   * Get lastname
   * @return lastname
   */
  @NotNull @Size(min = 2, max = 50) 
  @Schema(name = "lastname", example = "Martin", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lastname")
  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public AuthorRequest biography(@Nullable String biography) {
    this.biography = biography;
    return this;
  }

  /**
   * Get biography
   * @return biography
   */
  @Size(max = 1000) 
  @Schema(name = "biography", example = "Software engineer and author of Clean Code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("biography")
  public @Nullable String getBiography() {
    return biography;
  }

  public void setBiography(@Nullable String biography) {
    this.biography = biography;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthorRequest authorRequest = (AuthorRequest) o;
    return Objects.equals(this.firstname, authorRequest.firstname) &&
        Objects.equals(this.lastname, authorRequest.lastname) &&
        Objects.equals(this.biography, authorRequest.biography);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, biography);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthorRequest {\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    biography: ").append(toIndentedString(biography)).append("\n");
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

