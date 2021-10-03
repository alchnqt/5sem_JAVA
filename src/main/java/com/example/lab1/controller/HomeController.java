package com.example.lab1.controller;

import com.example.lab1.JsonResult;
import com.example.lab1.model.Song;
import com.example.lab1.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController

public class HomeController {

    @Autowired
    private SongService songService;

    public HomeController(SongService songService) {
        this.songService = songService;
    }


    public JsonResult index(){

        return new JsonResult();
    }

    @GetMapping(value = "song")
    public List<Song> displaySongs(Model model){
        List<Song> songs = songService.getAllSongs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("playlist");
        return songs;
    }
    @PostMapping(value = "song")
    public JsonResult addSong(){

        return new JsonResult();
    }
}
