package com.example.exam_prep_battle_ships.web;

import com.example.exam_prep_battle_ships.models.binding.ShipAddBindingModel;
import com.example.exam_prep_battle_ships.services.ShipService;
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
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/add")
    public String add(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

        if (!model.containsAttribute("shipAddBindingModel")) {
            model.addAttribute("shipAddBindingModel", new ShipAddBindingModel());
        }
        if (!model.containsAttribute("shipExists")) {
            model.addAttribute("shipExists", false);
        }
        return "ship-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ShipAddBindingModel shipAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("shipAddBindingModel", shipAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel",
                            bindingResult);
            return "redirect:add";
        }

        boolean isAdded = this.shipService.addShip(shipAddBindingModel);
        if (!isAdded) {
            redirectAttributes
                    .addFlashAttribute("shipAddBindingModel", shipAddBindingModel)
                    .addFlashAttribute("shipExists", true);
            return "redirect:add";
        }
        return "redirect:/";

    }
}
