package com.example.java_spring_fund_lab_01.models.view;

import com.example.java_spring_fund_lab_01.models.entities.enums.Engine;
import com.example.java_spring_fund_lab_01.models.entities.enums.Transmission;

import java.math.BigDecimal;

public class OfferSummaryViewDto {

    private Engine engineType;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private Integer year;
    private Transmission transmissionType;

    public Engine getEngineType() {
        return engineType;
    }

    public OfferSummaryViewDto setEngineType(Engine engineType) {
        this.engineType = engineType;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryViewDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferSummaryViewDto setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferSummaryViewDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferSummaryViewDto setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Transmission getTransmissionType() {
        return transmissionType;
    }

    public OfferSummaryViewDto setTransmissionType(Transmission transmissionType) {
        this.transmissionType = transmissionType;
        return this;
    }
}
