package com.example.exam_prep_andreys.web;

import com.example.exam_prep_andreys.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ItemService itemService;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession httpSession, ModelAndView modelAndView) {
        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("index");
        } else {

            modelAndView.setViewName("home");
        }
        return modelAndView;
    }


    @GetMapping("/delete/all")
    public String deleteAllItems(HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        this.itemService.deleteAllItems();
        return "redirect:/";
    }
}
