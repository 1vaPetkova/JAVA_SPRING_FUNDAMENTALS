package com.example.java_spring_fund_pathfinder.web;

import com.example.java_spring_fund_pathfinder.models.binding.RouteAddBindingModel;
import com.example.java_spring_fund_pathfinder.models.service.RouteServiceModel;
import com.example.java_spring_fund_pathfinder.services.RouteService;
import com.example.java_spring_fund_pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;


@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public RouteController(RouteService routeService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String allRoutes(Model model) {
        if (this.currentUser.getId() == null) {
            return "redirect:/users/login";
        }
        model.addAttribute("routes", this.routeService.findAllRoutesView());
        return "routes";
    }

    @ModelAttribute
    public RouteAddBindingModel routeAddBindingModel() {
        return new RouteAddBindingModel();
    }


    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){
    model.addAttribute("route", this.routeService.findRouteById(id));

        return "route-details";
    }

    @GetMapping("/add")
    public String addRoute() {
        if (this.currentUser.getId() == null) {
            return "redirect:/users/login";
        }
        return "add-route";
    }

    @PostMapping("/add")
    public String addRouteConfirm(@Valid RouteAddBindingModel routeAddBindingModel, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("routeAddBindingModel", routeAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModel",
                    bindingResult);
            return "redirect:add";
        }

        RouteServiceModel routeServiceModel = this.modelMapper.map(routeAddBindingModel, RouteServiceModel.class);
        routeServiceModel
                .setGpxCoordinates(new String(routeAddBindingModel.getGpxCoordinates().getBytes()));

        this.routeService.addNewRoute(routeServiceModel);
        return "redirect:all";
    }
}
