package com.example.baitap.service;

import com.example.baitap.model.Category;
import com.example.baitap.repository.IBlogRepository;
import com.example.baitap.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    public List<Category> findAll(){
        return iCategoryRepository.findAll();
    }
    public Category findById(long id){
        return iCategoryRepository.findById(id).get();
    }
    public void save(Category category){
        iCategoryRepository.save(category);
    }
    public void remove(long id){
        iCategoryRepository.deleteById(id);
    }
}
