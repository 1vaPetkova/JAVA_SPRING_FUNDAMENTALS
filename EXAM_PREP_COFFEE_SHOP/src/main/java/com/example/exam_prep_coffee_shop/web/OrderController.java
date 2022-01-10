package com.example.exam_prep_coffee_shop.web;

import com.example.exam_prep_coffee_shop.models.binding.OrderAddBindingModel;
import com.example.exam_prep_coffee_shop.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @ModelAttribute
    public OrderAddBindingModel orderAddBindingModel() {
        return new OrderAddBindingModel();
    }

    @GetMapping("/add")
    public String addOrder() {
        return "order-add";
    }


    @PostMapping("/add")
    public String addOrderConfirm(@Valid OrderAddBindingModel orderAddBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("orderAddBindingModel", orderAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel",
                            bindingResult);
            return "redirect:add";
        }
        //TODO add to db

        return "redirect:/";
    }
}
