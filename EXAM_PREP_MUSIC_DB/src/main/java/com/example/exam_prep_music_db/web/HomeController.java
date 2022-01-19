package com.example.exam_prep_music_db.web;

import com.example.exam_prep_music_db.services.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final AlbumService albumService;

    public HomeController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession httpSession, ModelAndView modelAndView) {
        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("index");
        } else {
            modelAndView.setViewName("home");
            modelAndView.addObject("totalCopies", this.albumService.getTotalItems());
           modelAndView.addObject("albums", this.albumService.getAlbums());
        }
        return modelAndView;
    }


}
