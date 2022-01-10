package com.example.exam_prep_coffee_shop.services.impl;

import com.example.exam_prep_coffee_shop.models.entities.Category;
import com.example.exam_prep_coffee_shop.models.entities.enums.CategoryNameEnum;
import com.example.exam_prep_coffee_shop.repositories.CategoryRepository;
import com.example.exam_prep_coffee_shop.services.CategoryService;
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
        if (categoryRepository.count() != 0) {
            return;
        }
        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum);
                    switch (categoryNameEnum) {
                        case DRINK -> category.setNeededTime(1);
                        case COFFEE -> category.setNeededTime(2);
                        case OTHER -> category.setNeededTime(5);
                        case CAKE -> category.setNeededTime(10);
                    }
                    this.categoryRepository.save(category);
                });
    }

    @Override
    public Category findCategoryByCategoryEnum(CategoryNameEnum categoryNameEnum) {
        return this.categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
