package com.example.thuchanh.controller;

import com.example.thuchanh.model.Customer;
import com.example.thuchanh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping( value = "/home", method = RequestMethod.GET)
    String home(ModelMap modelMap){
        modelMap.addAttribute("listCustomer",customerService.findAllCustomer());
        return "home-customer";
    }
    @RequestMapping( value = "/create", method = RequestMethod.GET)
    String createForm(Model model){
        model.addAttribute("customer", new Customer());
        return "update-customer";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    String updateForm(ModelMap modelMap, @PathVariable("id") long id){
        modelMap.addAttribute("customer",customerService.findById(id));
        return "update-customer";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String deleteForm( @PathVariable("id") long id,ModelMap modelMap){
        modelMap.addAttribute("customer",customerService.findById(id));
        return "delete-customer";
    }
    @RequestMapping( value = "/create", method = RequestMethod.POST)
    String create(Customer customer){
        customerService.save(customer);
        return "redirect:/customer/home";
    }
    @RequestMapping( value = "/update", method = RequestMethod.POST)
    String update(Customer customer){
        customerService.update(customer);
        return "redirect:/customer/home";
    }
    @RequestMapping( value = "/detail/{id}", method = RequestMethod.GET)
    String detailCustomer(@PathVariable("id")long id,ModelMap modelMap){
        modelMap.addAttribute("customer",customerService.findById(id));
        return "detail-customer";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    String delete(Customer customer) {
        customerService.delete(customerService.findById(customer.getId()));
        return "redirect:/customer/home";
    }
    @RequestMapping("/search")
    String search(@RequestParam("search") String search,ModelMap modelMap){
        modelMap.addAttribute("listCustomer",customerService.search(search.toUpperCase()));
        return "home-customer";
    }
}
