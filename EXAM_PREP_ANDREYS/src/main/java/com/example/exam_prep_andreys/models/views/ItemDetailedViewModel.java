package com.example.exam_prep_andreys.models.views;

import com.example.exam_prep_andreys.models.entities.Category;
import com.example.exam_prep_andreys.models.entities.enums.CategoryNameEnum;
import com.example.exam_prep_andreys.models.entities.enums.GenderEnum;

import java.math.BigDecimal;

public class ItemDetailedViewModel {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private CategoryNameEnum categoryNameEnum;
    private GenderEnum gender;

    public ItemDetailedViewModel() {
    }

    public String getId() {
        return id;
    }

    public ItemDetailedViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemDetailedViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemDetailedViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemDetailedViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryNameEnum getCategoryNameEnum() {
        return categoryNameEnum;
    }

    public ItemDetailedViewModel setCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        this.categoryNameEnum = categoryNameEnum;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public ItemDetailedViewModel setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }
}
