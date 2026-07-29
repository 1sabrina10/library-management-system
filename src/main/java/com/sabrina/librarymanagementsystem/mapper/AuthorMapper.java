package com.sabrina.librarymanagementsystem.mapper;

import com.sabrina.librarymanagementsystem.controller.dto.AuthorResponse;
import com.sabrina.librarymanagementsystem.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorResponse toResponse(Author author){

        AuthorResponse response = new AuthorResponse();
        response.setId(author.getId());
        response.setFirstname(author.getFirstname());
        response.setLastname(author.getLastname());
        response.setBiography(author.getBiography());

        return response;

    }

}
