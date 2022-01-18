package com.example.exam_prep_andreys.web;

import com.example.exam_prep_andreys.models.entities.enums.CategoryNameEnum;
import com.example.exam_prep_andreys.models.entities.enums.GenderEnum;
import com.example.exam_prep_andreys.models.views.ItemViewModel;
import com.example.exam_prep_andreys.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

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
        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Arrays.stream(GenderEnum.values()).forEach(genderEnum -> {
                        List<ItemViewModel> items =
                                this.itemService.findProductsByCategoryNameAndGender(categoryNameEnum, genderEnum);
                        model.addAttribute(genderEnum.name().toLowerCase() + categoryNameEnum.name().toLowerCase(),
                                items);
                    });
                });
        return "home";
    }
}
