package com.sabrina.librarymanagementsystem.mapper;

import com.sabrina.librarymanagementsystem.controller.dto.CategoryResponse;
import com.sabrina.librarymanagementsystem.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryResponse toResponse(Category category) {

        CategoryResponse response = new CategoryResponse();

        response.setId(category.getId());
        response.setName(category.getName());

        return response;
    }
}
