package com.example.exam_prep_andreys.web;

import com.example.exam_prep_andreys.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ItemService itemService;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }
        model.addAttribute("totalItems", this.itemService.getTotalItems());
        model.addAttribute("items", this.itemService.findItems());
        return "home";
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
