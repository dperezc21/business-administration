package com.dashboard.business_administration.domain.repositories;

import com.dashboard.business_administration.domain.models.Category;

import java.util.List;

public interface CategoryRepository {
    void createCategory(Category category);
    Category getCategoryById(Long categoryId);
    List<Category> getAllCategories();
    void deleteCategory(Long categoryId);
    Category getCategoryByName(String categoryName);
}
