package com.example.exam_prep_andreys.services;

import com.example.exam_prep_andreys.models.binding.ItemAddBindingModel;

public interface ItemService {
    boolean addItem(ItemAddBindingModel itemAddBindingModel);

    Long getTotalItems();
}
