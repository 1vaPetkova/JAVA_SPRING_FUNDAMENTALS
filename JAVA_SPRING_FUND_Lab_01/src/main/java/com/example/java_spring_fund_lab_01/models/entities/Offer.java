package com.example.java_spring_fund_lab_01.models.entities;

import com.example.java_spring_fund_lab_01.models.entities.enums.Engine;
import com.example.java_spring_fund_lab_01.models.entities.enums.Transmission;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    private String description;
    private Engine engine;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private Transmission transmission;
    private Integer year;
    private Model model;
   // private User seller;

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    @Column
    @Enumerated(EnumType.ORDINAL)
    public Engine getEngine() {
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
    public Transmission getTransmission() {
        return transmission;
    }

    @Column
    public Integer getYear() {
        return year;
    }

    @ManyToOne
    public Model getModel() {
        return model;
    }

//    @ManyToOne
//    public User getSeller() {
//        return seller;
//    }
//
//    public void setSeller(User seller) {
//        this.seller = seller;
//    }


    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public Offer setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public Offer setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Offer setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Offer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Offer setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public Offer setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Offer setModel(Model model) {
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
       // sb.append(", seller=").append(seller);
        sb.append('}');
        return sb.toString();
    }
}
