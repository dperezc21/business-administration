package com.dashboard.business_administration.application;

import com.dashboard.business_administration.domain.models.Category;
import com.dashboard.business_administration.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
