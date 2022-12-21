package com.example.thuchanh.controller;

import com.example.thuchanh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/home")
    public ModelAndView home(){
        return  new ModelAndView("home-customer", "customers",customerService.findAll());
    }
}
