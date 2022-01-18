package com.example.exam_prep_andreys.services;

import com.example.exam_prep_andreys.models.binding.ItemAddBindingModel;
import com.example.exam_prep_andreys.models.entities.enums.CategoryNameEnum;
import com.example.exam_prep_andreys.models.entities.enums.GenderEnum;
import com.example.exam_prep_andreys.models.views.ItemViewModel;

import java.util.List;

public interface ItemService {
    boolean addItem(ItemAddBindingModel itemAddBindingModel);

     Long getTotalItems();

    List<ItemViewModel> findProductsByCategoryNameAndGender(CategoryNameEnum categoryNameEnum, GenderEnum genderEnum);
}
