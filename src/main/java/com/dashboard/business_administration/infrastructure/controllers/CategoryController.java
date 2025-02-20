package com.dashboard.business_administration.infrastructure.controllers;

import com.dashboard.business_administration.domain.models.Category;
import com.dashboard.business_administration.domain.repositories.CategoryUseCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired private CategoryUseCaseRepository categoryCaseRepository;

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category category1 = this.categoryCaseRepository.saveCategory(category.getCategoryName());
        return ResponseEntity.ok(category1);
    }
}
