package com.dashboard.business_administration.infrastructure.database;

import com.dashboard.business_administration.domain.models.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MySqlCategoryRepository extends CrudRepository<Category, Long> {
    @Query(value = "select c from Category c where c.categoryName = ?1")
    Category getCategoryByName(String categoryName);
}
