package com.example.exam_prep_andreys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemController {

    @GetMapping("/add")
    public String addItem(){
        return "add-item";
    }
}
