package com.example.exam_prep_casebook.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView index(HttpSession httpSession, ModelAndView modelAndView) {
        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("index");
        } else {
//            modelAndView.addObject("totalItems", this.itemService.getTotalItems());
//            modelAndView.addObject("items", this.itemService.findItems());
            modelAndView.setViewName("home");
        }
        return modelAndView;
    }
}
