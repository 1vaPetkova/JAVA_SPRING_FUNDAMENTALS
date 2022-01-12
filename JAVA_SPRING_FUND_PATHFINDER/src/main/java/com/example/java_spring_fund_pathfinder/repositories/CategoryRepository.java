package com.example.java_spring_fund_pathfinder.repositories;

import com.example.java_spring_fund_pathfinder.models.entities.Category;
import com.example.java_spring_fund_pathfinder.models.entities.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryNameEnum name);
}
