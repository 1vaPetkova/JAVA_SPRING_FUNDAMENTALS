package com.example.exam_prep_andreys.models.views;

import com.example.exam_prep_andreys.models.entities.Category;
import com.example.exam_prep_andreys.models.entities.enums.CategoryNameEnum;
import com.example.exam_prep_andreys.models.entities.enums.GenderEnum;

import java.math.BigDecimal;

public class ItemDetailedViewModel {


    private ItemViewModel itemViewModel;
    private String description;

    public ItemDetailedViewModel() {
    }

    public ItemDetailedViewModel(ItemViewModel itemViewModel, String description) {
        this.itemViewModel = itemViewModel;
        this.description = description;
    }

    public ItemViewModel getItemViewModel() {
        return itemViewModel;
    }

    public ItemDetailedViewModel setItemViewModel(ItemViewModel itemViewModel) {
        this.itemViewModel = itemViewModel;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemDetailedViewModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
