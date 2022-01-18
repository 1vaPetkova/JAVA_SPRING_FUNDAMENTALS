package com.example.exam_prep_andreys.models.binding;

import com.example.exam_prep_andreys.models.entities.Category;
import com.example.exam_prep_andreys.models.entities.enums.CategoryNameEnum;
import com.example.exam_prep_andreys.models.entities.enums.GenderEnum;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemAddBindingModel {

    private String name;
    private String description;
    private BigDecimal price;
    private CategoryNameEnum category;
    private GenderEnum gender;

    public ItemAddBindingModel() {
    }

    @NotBlank(message = "Item name cannot be empty!")
    @Size(min = 2, message = "Item name must be more than 2 characters!")
    public String getName() {
        return name;
    }

    public ItemAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotBlank(message = "Item description cannot be empty!")
    @Size(min = 3, message = "Item description must be more than 2 characters!")
    public String getDescription() {
        return description;
    }

    public ItemAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @DecimalMin(value = "0", message = "Price must be positive number!")
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public ItemAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @NotNull(message = "Category cannot be empty!")
    public CategoryNameEnum getCategory() {
        return category;
    }

    public ItemAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
    @NotNull(message = "Gender cannot be empty!")
    public GenderEnum getGender() {
        return gender;
    }

    public ItemAddBindingModel setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }
}
