package com.example.java_spring_fund_lab_01.models.entities;

import com.example.java_spring_fund_lab_01.models.entities.enums.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "models")
public class Model extends BaseEntity {
private String name;
private Category category;
private String imageUrl;
private Integer startYear;
private Integer endYear;
private Brand brand;

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    @Column
    public Category getCategory() {
        return category;
    }

    public Model setCategory(Category category) {
        this.category = category;
        return this;
    }



    @Column(name = "image_url", columnDefinition = "VARCHAR (512)")
    public String getImageUrl() {
        return imageUrl;
    }

    public Model setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Column(name = "start_year")
    public Integer getStartYear() {
        return startYear;
    }

    public Model setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    @Column(name = "end_year")
    public Integer getEndYear() {
        return endYear;
    }

    public Model setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    @ManyToOne
    public Brand getBrand() {
        return brand;
    }

    public Model setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }
}