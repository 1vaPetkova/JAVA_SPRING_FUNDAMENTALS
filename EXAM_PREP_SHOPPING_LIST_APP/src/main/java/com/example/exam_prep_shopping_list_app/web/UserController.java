package com.example.exam_prep_shopping_list_app.web;

import com.example.exam_prep_shopping_list_app.models.binding.UserLoginBindingModel;
import com.example.exam_prep_shopping_list_app.models.binding.UserRegisterBindingModel;
import com.example.exam_prep_shopping_list_app.models.services.UserServiceModel;
import com.example.exam_prep_shopping_list_app.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()
                || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                            bindingResult);
            return "redirect:register";
        }
        this.userService.registerUser(userRegisterBindingModel);
        return "redirect:login";
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/login")
    public String login(Model model) {
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
                    .addFlashAttribute("userRegisterLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);
            return "redirect:login";
        }

        //CheckIfUserExists
        UserServiceModel userServiceModel = this.userService
                .findUserNameByUserNameAndPassword(userLoginBindingModel.getUsername(),
                        userLoginBindingModel.getPassword());
        if (userServiceModel == null) {
            redirectAttributes
                    .addFlashAttribute("userRegisterLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("userNotFound", true);
            return "redirect:login";
        }
        httpSession.setAttribute("user", userServiceModel);
        //   this.userService.loginUser(userServiceModel);
        return "redirect:/";
    }
}
