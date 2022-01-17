package com.example.exam_prep_shopping_list_app.services;

import com.example.exam_prep_shopping_list_app.models.binding.ProductAddBindingModel;

import java.math.BigDecimal;

public interface ProductService {
    void addProduct(ProductAddBindingModel productAddBindingModel);

    BigDecimal getTotalProductsPrice();
}
