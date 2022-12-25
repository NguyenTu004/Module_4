package com.example.thuchanh1.controller;

import com.example.thuchanh1.exception.DuplicateEmailException;
import com.example.thuchanh1.model.Customer;
import com.example.thuchanh1.model.Province;
import com.example.thuchanh1.service.customer.ICustomerService;
import com.example.thuchanh1.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }
    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/customers/inputs-not-acceptable");
    }


    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        try {
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("customer", new Customer());
            modelAndView.addObject("message", "New customer created successfully");
            return modelAndView;
        }catch (Exception e) {
            return new ModelAndView("/customers/inputs-not-acceptable");
        }

    }

    @GetMapping("/customers")
    public ModelAndView listCustomers(Pageable pageable) {
        try {
//        Iterable<Customer> customers = customerService.findAll();
            Page<Customer> customers = customerService.findAll(pageable);
            ModelAndView modelAndView = new ModelAndView("/customer/list");
            modelAndView.addObject("customers", customers);
            return modelAndView;
        }catch (Exception e) {
            return new ModelAndView("redirect:/customers");
        }
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        try {
            Optional<Customer> customer = customerService.findById(id);
            if (customer.isPresent()) {
                ModelAndView modelAndView = new ModelAndView("/customer/edit");
                modelAndView.addObject("customer", customer.get());
                return modelAndView;
            } else {
                ModelAndView modelAndView = new ModelAndView("/error.404");
                return modelAndView;
            }
        }catch (Exception e) {
            return new ModelAndView("redirect:/customers");
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        try {
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("message", "Customer updated successfully");
            return modelAndView;
        }catch (Exception e) {
            return new ModelAndView("/customers/inputs-not-acceptable");
        }

    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        try {
            Optional<Customer> customer = customerService.findById(id);
            ModelAndView modelAndView;
            if (customer.isPresent()) {
                modelAndView = new ModelAndView("/customer/delete");
                modelAndView.addObject("customer", customer.get());
                return modelAndView;

            } else {
                modelAndView = new ModelAndView("/error.404");
                return modelAndView;
            }
        }catch (Exception e) {
            return new ModelAndView("redirect:/customers");
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:customers";
    }
    @PostMapping("/customers")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable){
        try {
            Page<Customer> customers;
            if (search.isPresent()) {
                customers = customerService.findAllByFirstNameContaining(search.get(), pageable);
            } else {
                customers = customerService.findAll(pageable);
            }
            ModelAndView modelAndView = new ModelAndView("/customer/list");
            modelAndView.addObject("customers", customers);
            return modelAndView;
        }catch (Exception e){
            return new ModelAndView("redirect:/customers");
        }
    }

}