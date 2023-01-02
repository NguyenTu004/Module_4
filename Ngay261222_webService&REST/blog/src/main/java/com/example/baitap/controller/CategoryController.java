package com.example.baitap.controller;

import com.example.baitap.model.Category;
import com.example.baitap.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping(value = "/save")
    public ModelAndView saveForm(){
        return new ModelAndView("category/save","category",new Category());
    }
    @PostMapping(value = "/save")
    public String save(@ModelAttribute("category")Category category){
        categoryService.save(category);
        return "redirect:/blog/home";
    }
}
