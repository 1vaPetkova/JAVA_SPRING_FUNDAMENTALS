package com.example.java_spring_fund_lab_01.models.view;

import java.util.ArrayList;
import java.util.List;

public class BrandViewDto {

    private String name;
    private List<ModelViewDto> models;

    public BrandViewDto() {
        this.models = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModelViewDto> getModels() {
        return models;
    }

    public void setModels(List<ModelViewDto> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BrandViewDto{");
        sb.append("name='").append(name).append('\'');
        sb.append(", models=").append(models);
        sb.append('}');
        return sb.toString();
    }
}
