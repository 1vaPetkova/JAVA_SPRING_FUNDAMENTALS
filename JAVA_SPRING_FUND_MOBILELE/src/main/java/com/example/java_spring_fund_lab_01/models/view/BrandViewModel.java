package com.example.java_spring_fund_lab_01.models.view;

import java.util.ArrayList;
import java.util.List;

public class BrandViewModel {

    private String name;
    private List<ModelViewModel> models;

    public BrandViewModel() {
        this.models = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModelViewModel> getModels() {
        return models;
    }

    public void setModels(List<ModelViewModel> models) {
        this.models = models;
    }

    public BrandViewModel addModel(ModelViewModel modelViewDto){
        this.getModels().add(modelViewDto);
        return this;
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
