package com.example.exam_prep_battle_ships.services;

import com.example.exam_prep_battle_ships.models.entities.Category;
import com.example.exam_prep_battle_ships.models.entities.enums.CategoryEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryEnum(CategoryEnum categoryEnum);
}
