package com.example.java_spring_fund_pathfinder.web;

import com.example.java_spring_fund_pathfinder.services.PictureService;
import com.example.java_spring_fund_pathfinder.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UserService userService;
    private final PictureService pictureService;

    public HomeController(UserService userService, PictureService pictureService) {
        this.userService = userService;
        this.pictureService = pictureService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pictures", this.pictureService.findAllUrls());

        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
