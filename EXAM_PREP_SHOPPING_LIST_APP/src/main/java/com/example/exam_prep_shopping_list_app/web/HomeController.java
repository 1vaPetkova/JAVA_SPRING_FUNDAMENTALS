package com.example.exam_prep_shopping_list_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String indexPage(HttpSession httpSession) {
        return httpSession.getAttribute("user") == null
                ? "index"
                : "home";
    }
}
