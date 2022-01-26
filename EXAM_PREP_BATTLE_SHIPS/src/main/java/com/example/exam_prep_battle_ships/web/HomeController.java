package com.example.exam_prep_battle_ships.web;

import com.example.exam_prep_battle_ships.models.binding.FightBindingModel;
import com.example.exam_prep_battle_ships.services.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    private final ShipService shipService;

    public HomeController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/")
    public String home(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }
        if (!model.containsAttribute("fightBindingModel")) {
            model.addAttribute("fightBindingModel", new FightBindingModel());
        }
        model.addAttribute("allShips", this.shipService.getAllShips());
        model.addAttribute("shipsOfCurrentUser", this.shipService.getShipsOfCurrentUser());
        model.addAttribute("shipsOfOtherUsers", this.shipService.getShipsOfOtherUsers());
        return "home";
    }

    @PostMapping("/")
    public String fight(@Valid FightBindingModel fightBindingModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("fightBindingModel", fightBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.fightBindingModel",
                            bindingResult);
            return "redirect:/";
        }
        this.shipService.fight(fightBindingModel);
        return "redirect:/";
    }
}
