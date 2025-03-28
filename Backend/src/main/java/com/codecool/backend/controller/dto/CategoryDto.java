package com.codecool.backend.controller.dto;

import com.codecool.backend.model.Category;

public record CategoryDto(Long id, Category.CategoryType categoryType, String description) {
    public CategoryDto(Category category) {
        this(category.getId(), category.getType(), category.getDescription());
    }
}
