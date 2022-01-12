package com.example.java_spring_fund_pathfinder.models.view;

import com.example.java_spring_fund_pathfinder.models.entities.Category;
import com.example.java_spring_fund_pathfinder.models.entities.Picture;
import com.example.java_spring_fund_pathfinder.models.entities.User;
import com.example.java_spring_fund_pathfinder.models.entities.enums.LevelEnum;

import java.util.Set;

public class RouteDetailsView {

    private Long id;
    private String description;
    private String gpxCoordinates;
    private LevelEnum level;
    private String name;
    private String videoUrl;
    private Set<Picture> pictures;

}
