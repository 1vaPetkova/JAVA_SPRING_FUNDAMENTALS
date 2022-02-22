package com.example.java_spring_fund_lab_01.models.entities;

import com.example.java_spring_fund_lab_01.models.entities.enums.EngineEnum;
import com.example.java_spring_fund_lab_01.models.entities.enums.TransmissionEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    private String description;
    private EngineEnum engine;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private TransmissionEnum transmission;
    private Integer year;
    private ModelEntity model;
    private UserEntity seller;

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    @Column
    @Enumerated(EnumType.ORDINAL)
    public EngineEnum getEngine() {
        return engine;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @Column
    public Integer getMileage() {
        return mileage;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    @Column
    @Enumerated(EnumType.ORDINAL)
    public TransmissionEnum getTransmission() {
        return transmission;
    }

    @Column
    public Integer getYear() {
        return year;
    }

    @ManyToOne
    public ModelEntity getModel() {
        return model;
    }

    @ManyToOne
    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }


    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public OfferEntity setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public OfferEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public OfferEntity setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public OfferEntity setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public OfferEntity setYear(Integer year) {
        this.year = year;
        return this;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Offer{");
        sb.append("description='").append(description).append('\'');
        sb.append(", engine=").append(engine);
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append(", mileage=").append(mileage);
        sb.append(", price=").append(price);
        sb.append(", transmission=").append(transmission);
        sb.append(", year=").append(year);
        sb.append(", model=").append(model);
        sb.append(", seller=").append(seller);
        sb.append('}');
        return sb.toString();
    }
}
