package com.example.products.controller;

import com.example.products.model.Category;
import com.example.products.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/categorys")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> findAll(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable long id){
        Optional<Category> category = categoryService.findById(id);
        if(category.isPresent()) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable long id){
        Optional<Category> category = categoryService.findById(id);
        if(category.isPresent()) {
            if(categoryService.remove(id)){
                return new ResponseEntity<>(category.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(new Category(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
