package com.example.exam_prep_shopping_list_app.web;

import com.example.exam_prep_shopping_list_app.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String indexPage(Model model , HttpSession httpSession) {

        if (httpSession.getAttribute("user") == null){
            return "index";
        }
        model.addAttribute("totalSum",this.productService.getTotalProductsPrice());
     model.addAttribute("drinks",this.productService.getDrinks());
        return "home";
    }
}
