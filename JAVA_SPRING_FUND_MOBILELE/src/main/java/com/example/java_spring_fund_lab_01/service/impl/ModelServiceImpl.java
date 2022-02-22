package com.example.java_spring_fund_lab_01.service.impl;


import java.util.List;

import com.example.java_spring_fund_lab_01.model.entity.BrandEntity;
import com.example.java_spring_fund_lab_01.model.entity.ModelEntity;
import com.example.java_spring_fund_lab_01.model.entity.enums.CategoryEnum;
import com.example.java_spring_fund_lab_01.repository.BrandRepository;
import com.example.java_spring_fund_lab_01.repository.ModelRepository;
import com.example.java_spring_fund_lab_01.service.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void initializeModels() {
        if (modelRepository.count() == 0) {
            BrandEntity ford = brandRepository.findByName("Ford")
                    .orElseThrow(IllegalArgumentException::new);

            ModelEntity fiesta = new ModelEntity();
            fiesta
                    .setName("Fiesta")
                    .setCategory(CategoryEnum.CAR)
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/1920px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg")
                    .setStartYear(1976)
                    .setBrand(ford);

            ModelEntity escort = new ModelEntity();
            escort
                    .setName("Escort")
                    .setCategory(CategoryEnum.CAR)
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Ford_Escort_RS2000_MkI.jpg/420px-Ford_Escort_RS2000_MkI.jpg")
                    .setStartYear(1967)
                    .setEndYear(2004)
                    .setBrand(ford);

            modelRepository.saveAll(List.of(fiesta, escort));
        }
    }
}
