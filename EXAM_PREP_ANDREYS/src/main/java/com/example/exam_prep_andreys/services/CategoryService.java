package com.example.exam_prep_andreys.services;

import com.example.exam_prep_andreys.models.entities.Category;
import com.example.exam_prep_andreys.models.entities.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findCategoryByCategoryName(CategoryNameEnum category);
}
