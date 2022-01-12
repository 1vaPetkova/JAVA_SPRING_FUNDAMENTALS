package com.example.java_spring_fund_pathfinder.web;

import com.example.java_spring_fund_pathfinder.models.binding.RouteAddBindingModel;
import com.example.java_spring_fund_pathfinder.services.RouteService;
import com.example.java_spring_fund_pathfinder.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final CurrentUser currentUser;

    public RouteController(RouteService routeService, CurrentUser currentUser) {
        this.routeService = routeService;
        this.currentUser = currentUser;
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

    @GetMapping("/add")
    public String addRoute() {
//        if (this.currentUser.getId() == null) {
//            return "redirect:/users/login";
//        }
        return "add-route";
    }

    @PostMapping("/add")
    public String addRouteConfirm(@Valid RouteAddBindingModel routeAddBindingModel, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("routeAddBindingModel", routeAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModel",
                    bindingResult);
            return "redirect:add";
        }


        return "redirect:all";
    }
}
