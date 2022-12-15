package com.example.practice.controller;

import com.example.practice.model.Product;
import com.example.practice.model.ProductForm;
import com.example.practice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("product")
public class ProductController {
    @Value("${upload-file}")
    private String fileUpload;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String home (ModelMap modelMap){
        modelMap.addAttribute("productList",productService.findAllProducts());
        return "home-product";
    }
    @RequestMapping(value = "/save/{id}", method = RequestMethod.GET)
    String saveForm (ModelMap modelMap, @PathVariable("id")long id){
        modelMap.addAttribute("categoryList",productService.findAllCategory());
        modelMap.addAttribute("product",productService.findByIdProduct(id));
        return "save-product";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    String save (@ModelAttribute ProductForm productForm, @RequestParam("categoryId") long id){
        productForm.setCategory(productService.findByIdCategory(id));
        MultipartFile multipartFile = productForm.getImg();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(productForm.getImg().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Product product = new Product(productForm.getId(), productForm.getName(),
                productForm.getPrice(),productForm.getCategory(), fileName);
        productService.saveProduct(product);
        return "redirect:/product/home";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String delete (@PathVariable("id")long id){
        productService.deleteProduct(productService.findByIdProduct(id));
        return "redirect:/product/home";
    }
}
