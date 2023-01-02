package com.example.baitap.controller.rest_controller;

import com.example.baitap.model.Blog;
import com.example.baitap.model.Category;
import com.example.baitap.service.BlogService;
import com.example.baitap.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/news")
public class BlogRestController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Blog>> findAllBlog(){
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>( blogList,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findByIdBlog(@PathVariable("id")long id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> findAllCategory(){
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<Iterable<Blog>> findAllBlogByIdCategory(@PathVariable("id")long id){
        List<Blog> blogList = blogService.searchByCategoryById(id);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @GetMapping("/search/{text}")
    public ResponseEntity<Iterable<Blog>> findAllBlogByNameContain(@PathVariable("text") String text){
        List<Blog> blogList = blogService.searchByName(text);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
}
