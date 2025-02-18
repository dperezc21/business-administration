package com.dashboard.business_administration.infrastructure;

import com.dashboard.business_administration.domain.models.Category;
import com.dashboard.business_administration.domain.repositories.CategoryRepository;
import com.dashboard.business_administration.infrastructure.database.MySqlCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryImplementationRepository implements CategoryRepository {

    @Autowired
    private MySqlCategoryRepository categoryRepository;

    @Override
    public void createCategory(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return this.categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) this.categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return this.categoryRepository.getCategoryByName(categoryName);
    }
}
