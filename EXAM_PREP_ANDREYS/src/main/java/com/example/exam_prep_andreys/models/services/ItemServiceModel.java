package com.example.exam_prep_andreys.models.services;

import com.example.exam_prep_andreys.models.entities.enums.CategoryNameEnum;
import com.example.exam_prep_andreys.models.entities.enums.GenderEnum;

import java.math.BigDecimal;

public class ItemServiceModel {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private CategoryNameEnum category;
    private GenderEnum gender;

    public ItemServiceModel() {
    }

    public String getId() {
        return id;
    }

    public ItemServiceModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ItemServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public ItemServiceModel setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }
}
