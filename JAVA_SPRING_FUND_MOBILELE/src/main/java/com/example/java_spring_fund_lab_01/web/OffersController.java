package com.example.java_spring_fund_lab_01.web;

import com.example.java_spring_fund_lab_01.models.entities.enums.Engine;
import com.example.java_spring_fund_lab_01.models.entities.enums.Transmission;
import com.example.java_spring_fund_lab_01.models.service.OfferServiceModel;
import com.example.java_spring_fund_lab_01.models.service.UserLoginServiceModel;
import com.example.java_spring_fund_lab_01.services.BrandService;
import com.example.java_spring_fund_lab_01.services.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OffersController {
    private final OfferService offerService;
    private final BrandService brandService;

    public OffersController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @ModelAttribute("offerModel")
    public OfferServiceModel offerModel() {
        return new OfferServiceModel();
    }

    @GetMapping("/add")
    public String newOffer(Model model) {
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid @ModelAttribute OfferServiceModel offerModel, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.offerModel",
                    bindingResult
            );
            return "redirect:/offers/add";
        }
        long newOfferId = this.offerService.saveOffer(offerModel);
        return "redirect:/offers/offer/" + newOfferId;
    }


    @GetMapping("offer/{id}")
    public String offerDetails(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        return "details";
    }

    @GetMapping("/all")
    public String allBrands(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }
}
