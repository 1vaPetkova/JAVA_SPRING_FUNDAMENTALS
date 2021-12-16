package com.example.java_spring_fund_lab_01.services.impl;

import com.example.java_spring_fund_lab_01.models.entities.Brand;
import com.example.java_spring_fund_lab_01.models.view.BrandViewDto;
import com.example.java_spring_fund_lab_01.models.view.ModelViewDto;
import com.example.java_spring_fund_lab_01.repositories.ModelRepository;
import com.example.java_spring_fund_lab_01.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewDto> getAllBrands() {
        List<BrandViewDto> result = new ArrayList<>();
        this.modelRepository.findAll()
                .forEach(model -> {
                    Brand brand = model.getBrand();
                    BrandViewDto brandViewDto = findByName(result, brand.getName());
                    if (brandViewDto == null) {
                        brandViewDto = this.modelMapper.map(brand, BrandViewDto.class);
                        result.add(brandViewDto);
                    }
                    ModelViewDto modelViewDto = this.modelMapper.map(model, ModelViewDto.class);
                    brandViewDto.addModel(modelViewDto);
                });
        return result;
    }

    private static BrandViewDto findByName(List<BrandViewDto> allModels, String name) {
        return allModels.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
