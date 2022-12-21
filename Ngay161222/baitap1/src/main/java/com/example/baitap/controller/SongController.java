package com.example.baitap.controller;

import com.example.baitap.model.Song;
import com.example.baitap.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
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
    String save (@ModelAttribute Song song, @RequestParam("file") MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        song.setLink(fileName);
        songService.save(song);
        return "redirect:/song";
    }
}
