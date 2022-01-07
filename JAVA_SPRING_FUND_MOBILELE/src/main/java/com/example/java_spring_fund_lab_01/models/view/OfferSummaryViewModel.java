package com.example.java_spring_fund_lab_01.models.view;

import com.example.java_spring_fund_lab_01.models.entities.enums.Engine;
import com.example.java_spring_fund_lab_01.models.entities.enums.Transmission;

import java.math.BigDecimal;

public class OfferSummaryViewModel {

    private Engine engineType;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private Integer year;
    private Transmission transmissionType;

    public Engine getEngineType() {
        return engineType;
    }

    public OfferSummaryViewModel setEngineType(Engine engineType) {
        this.engineType = engineType;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferSummaryViewModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferSummaryViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferSummaryViewModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Transmission getTransmissionType() {
        return transmissionType;
    }

    public OfferSummaryViewModel setTransmissionType(Transmission transmissionType) {
        this.transmissionType = transmissionType;
        return this;
    }
}
