package com.example.java_spring_fund_lab_01.services;

import com.example.java_spring_fund_lab_01.models.view.BrandViewDto;

import java.util.List;

public interface BrandService {
    List<BrandViewDto> getAllBrands();
}
