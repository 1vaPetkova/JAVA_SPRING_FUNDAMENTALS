package com.example.java_spring_fund_lab_01.web;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class BrandsController {
    @GetMapping("/all")
    public String allBrands() {
        return "brands";
    }
}
