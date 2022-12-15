package com.example.baitap.controller;

import com.example.baitap.model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mail")
public class MailController {
    @RequestMapping("/save")
    public ModelAndView save(@ModelAttribute Mail mail){
        return new ModelAndView("mail-view","mail",mail);
    }
}
