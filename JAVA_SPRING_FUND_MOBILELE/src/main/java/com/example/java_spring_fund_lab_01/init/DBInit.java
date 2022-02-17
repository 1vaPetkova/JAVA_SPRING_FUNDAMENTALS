package com.example.java_spring_fund_lab_01.init;

import com.example.java_spring_fund_lab_01.services.BrandService;
import com.example.java_spring_fund_lab_01.services.ModelService;
import com.example.java_spring_fund_lab_01.services.OfferService;
import com.example.java_spring_fund_lab_01.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final UserService userService;
    private final OfferService offerService;

    public DBInit(BrandService brandService, ModelService modelService, UserService userService, OfferService offerService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userService = userService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.brandService.initializeBrand();
        this.modelService.initializeModels();
        this.userService.initializeUsersAndRoles();
        this.offerService.initializeOffers();
    }
}
