package com.sabrina.librarymanagementsystem.service;

import com.sabrina.librarymanagementsystem.controller.dto.AuthorRequest;
import com.sabrina.librarymanagementsystem.controller.dto.AuthorResponse;
import com.sabrina.librarymanagementsystem.entity.Author;
import com.sabrina.librarymanagementsystem.exception.ResourceNotFoundException;
import com.sabrina.librarymanagementsystem.mapper.AuthorMapper;
import com.sabrina.librarymanagementsystem.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public AuthorResponse createAuthor(AuthorRequest request) {

        Author author = new Author();

        author.setFirstname(request.getFirstname());
        author.setLastname(request.getLastname());
        author.setBiography(request.getBiography());

        Author savedAuthor = authorRepository.save(author);

        return authorMapper.toResponse(savedAuthor);

    }

    public List<AuthorResponse> findAll() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toResponse)
                .toList();
    }

    public AuthorResponse findById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));

        return authorMapper.toResponse(author);
    }

    public AuthorResponse update(Long id, AuthorRequest request) {

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));

        author.setFirstname(request.getFirstname());
        author.setLastname(request.getLastname());
        author.setBiography(request.getBiography());

        Author updatedAuthor = authorRepository.save(author);

        return authorMapper.toResponse(updatedAuthor);
    }

    public void delete(Long id) {

        Author author = authorRepository.findById(id)
                       .orElseThrow(() -> new ResourceNotFoundException("Author not found"));

        authorRepository.delete(author);
    }
}
