package com.example.exam_prep_casebook.web;

import com.example.exam_prep_casebook.models.binding.UserLoginBindingModel;
import com.example.exam_prep_casebook.models.binding.UserRegisterBindingModel;
import com.example.exam_prep_casebook.models.services.UserServiceModel;
import com.example.exam_prep_casebook.services.UserService;
import com.example.exam_prep_casebook.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final CurrentUser currentUser;
    public UserController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }
        if (!model.containsAttribute("userExists")) {
            model.addAttribute("userExists", false);
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()
                || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                            bindingResult);
            return "redirect:register";
        }
        boolean isSaved = this.userService.registerUser(userRegisterBindingModel);
        if (!isSaved) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("userExists", true);
            return "redirect:register";
        }
        return "redirect:login";
    }


    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
        }
        if (!model.containsAttribute("userNotFound")) {
            model.addAttribute("userNotFound", false);
        }
        return "login";
    }


    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes,
                               HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);
            return "redirect:login";
        }

        //Check if user exists
        UserServiceModel userServiceModel = this.userService.findUserByUsernameAndPassword(userLoginBindingModel);

        if (userServiceModel == null
                || !userServiceModel.getPassword().equals(userLoginBindingModel.getPassword())) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("userNotFound", true);
            return "redirect:login";
        }
        httpSession.setAttribute("user", userServiceModel);
        this.userService.loginCurrentUser(userServiceModel);
        return "redirect:/";
    }


    @GetMapping("/profile")
    public String loggedInProfile(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:login";
        }
        model.addAttribute("userProfile", this.userService.getUserProfile(this.currentUser.getId()));
        return "profile";
    }

    @GetMapping("/profile/{id}")
    public String getUserProfile(@PathVariable Long id,  Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:login";
        }
        model.addAttribute("userProfile", this.userService.getUserProfile(id));
        return "profile";
    }



    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        this.userService.logoutCurrentUser();
        return "redirect:/";
    }


}
