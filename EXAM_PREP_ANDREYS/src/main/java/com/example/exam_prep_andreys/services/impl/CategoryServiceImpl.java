package com.example.exam_prep_andreys.services.impl;

import com.example.exam_prep_andreys.models.entities.Category;
import com.example.exam_prep_andreys.models.entities.enums.CategoryNameEnum;
import com.example.exam_prep_andreys.models.services.CategoryServiceModel;
import com.example.exam_prep_andreys.repositories.CategoryRepository;
import com.example.exam_prep_andreys.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initCategories() {
        if (this.categoryRepository.count() != 0) {
            return;
        }
        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category(categoryNameEnum, categoryNameEnum.name() + " description");
                    this.categoryRepository.save(category);
                });
    }

    @Override
    public CategoryServiceModel findCategoryByCategoryName(CategoryNameEnum category) {
        return this.categoryRepository.findByName(category)
                .map(cat -> this.modelMapper.map(cat,CategoryServiceModel.class))
                .orElse(null);
    }
}
