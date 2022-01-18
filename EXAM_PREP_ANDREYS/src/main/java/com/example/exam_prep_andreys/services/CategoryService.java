package com.example.exam_prep_andreys.services;

import com.example.exam_prep_andreys.models.entities.Category;
import com.example.exam_prep_andreys.models.entities.enums.CategoryNameEnum;
import com.example.exam_prep_andreys.models.services.CategoryServiceModel;

public interface CategoryService {
    void initCategories();

    CategoryServiceModel findCategoryByCategoryName(CategoryNameEnum category);
}
