package com.example.java_spring_fund_lab_01.models.view;

import com.example.java_spring_fund_lab_01.models.entities.enums.EngineEnum;
import com.example.java_spring_fund_lab_01.models.entities.enums.TransmissionEnum;

import java.math.BigDecimal;

public class OfferSummaryViewModel {

    private EngineEnum engineType;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private Integer year;
    private TransmissionEnum transmissionType;

    public EngineEnum getEngineType() {
        return engineType;
    }

    public OfferSummaryViewModel setEngineType(EngineEnum engineType) {
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

    public TransmissionEnum getTransmissionType() {
        return transmissionType;
    }

    public OfferSummaryViewModel setTransmissionType(TransmissionEnum transmissionType) {
        this.transmissionType = transmissionType;
        return this;
    }
}
