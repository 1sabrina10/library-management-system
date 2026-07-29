package com.sabrina.librarymanagementsystem.controller;

import com.sabrina.librarymanagementsystem.controller.api.AuthorsApi;
import com.sabrina.librarymanagementsystem.controller.dto.AuthorRequest;
import com.sabrina.librarymanagementsystem.controller.dto.AuthorResponse;
import com.sabrina.librarymanagementsystem.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AuthorController implements AuthorsApi {

private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public ResponseEntity<List<AuthorResponse>> apiAuthorsGet() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @Override
    public ResponseEntity<Void> apiAuthorsIdDelete(Long id) {
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<AuthorResponse> apiAuthorsIdGet(Long id) {
        return ResponseEntity.ok(authorService.findById(id));
    }

    @Override
    public ResponseEntity<AuthorResponse> apiAuthorsIdPut(Long id, @Valid AuthorRequest authorRequest) {
       return ResponseEntity.ok(authorService.update(id, authorRequest));
    }

    @Override
    public ResponseEntity<AuthorResponse> apiAuthorsPost( @Valid AuthorRequest authorRequest) {
       return ResponseEntity.status(HttpStatus.CREATED)
               .body(authorService.createAuthor(authorRequest));
    }
}
