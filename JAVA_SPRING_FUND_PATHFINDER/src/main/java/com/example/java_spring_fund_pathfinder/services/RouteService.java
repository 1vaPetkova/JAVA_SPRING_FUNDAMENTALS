package com.example.java_spring_fund_pathfinder.services;

import com.example.java_spring_fund_pathfinder.models.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesView();
}
