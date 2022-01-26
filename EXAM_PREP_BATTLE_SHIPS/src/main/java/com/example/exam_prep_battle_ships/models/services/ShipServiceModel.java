package com.example.exam_prep_battle_ships.models.services;

import com.example.exam_prep_battle_ships.models.entities.Category;
import com.example.exam_prep_battle_ships.models.entities.enums.CategoryEnum;

import java.time.LocalDate;

public class ShipServiceModel extends BaseServiceModel {

    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private CategoryEnum category;

    public ShipServiceModel() {
    }

    public String getName() {
        return name;
    }

    public ShipServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipServiceModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipServiceModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipServiceModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ShipServiceModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }
}
