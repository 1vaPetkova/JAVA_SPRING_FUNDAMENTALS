package com.example.exam_prep_andreys.models.services;

import com.example.exam_prep_andreys.models.entities.enums.CategoryNameEnum;

public class CategoryServiceModel {

    private String id;
    private CategoryNameEnum name;
    private String description;

    public CategoryServiceModel() {
    }

    public String getId() {
        return id;
    }

    public CategoryServiceModel setId(String id) {
        this.id = id;
        return this;
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public CategoryServiceModel setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
