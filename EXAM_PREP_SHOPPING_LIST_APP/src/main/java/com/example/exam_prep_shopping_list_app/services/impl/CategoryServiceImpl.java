package com.example.exam_prep_shopping_list_app.services.impl;

import com.example.exam_prep_shopping_list_app.models.entities.Category;
import com.example.exam_prep_shopping_list_app.models.entities.enums.CategoryEnum;
import com.example.exam_prep_shopping_list_app.repositories.CategoryRepository;
import com.example.exam_prep_shopping_list_app.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void initCategories() {
        if (this.categoryRepository.count() != 0) {
            return;
        }
        Arrays.stream(CategoryEnum.values()).forEach(categoryEnum -> {
            Category category = new Category(categoryEnum);
            switch (categoryEnum) {
                case FOOD -> category.setDescription("Home food groceries");
                case DRINK -> category.setDescription("Home drinks");
                case HOUSEHOLD -> category.setDescription("Household stuff");
                case OTHER -> category.setDescription("Other stuff");
            }
            this.categoryRepository.save(category);
        });
    }
}
