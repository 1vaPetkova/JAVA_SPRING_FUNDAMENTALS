package com.example.java_spring_fund_pathfinder.models.view;

public class RouteViewModel {

    private Long id;
    private String description;
    private String name;
    private String imageUrl;

    public RouteViewModel() {
    }

    public Long getId() {
        return id;
    }

    public RouteViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RouteViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
