package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.inpl.CategoryService;
import com.example.demo.service.inpl.ProductService;
import com.example.demo.service.interface_service.ICategoryService;
import com.example.demo.service.interface_service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    ModelAndView home (){
        ModelAndView modelAndView = new ModelAndView("home-product");
        modelAndView.addObject("productList",productService.findAll());
        modelAndView.addObject("categoryMap",categoryService.findAllMap());
        return modelAndView;
    }
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    ModelAndView createForm (){
        ModelAndView modelAndView = new  ModelAndView("save-product");
        modelAndView.addObject("product",new Product(new Category()));
        modelAndView.addObject("categoryList",categoryService.findAll());
        return modelAndView;
    }
    @RequestMapping(value = "/save/{id}", method = RequestMethod.GET)
    ModelAndView updateForm (@PathVariable("id")long id){
        ModelAndView modelAndView = new  ModelAndView("save-product");
        modelAndView.addObject("product",productService.findById(id));
        modelAndView.addObject("categoryList",categoryService.findAll());
        return modelAndView;
    }
    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    String save (@ModelAttribute("Product")Product product, @RequestParam("categoryId")long id){
        product.setCategory(categoryService.findAllMap().get(id));
        productService.save(product);
        return "redirect:/product/home";
    }
    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.POST)
    String delete (@PathVariable("id")long id){
        productService.delete(productService.findById(id));
        return "redirect:/product/home";
    }

}
