package com.example.exam_prep_andreys.models.views;

import com.example.exam_prep_andreys.models.entities.enums.CategoryNameEnum;
import com.example.exam_prep_andreys.models.entities.enums.GenderEnum;

import java.math.BigDecimal;

public class ItemViewModel {

    private String id;
    private String name;
    private BigDecimal price;
    private String imageUrl;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public ItemViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
