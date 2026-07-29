package com.sabrina.librarymanagementsystem.controller;

import com.sabrina.librarymanagementsystem.controller.api.CategoriesApi;

import com.sabrina.librarymanagementsystem.controller.dto.CategoryRequest;
import com.sabrina.librarymanagementsystem.controller.dto.CategoryResponse;
import com.sabrina.librarymanagementsystem.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CategoryController implements CategoriesApi {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<List<CategoryResponse>> apiCategoriesGet() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @Override
    public ResponseEntity<Void> apiCategoriesIdDelete(Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CategoryResponse> apiCategoriesIdGet(Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @Override
    public ResponseEntity<CategoryResponse> apiCategoriesIdPut(Long id, @Valid CategoryRequest categoryRequest) {
        return ResponseEntity.ok(categoryService.update(id, categoryRequest));
    }

    @Override
    public ResponseEntity<CategoryResponse> apiCategoriesPost(@Valid CategoryRequest categoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryService.createCategory(categoryRequest));
    }
}
