package com.example.exam_prep_coffee_shop.web;

import com.example.exam_prep_coffee_shop.models.views.OrderViewModel;
import com.example.exam_prep_coffee_shop.security.CurrentUser;
import com.example.exam_prep_coffee_shop.services.OrderService;
import com.example.exam_prep_coffee_shop.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }


    @GetMapping()
    public String index(Model model) {
        if (!this.currentUser.isLoggedIn()) {
            return "index";
        }
        List<OrderViewModel> orders = this.orderService.findOrdersByPriceDesc();
        model.addAttribute("orders", orders)
                .addAttribute("totalTime",
                        orders
                                .stream()
                                .map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
                                .reduce(Integer::sum)
                                .orElse(0)
                );

        model.addAttribute("employees", this.userService.findAllUsersAndCountOfTheirOrdersOrderByOrdersCount());


        return "home";
    }
}
