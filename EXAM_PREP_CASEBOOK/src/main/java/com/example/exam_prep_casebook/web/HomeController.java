package com.example.exam_prep_casebook.web;

import com.example.exam_prep_casebook.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession httpSession, ModelAndView modelAndView) {
        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("index");
        } else {
            modelAndView.setViewName("home");
            modelAndView.addObject("loggedInUsername", this.userService.getLoggedInUserProfile().getUsername());
            modelAndView.addObject("users", this.userService.getAllUsersThatAreNotFriends());
        }
        return modelAndView;
    }
}
