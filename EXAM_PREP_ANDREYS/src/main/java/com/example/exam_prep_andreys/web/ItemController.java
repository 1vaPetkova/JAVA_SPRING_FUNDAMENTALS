package com.example.exam_prep_andreys.web;

import com.example.exam_prep_andreys.models.binding.ItemAddBindingModel;
import com.example.exam_prep_andreys.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/add")
    public String addItem(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (!model.containsAttribute("itemAddBindingModel")) {
            model.addAttribute("itemAddBindingModel", new ItemAddBindingModel());
        }
        model.addAttribute("itemExists", false);
        return "add-item";
    }

    @PostMapping("/add")
    public String addItemConfirm(@Valid ItemAddBindingModel itemAddBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("itemAddBindingModel", itemAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel",
                            bindingResult);
            return "redirect:add";
        }

        boolean isAdded = this.itemService.addItem(itemAddBindingModel);
        if (!isAdded) {
            redirectAttributes
                    .addFlashAttribute("itemAddBindingModel", itemAddBindingModel)
                    .addFlashAttribute("itemExists", true);
            return "redirect:add";
        }
        return "redirect:/";
    }
}
