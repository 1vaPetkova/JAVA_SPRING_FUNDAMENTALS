package com.example.java_spring_fund_lab_01.web;

import com.example.java_spring_fund_lab_01.models.service.UserLoginServiceModel;
import com.example.java_spring_fund_lab_01.security.CurrentUser;
import com.example.java_spring_fund_lab_01.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String showLogin() {

        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginServiceModel model) {
        if (userService.isAuthenticated(model.getUsername(), model.getPassword())) {
            this.userService.loginUser(model.getUsername());
            return "redirect:/";
        }
        return "redirect:/users/login";
    }
}
