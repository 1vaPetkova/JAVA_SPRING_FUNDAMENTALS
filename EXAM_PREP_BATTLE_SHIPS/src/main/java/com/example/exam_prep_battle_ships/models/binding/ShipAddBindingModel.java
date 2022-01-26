package com.example.exam_prep_battle_ships.models.binding;

import com.example.exam_prep_battle_ships.models.entities.enums.CategoryEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class ShipAddBindingModel {
    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private CategoryEnum category;

    public ShipAddBindingModel() {
    }

    @NotBlank(message = "Ship name cannot be empty!")
    @Size(min = 2, max = 10, message = "Ship name must be between 2 and 10 characters long!")
    public String getName() {
        return name;
    }

    public ShipAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull(message = "Health cannot be empty!")
    @Positive(message = "Health must be a positive value!")
    public Long getHealth() {
        return health;
    }

    public ShipAddBindingModel setHealth(Long health) {
        this.health = health;
        return this;
    }


    @NotNull(message = "Power cannot be empty!")
    @Positive(message = "Power must be a positive value!")
    public Long getPower() {
        return power;
    }

    public ShipAddBindingModel setPower(Long power) {
        this.power = power;
        return this;
    }

    @NotNull(message = "Date cannot be empty!")
    @PastOrPresent(message = "The created date cannot be in the future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getCreated() {
        return created;
    }

    public ShipAddBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    @NotNull(message = "Category cannot be empty!")
    public CategoryEnum getCategory() {
        return category;
    }

    public ShipAddBindingModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }
}
