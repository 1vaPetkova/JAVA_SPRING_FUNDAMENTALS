package com.example.exam_prep_casebook.web;

import com.example.exam_prep_casebook.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/friends")
public class FriendsController {

    private final UserService userService;

    public FriendsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String friends(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        model.addAttribute("friends",this.userService.getFriends());
        return "friends";
    }

    @GetMapping("/add/{id}")
    public String addFriend(@PathVariable Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        this.userService.addFriend(id);
        return "redirect:/";
    }

    @GetMapping("/unfriend/{id}")
    public String removeFriend(@PathVariable Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:login";
        }
        this.userService.unfriendUser(id);
        return "redirect:/friends";
    }
}
