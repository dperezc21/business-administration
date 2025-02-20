package com.dashboard.business_administration.domain.repositories;

import com.dashboard.business_administration.domain.models.Category;

import java.util.List;

public interface CategoryUseCaseRepository {
     Category saveCategory(String categoryName);
     List<Category> getAllCategories();
     void deleteCategory(Long categoryId);
     Category getCategoryById(Long categoryId);
}
