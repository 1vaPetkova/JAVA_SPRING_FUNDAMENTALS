package com.example.java_spring_fund_pathfinder.services.impl;

import com.example.java_spring_fund_pathfinder.models.entities.Category;
import com.example.java_spring_fund_pathfinder.models.entities.enums.CategoryNameEnum;
import com.example.java_spring_fund_pathfinder.repositories.CategoryRepository;
import com.example.java_spring_fund_pathfinder.services.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return this.categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
