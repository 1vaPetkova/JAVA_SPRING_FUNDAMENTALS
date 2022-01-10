package com.example.exam_prep_coffee_shop.models.entities;

import com.example.exam_prep_coffee_shop.models.entities.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private CategoryNameEnum name;
    private Integer neededTime;

    public Category() {
    }


    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    @Column(name = "needed_time",nullable = false)
    public Integer getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
