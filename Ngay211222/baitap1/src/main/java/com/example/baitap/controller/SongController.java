package com.example.baitap.controller;

import com.example.baitap.model.Song;
import com.example.baitap.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/song")
public class SongController {
    @Value("${upload-file}")
    private String fileUpload;
    @Autowired
    private SongService songService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView home() {
        return new ModelAndView("home-song","songs",songService.findAll());
    }
    @RequestMapping(value = "/save/{id}", method = RequestMethod.GET)
    public ModelAndView saveForm(@PathVariable("id") long id) {
        return new ModelAndView("save-song","song",songService.findById(id));
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    String save (@Validated @ModelAttribute Song song, @RequestParam("file") MultipartFile multipartFile,BindingResult bindingResult){
    ModelAndView save (@Validated @ModelAttribute Song song,BindingResult bindingResult){
        if(!bindingResult.hasFieldErrors()) {
           return new ModelAndView("home-song","songs",songService.findAll());
        }
        return new ModelAndView("save-song");
    }

}
