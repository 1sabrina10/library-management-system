package com.sabrina.librarymanagementsystem.service;

import com.sabrina.librarymanagementsystem.controller.dto.BookRequest;
import com.sabrina.librarymanagementsystem.controller.dto.BookResponse;
import com.sabrina.librarymanagementsystem.entity.Author;
import com.sabrina.librarymanagementsystem.entity.Book;
import com.sabrina.librarymanagementsystem.entity.Category;
import com.sabrina.librarymanagementsystem.exception.ResourceNotFoundException;
import com.sabrina.librarymanagementsystem.mapper.BookMapper;
import com.sabrina.librarymanagementsystem.repository.AuthorRepository;
import com.sabrina.librarymanagementsystem.repository.BookRepository;
import com.sabrina.librarymanagementsystem.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookMapper bookMapper;


    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.bookMapper = bookMapper;
    }

    public BookResponse createBook(BookRequest request){

        if(bookRepository.existsByIsbn(request.getIsbn())){
            throw new RuntimeException("ISBN already exists");
        }

        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(()-> new ResourceNotFoundException("Author not found"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(()-> new ResourceNotFoundException("Category not found"));

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setPublicationYear(request.getPublicationYear());
        book.setAvailable(true);
        book.setAuthor(author);
        book.setCategory(category);

        Book savedBook = bookRepository.save(book);
       return bookMapper.toResponse(savedBook);
    }

    public List<BookResponse> findAll(){
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toResponse)
                .toList();
    }

    public BookResponse findById(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Book not found"));
        return bookMapper.toResponse(book);
    }

    public BookResponse update(Long id, BookRequest request){
        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Book not found"));

        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(()-> new ResourceNotFoundException("Author not found"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(()-> new ResourceNotFoundException("Category not found"));

        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setPublicationYear(request.getPublicationYear());
        book.setAuthor(author);
        book.setCategory(category);
        Book updatedBook = bookRepository.save(book);
        return bookMapper.toResponse(updatedBook);
    }

    public void delete (Long id){
        if(!bookRepository.existsById(id)){
            throw new ResourceNotFoundException("Book not found");
        }
        bookRepository.deleteById(id);
    }



}
