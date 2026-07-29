package com.sabrina.librarymanagementsystem.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import org.springframework.lang.Nullable;

import java.util.Objects;

/**
 * AuthorResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-27T12:11:03.014051287+02:00[Europe/Andorra]", comments = "Generator version: 7.15.0")
public class AuthorResponse {

  private @Nullable Long id;

  private @Nullable String firstname;

  private @Nullable String lastname;

  private @Nullable String biography;

  public AuthorResponse id(@Nullable Long id) {
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

  public AuthorResponse firstname(@Nullable String firstname) {
    this.firstname = firstname;
    return this;
  }

  /**
   * Get firstname
   * @return firstname
   */
  
  @Schema(name = "firstname", example = "Robert", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstname")
  public @Nullable String getFirstname() {
    return firstname;
  }

  public void setFirstname(@Nullable String firstname) {
    this.firstname = firstname;
  }

  public AuthorResponse lastname(@Nullable String lastname) {
    this.lastname = lastname;
    return this;
  }

  /**
   * Get lastname
   * @return lastname
   */
  
  @Schema(name = "lastname", example = "Martin", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastname")
  public @Nullable String getLastname() {
    return lastname;
  }

  public void setLastname(@Nullable String lastname) {
    this.lastname = lastname;
  }

  public AuthorResponse biography(@Nullable String biography) {
    this.biography = biography;
    return this;
  }

  /**
   * Get biography
   * @return biography
   */
  
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
    AuthorResponse authorResponse = (AuthorResponse) o;
    return Objects.equals(this.id, authorResponse.id) &&
        Objects.equals(this.firstname, authorResponse.firstname) &&
        Objects.equals(this.lastname, authorResponse.lastname) &&
        Objects.equals(this.biography, authorResponse.biography);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, biography);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthorResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

