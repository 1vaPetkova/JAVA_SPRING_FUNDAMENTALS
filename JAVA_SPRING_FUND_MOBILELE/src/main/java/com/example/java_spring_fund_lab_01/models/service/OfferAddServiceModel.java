package com.example.java_spring_fund_lab_01.models.service;

import com.example.java_spring_fund_lab_01.models.entities.enums.Engine;
import com.example.java_spring_fund_lab_01.models.entities.enums.Transmission;
import com.example.java_spring_fund_lab_01.models.validation.YearInPastOrPresent;


import javax.validation.constraints.*;
import java.math.BigDecimal;

public class OfferAddServiceModel {

    private Long id;
    private Long modelId;
    private BigDecimal price;
    private Engine engine;
    private Transmission transmission;
    private Integer year;
    private Integer mileage;
    private String description;
    private String imageUrl;

    @NotNull
    public Long getId() {
        return id;
    }

    public OfferAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    @NotNull
    public Long getModelId() {
        return modelId;
    }

    public OfferAddServiceModel setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    @NotNull
    @DecimalMin("100")
    public BigDecimal getPrice() {
        return price;
    }

    public OfferAddServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @NotNull
    public Engine getEngine() {
        return engine;
    }

    public OfferAddServiceModel setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }


    @NotNull
    public Transmission getTransmission() {
        return transmission;
    }

    public OfferAddServiceModel setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }


    @YearInPastOrPresent(minYear = 1930)
    public Integer getYear() {
        return year;
    }

    public OfferAddServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    @NotNull
    @PositiveOrZero
    public Integer getMileage() {
        return mileage;
    }

    public OfferAddServiceModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    @NotBlank
    @Size(min = 10, max = 512)
    public String getDescription() {
        return description;
    }

    public OfferAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotBlank
    public String getImageUrl() {
        return imageUrl;
    }

    public OfferAddServiceModel setImageUrl(String imageUrl) {
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
