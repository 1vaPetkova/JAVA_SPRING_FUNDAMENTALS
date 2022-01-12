package com.example.java_spring_fund_pathfinder.models.service;

import com.example.java_spring_fund_pathfinder.models.entities.Category;
import com.example.java_spring_fund_pathfinder.models.entities.Picture;
import com.example.java_spring_fund_pathfinder.models.entities.User;
import com.example.java_spring_fund_pathfinder.models.entities.enums.CategoryNameEnum;
import com.example.java_spring_fund_pathfinder.models.entities.enums.LevelEnum;

import java.util.HashSet;
import java.util.Set;


public class RouteServiceModel extends BaseServiceModel {
    private String description;
    private String gpxCoordinates;
    private LevelEnum level;
    private String name;
    private String videoUrl;
    private User author;
    private Set<CategoryNameEnum> categories;
    private Set<Picture> pictures;

    public RouteServiceModel() {
        this.categories = new HashSet<>();
        this.pictures = new HashSet<>();
    }

    public String getDescription() {
        return description;
    }

    public RouteServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteServiceModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteServiceModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public RouteServiceModel setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Set<CategoryNameEnum> getCategories() {
        return categories;
    }

    public RouteServiceModel setCategories(Set<CategoryNameEnum> categories) {
        this.categories = categories;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public RouteServiceModel setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
