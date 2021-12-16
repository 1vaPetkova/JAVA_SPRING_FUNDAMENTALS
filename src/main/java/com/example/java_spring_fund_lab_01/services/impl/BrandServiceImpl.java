package com.example.java_spring_fund_lab_01.services.impl;

import com.example.java_spring_fund_lab_01.models.view.BrandViewDto;
import com.example.java_spring_fund_lab_01.repositories.BrandRepository;
import com.example.java_spring_fund_lab_01.services.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandViewDto> getAllBrands() {

        return null;
    }
}
