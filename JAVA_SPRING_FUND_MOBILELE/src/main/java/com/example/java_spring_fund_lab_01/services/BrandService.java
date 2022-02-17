package com.example.java_spring_fund_lab_01.services;

import com.example.java_spring_fund_lab_01.models.view.BrandViewModel;

import java.util.List;

public interface BrandService {

    void initializeBrand();

    List<BrandViewModel> getAllBrands();

}
