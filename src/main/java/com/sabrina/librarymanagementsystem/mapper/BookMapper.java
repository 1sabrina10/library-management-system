package com.sabrina.librarymanagementsystem.mapper;

import com.sabrina.librarymanagementsystem.controller.dto.BookResponse;
import com.sabrina.librarymanagementsystem.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public  BookResponse toResponse(Book book) {

        BookResponse response = new BookResponse();

        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setIsbn(book.getIsbn());
        response.setPublicationYear(book.getPublicationYear());
        response.setAvailable(book.getAvailable());

        if(book.getAuthor() != null) {

            response.setAuthorName(
                    book.getAuthor().getFirstname()
                            + " "
                            + book.getAuthor().getLastname()
            );
        }

        if(book.getCategory() != null) {
            response.setCategoryName(
                    book.getCategory().getName()
            );
        }

        return response;
    }
}
