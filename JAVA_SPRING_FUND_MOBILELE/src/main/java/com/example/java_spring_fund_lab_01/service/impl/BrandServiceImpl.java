package com.example.java_spring_fund_lab_01.service.impl;


import com.example.java_spring_fund_lab_01.model.entity.BrandEntity;
import com.example.java_spring_fund_lab_01.model.entity.ModelEntity;
import com.example.java_spring_fund_lab_01.model.view.BrandViewModel;
import com.example.java_spring_fund_lab_01.model.view.ModelViewModel;
import com.example.java_spring_fund_lab_01.repository.BrandRepository;
import com.example.java_spring_fund_lab_01.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeBrand() {
        if (brandRepository.count() == 0) {
            BrandEntity ford = new BrandEntity();
            ford.setName("Ford");

            brandRepository.save(ford);
        }
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(brandEntity -> {
                    BrandViewModel brandViewModel = new BrandViewModel().
                        setName(brandEntity.getName());

                    brandViewModel.setModels(
                        brandEntity.
                            getModels().
                            stream().
                            map(this::map).
                            collect(Collectors.toList()));
                    return brandViewModel;
                })
                .collect(Collectors.toList());
    }

    private ModelViewModel map(ModelEntity modelEntity) {
        return modelMapper.map(modelEntity, ModelViewModel.class);
    }
}
