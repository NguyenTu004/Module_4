package com.example.baitap.controller;

import com.example.baitap.model.Blog;
import com.example.baitap.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("listBlog",blogService.findAll());
        return modelAndView;
    }
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public ModelAndView createForm() {
        return new ModelAndView("save","blog",new Blog());
    }
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public ModelAndView updateForm(@PathVariable("id") long id) {
        return new ModelAndView("save","blog",blogService.findById(id));
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        return "redirect:/blog/home";
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") long id){
        blogService.delete(blogService.findById(id));
        return "redirect:/blog/home";
    }
}
