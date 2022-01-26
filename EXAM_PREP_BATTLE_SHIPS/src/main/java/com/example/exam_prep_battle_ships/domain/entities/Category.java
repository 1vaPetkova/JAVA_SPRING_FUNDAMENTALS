package com.example.exam_prep_battle_ships.domain.entities;

import com.example.exam_prep_battle_ships.domain.entities.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private CategoryEnum name;
    private String description;

    public Category() {
    }

    @Column(unique = true, nullable = false)
    @Enumerated
    public CategoryEnum getName() {
        return name;
    }

    public Category setName(CategoryEnum name) {
        this.name = name;
        return this;
    }
    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
