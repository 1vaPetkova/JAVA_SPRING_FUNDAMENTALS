package com.example.exam_prep_andreys.repositories;

import com.example.exam_prep_andreys.models.entities.Category;
import com.example.exam_prep_andreys.models.entities.enums.CategoryNameEnum;
import com.example.exam_prep_andreys.models.services.CategoryServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByName(CategoryNameEnum name);
}
