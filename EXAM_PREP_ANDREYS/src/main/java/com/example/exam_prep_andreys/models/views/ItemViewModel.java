package com.example.exam_prep_andreys.models.views;

import com.example.exam_prep_andreys.models.entities.enums.CategoryNameEnum;
import com.example.exam_prep_andreys.models.entities.enums.GenderEnum;

import java.math.BigDecimal;

public class ItemViewModel {

    private String id;
    private String name;
    private BigDecimal price;
    private CategoryNameEnum categoryNameEnum;
    private GenderEnum gender;

    public ItemViewModel() {
    }

    public String getId() {
        return id;
    }

    public ItemViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryNameEnum getCategoryNameEnum() {
        return categoryNameEnum;
    }

    public ItemViewModel setCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        this.categoryNameEnum = categoryNameEnum;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public ItemViewModel setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }
}
