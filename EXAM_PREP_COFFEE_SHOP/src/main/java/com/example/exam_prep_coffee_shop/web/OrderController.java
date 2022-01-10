package com.example.exam_prep_coffee_shop.web;

import com.example.exam_prep_coffee_shop.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @GetMapping("/add")

}
