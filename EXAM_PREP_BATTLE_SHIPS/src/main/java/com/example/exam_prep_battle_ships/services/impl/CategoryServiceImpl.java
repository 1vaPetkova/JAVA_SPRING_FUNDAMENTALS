package com.example.exam_prep_battle_ships.services.impl;

import com.example.exam_prep_battle_ships.models.entities.Category;
import com.example.exam_prep_battle_ships.models.entities.enums.CategoryEnum;
import com.example.exam_prep_battle_ships.repositories.CategoryRepository;
import com.example.exam_prep_battle_ships.services.CategoryService;
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
        if (this.categoryRepository.count() == 0) {
            Arrays.stream(CategoryEnum.values()).forEach(categoryEnum ->
                    this.categoryRepository
                            .save(new Category(categoryEnum, categoryEnum.name() + " description"))
            );
        }
    }

    @Override
    public Category findByCategoryEnum(CategoryEnum categoryEnum) {
        return this.categoryRepository.findByName(categoryEnum).orElse(null);
    }
}
