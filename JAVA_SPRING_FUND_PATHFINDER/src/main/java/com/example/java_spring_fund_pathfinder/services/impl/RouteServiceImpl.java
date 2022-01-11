package com.example.java_spring_fund_pathfinder.services.impl;

import com.example.java_spring_fund_pathfinder.models.view.RouteViewModel;
import com.example.java_spring_fund_pathfinder.repositories.RouteRepository;
import com.example.java_spring_fund_pathfinder.services.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RouteViewModel> findAllRoutesView() {
        return this.routeRepository.findAll()
                .stream()
                .map(route -> {
                    RouteViewModel routeViewModel = this.modelMapper.map(route, RouteViewModel.class);
                    routeViewModel.setImageUrl(route.getPictures().isEmpty() ?
                            "/images/pic4.jpg"
                            : route.getPictures().stream().findFirst().get().getUrl());
                    return routeViewModel;
                }).collect(Collectors.toList());
    }
}
