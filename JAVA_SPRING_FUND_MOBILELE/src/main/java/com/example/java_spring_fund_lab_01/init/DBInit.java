package com.example.java_spring_fund_lab_01.init;


import com.example.java_spring_fund_lab_01.service.BrandService;
import com.example.java_spring_fund_lab_01.service.ModelService;
import com.example.java_spring_fund_lab_01.service.OfferService;
import com.example.java_spring_fund_lab_01.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final UserService userService;
    private final OfferService offerService;

    public DBInit(BrandService brandService, ModelService modelService, UserService userService,
        OfferService offerService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userService = userService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) throws Exception {
        brandService.initializeBrand();
        modelService.initializeModels();
        userService.initializeUsersAndRoles();
        offerService.initializeOffers();
    }
}
