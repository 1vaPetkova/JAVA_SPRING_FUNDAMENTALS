package com.example.java_spring_fund_lab_01.web;

import com.example.java_spring_fund_lab_01.security.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private CurrentUser currentUser;

    public LoginController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("users/login")
    public String login() {

        return "auth-login";
    }
}
