package com.example.baitap.controller;

import com.example.baitap.model.Blog;
import com.example.baitap.model.Category;
import com.example.baitap.service.BlogService;
import com.example.baitap.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @ModelAttribute("listCategory")
    Iterable<Category> categoryList(){
        return categoryService.findAll();
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(@PageableDefault(value = 2 )Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("blog/home");
        modelAndView.addObject("listBlog",blogService.findAll(pageable));
        modelAndView.addObject("Url","/home");
        modelAndView.addObject("value","home");
        return modelAndView;
    }
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("blog/save");
        modelAndView.addObject("blog",new Blog(new Category()));
        return modelAndView;
    }
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public ModelAndView updateForm(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("blog/save");
        modelAndView.addObject("blog",blogService.findById(id));
        return modelAndView;
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("blog") Blog blog, @RequestParam("categoryId")long id){
        blog.setCategory(categoryService.findById(id));
        blogService.save(blog);
        return "redirect:/blog/home";
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") long id){
        blogService.delete(id);
        return "redirect:/blog/home";
    }
    @GetMapping("/searchByCategory")
    public ModelAndView searchByCategory(@RequestParam("value")long id,@PageableDefault(value = 2) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("blog/home");
        modelAndView.addObject("Url","/searchByCategory");
        modelAndView.addObject("value",id);
        if (id != 0){
            modelAndView.addObject("listBlog",blogService.searchByCategoryById(id,pageable));
        }else {
            modelAndView.addObject("listBlog",blogService.findAll(pageable));
        }
        return modelAndView;
    }
    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam("value")Optional<String> name, @PageableDefault(value = 2) Pageable pageable){
        Page<Blog> blogs ;
        ModelAndView modelAndView = new ModelAndView("blog/home");
        modelAndView.addObject("Url","/search");
        if (name.isPresent()){
            modelAndView.addObject("value",name.get());
            blogs = blogService.searchByName(name.get(),pageable);
        }else {
            modelAndView.addObject("value","");
            blogs = blogService.findAll(pageable);
        }
        modelAndView.addObject("listBlog",blogs);
        return modelAndView;
    }
}
