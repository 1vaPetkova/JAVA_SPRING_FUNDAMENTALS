package com.example.java_spring_fund_pathfinder.services;

import com.example.java_spring_fund_pathfinder.models.service.RouteServiceModel;
import com.example.java_spring_fund_pathfinder.models.view.RouteDetailsViewModel;
import com.example.java_spring_fund_pathfinder.models.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesView();

    void addNewRoute(RouteServiceModel routeServiceModel);

    RouteDetailsViewModel findRouteById(Long id);
}
