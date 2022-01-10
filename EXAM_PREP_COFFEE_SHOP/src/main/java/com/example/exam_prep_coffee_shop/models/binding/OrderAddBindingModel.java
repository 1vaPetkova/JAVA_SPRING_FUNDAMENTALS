package com.example.exam_prep_coffee_shop.models.binding;

import com.example.exam_prep_coffee_shop.models.entities.Category;
import com.example.exam_prep_coffee_shop.models.entities.User;
import com.example.exam_prep_coffee_shop.models.entities.enums.CategoryNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.Instant;

public class OrderAddBindingModel {

    private String name;
    private BigDecimal price;
    private Instant orderTime;
    private CategoryNameEnum category;
    private String description;


    public OrderAddBindingModel() {
    }

    @NotBlank
    @Size(min = 3, max = 20)
    public String getName() {
        return name;
    }

    public OrderAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Positive
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public OrderAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @PastOrPresent
    @DateTimeFormat(pattern = "dd/mm/yyyy, HH:mm")
    public Instant getOrderTime() {
        return orderTime;
    }

    public OrderAddBindingModel setOrderTime(Instant orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    @NotNull
    public CategoryNameEnum getCategory() {
        return category;
    }

    public OrderAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public OrderAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
