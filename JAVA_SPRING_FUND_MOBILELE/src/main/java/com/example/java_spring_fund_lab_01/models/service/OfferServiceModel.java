package com.example.java_spring_fund_lab_01.models.service;

import com.example.java_spring_fund_lab_01.models.validation.YearInPastOrPresent;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class OfferServiceModel {

    private Long modelId;
    private BigDecimal price;
    private String engine;
    private String transmission;
    private Integer year;
    private Integer mileage;
    private String description;
    private String imageUrl;

    @NotNull
    public Long getModelId() {
        return modelId;
    }

    public OfferServiceModel setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    @DecimalMin("100")
    public BigDecimal getPrice() {
        return price;
    }

    public OfferServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @NotBlank
    public String getEngine() {
        return engine;
    }

    public OfferServiceModel setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    @NotBlank
    public String getTransmission() {
        return transmission;
    }

    public OfferServiceModel setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    @YearInPastOrPresent(minYear = 1930)
    public Integer getYear() {
        return year;
    }

    public OfferServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    @NotNull
    @Positive
    public Integer getMileage() {
        return mileage;
    }

    public OfferServiceModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    @NotBlank
    public String getDescription() {
        return description;
    }

    public OfferServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotBlank
    public String getImageUrl() {
        return imageUrl;
    }

    public OfferServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Override
    public String toString() {
        return "OfferServiceModel{" +
                "modelId=" + modelId +
                ", price=" + price +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
