package com.example.java_spring_fund_pathfinder.services.impl;

import com.example.java_spring_fund_pathfinder.models.entities.Category;
import com.example.java_spring_fund_pathfinder.models.entities.Route;
import com.example.java_spring_fund_pathfinder.models.service.RouteServiceModel;
import com.example.java_spring_fund_pathfinder.models.view.RouteDetailsViewModel;
import com.example.java_spring_fund_pathfinder.models.view.RouteViewModel;
import com.example.java_spring_fund_pathfinder.repositories.RouteRepository;
import com.example.java_spring_fund_pathfinder.services.CategoryService;
import com.example.java_spring_fund_pathfinder.services.RouteService;
import com.example.java_spring_fund_pathfinder.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public List<RouteViewModel> findAllRoutesView() {
        return this.routeRepository.findAll()
                .stream()
                .map(route -> {
                    RouteViewModel routeViewModel = this.modelMapper.map(route, RouteViewModel.class);
                    routeViewModel.setImageUrl(
                            route.getPictures().isEmpty() ?
                                    "/images/pic4.jpg"
                                    : route.getPictures().stream().findFirst().get().getUrl()
                    );
                    return routeViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel) {
        Route route = this.modelMapper.map(routeServiceModel, Route.class);
        route
                .setAuthor(this.userService.findCurrentUser())
                .setCategories(routeServiceModel.getCategories()
                        .stream()
                        .map(this.categoryService::findByCategoryNameEnum)
                        .collect(Collectors.toSet()));
        this.routeRepository.save(route);
    }

    @Override
    public RouteDetailsViewModel findRouteById(Long id) {
        return this.routeRepository
                .findById(id)
                .map(route -> this.modelMapper.map(route, RouteDetailsViewModel.class))
                .orElse(null);
    }

}
