package com.dashboard.business_administration.application;

import com.dashboard.business_administration.domain.models.Category;
import com.dashboard.business_administration.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryUseCases {
    @Autowired private CategoryRepository repository;

    public Category saveCategory(String categoryName) {
        Category categoryByName = this.repository.getCategoryByName(categoryName);
        if(categoryByName != null) return null;
        Category categoryToSave = new Category(categoryName);
        repository.createCategory(categoryToSave);
        return categoryToSave;
    }

    public List<Category> getAllCategories() {
        return this.repository.getAllCategories();
    }

    public void deleteCategory(Long categoryId) {
        Category categoryToDelete = this.repository.getCategoryById(categoryId);
        if(categoryToDelete == null) return;
        this.repository.deleteCategory(categoryToDelete.getId());
    }

}
