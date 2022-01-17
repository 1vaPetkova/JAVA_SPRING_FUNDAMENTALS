package com.example.exam_prep_shopping_list_app.services.impl;

import com.example.exam_prep_shopping_list_app.models.binding.ProductAddBindingModel;
import com.example.exam_prep_shopping_list_app.models.entities.Product;
import com.example.exam_prep_shopping_list_app.models.services.ProductServiceModel;
import com.example.exam_prep_shopping_list_app.repositories.ProductRepository;
import com.example.exam_prep_shopping_list_app.services.CategoryService;
import com.example.exam_prep_shopping_list_app.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addProduct(ProductAddBindingModel productAddBindingModel) {
        ProductServiceModel productServiceModel = this.modelMapper.map(productAddBindingModel, ProductServiceModel.class);
        productServiceModel
                .setCategory(
                        this.categoryService
                                .findCategoryByCategoryEnum(productAddBindingModel.getCategory()));
        this.productRepository.save(this.modelMapper.map(productServiceModel, Product.class));
    }
}
