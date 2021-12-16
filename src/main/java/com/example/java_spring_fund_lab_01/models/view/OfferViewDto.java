package com.example.java_spring_fund_lab_01.models.view;

import com.example.java_spring_fund_lab_01.models.entities.enums.Engine;
import com.example.java_spring_fund_lab_01.models.entities.enums.Transmission;

import java.math.BigDecimal;

public class OfferViewDto {

    private Integer offerYear;
    private String brandName;
    private String modelName;
    private Integer mileage;
    private BigDecimal price;
    private Engine engineType;
    private Transmission transmissionType;
}
