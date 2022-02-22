package com.example.java_spring_fund_lab_01.service;



import com.example.java_spring_fund_lab_01.model.view.BrandViewModel;

import java.util.List;

public interface BrandService {

    void initializeBrand();

    List<BrandViewModel> getAllBrands();
}
