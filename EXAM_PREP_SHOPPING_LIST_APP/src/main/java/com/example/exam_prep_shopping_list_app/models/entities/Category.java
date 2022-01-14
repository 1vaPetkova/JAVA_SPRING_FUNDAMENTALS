package com.example.exam_prep_shopping_list_app.models.entities;

import com.example.exam_prep_shopping_list_app.models.entities.enums.CategoryEnum;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private CategoryEnum name;
    private String description;

    public Category() {
    }

    public CategoryEnum getName() {
        return name;
    }

    public Category setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}

