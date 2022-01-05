package com.example.java_spring_fund_pathfinder.models.service;

public abstract class BaseServiceModel {

    private Long id;

    public Long getId() {
        return id;
    }

    public BaseServiceModel setId(Long id) {
        this.id = id;
        return this;
    }
}
