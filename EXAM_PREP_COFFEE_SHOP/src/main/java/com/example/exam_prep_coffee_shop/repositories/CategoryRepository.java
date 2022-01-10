package com.example.exam_prep_coffee_shop.repositories;

import com.example.exam_prep_coffee_shop.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
