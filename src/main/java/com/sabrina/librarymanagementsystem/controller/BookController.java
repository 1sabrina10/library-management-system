package com.sabrina.librarymanagementsystem.controller;

import com.sabrina.librarymanagementsystem.controller.api.BooksApi;
import com.sabrina.librarymanagementsystem.controller.dto.BookRequest;
import com.sabrina.librarymanagementsystem.controller.dto.BookResponse;
import com.sabrina.librarymanagementsystem.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BookController implements BooksApi {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @Override
    public ResponseEntity<List<BookResponse>> apiBooksGet() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @Override
    public ResponseEntity<Void> apiBooksIdDelete(Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<BookResponse> apiBooksIdGet(Long id) {
        return ResponseEntity.ok(bookService.findById(id)
        );
    }

    @Override
    public ResponseEntity<BookResponse> apiBooksIdPut(Long id, @Valid BookRequest bookRequest) {
        return ResponseEntity.ok(bookService.update(id, bookRequest)
        );
    }

    @Override
    public ResponseEntity<BookResponse> apiBooksPost( @Valid BookRequest bookRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookService.createBook(bookRequest));
    }
}
