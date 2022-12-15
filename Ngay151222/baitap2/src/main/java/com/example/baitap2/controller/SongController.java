package com.example.baitap2.controller;

import com.example.baitap2.model.Song;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/song")
public class SongController {
    @Value("${upload}")
    private String fileUpload;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    ModelAndView save(@ModelAttribute Song song,@RequestParam("file") MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch ( IOException ex) {
            ex.printStackTrace();
        }
        song.setLink(fileName);
        return  new ModelAndView("song-view","song",song);
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String home(){
        return "song-view";
    }
}
