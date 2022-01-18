package com.example.exam_prep_andreys.models.views;

import java.math.BigDecimal;

public class ItemViewModel {

    private String id;
    private String name;
    private BigDecimal price;

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
}
