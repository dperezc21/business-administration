package com.dashboard.business_administration.application;

import com.dashboard.business_administration.domain.models.Category;
import com.dashboard.business_administration.domain.repositories.CategoryRepository;
import com.dashboard.business_administration.domain.repositories.CategoryUseCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class CategoryUseCases implements CategoryUseCaseRepository {
    @Autowired private CategoryRepository repository;

    @Override
    public Category saveCategory(String categoryName) {
        Category categoryByName = this.repository.getCategoryByName(categoryName);
        if(categoryByName != null) return null;
        Category categoryToSave = new Category(categoryName);
        repository.createCategory(categoryToSave);
        return categoryToSave;
    }

    @Override
    public List<Category> getAllCategories() {
        return this.repository.getAllCategories();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category categoryToDelete = this.repository.getCategoryById(categoryId);
        if(categoryToDelete == null) return;
        this.repository.deleteCategory(categoryToDelete.getId());
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return this.repository.getCategoryById(categoryId);
    }

}
