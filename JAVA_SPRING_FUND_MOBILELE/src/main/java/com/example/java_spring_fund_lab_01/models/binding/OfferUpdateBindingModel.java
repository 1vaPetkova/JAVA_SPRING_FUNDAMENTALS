package com.example.java_spring_fund_lab_01.models.binding;

import com.example.java_spring_fund_lab_01.models.entities.enums.EngineEnum;
import com.example.java_spring_fund_lab_01.models.entities.enums.TransmissionEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class OfferUpdateBindingModel {


    private Integer price;
    private Long id;
    private String description;
    private EngineEnum engine;
    private String imageUrl;
    private Integer mileage;
    private TransmissionEnum transmission;
    private Integer year;

    public OfferUpdateBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public OfferUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    @NotBlank
    public String getDescription() {
        return description;
    }

    public OfferUpdateBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull
    public EngineEnum getEngine() {
        return engine;
    }

    public OfferUpdateBindingModel setEngine(
            EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    @NotBlank
    public String getImageUrl() {
        return imageUrl;
    }

    public OfferUpdateBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @NotNull
    @PositiveOrZero
    public Integer getMileage() {
        return mileage;
    }

    public OfferUpdateBindingModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    @NotNull
    @Min(100)
    public Integer getPrice() {
        return price;
    }

    public OfferUpdateBindingModel setPrice(Integer price) {
        this.price = price;
        return this;
    }

    @NotNull
    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferUpdateBindingModel setTransmission(
            TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    @NotNull
    @Min(1930)
    public Integer getYear() {
        return year;
    }

    public OfferUpdateBindingModel setYear(Integer year) {
        this.year = year;
        return this;
    }
}
