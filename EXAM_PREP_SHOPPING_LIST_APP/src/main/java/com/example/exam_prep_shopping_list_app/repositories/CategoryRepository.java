package com.example.exam_prep_shopping_list_app.repositories;

import com.example.exam_prep_shopping_list_app.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
