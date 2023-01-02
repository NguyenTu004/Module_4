package com.example.baitap.service;

import com.example.baitap.model.Blog;
import com.example.baitap.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }
    public Blog findById(long id) {
        return iBlogRepository.findById(id).get();
    }
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }
    public void delete(long id) {
        iBlogRepository.deleteById(id);
    }
    public Page<Blog> searchByName(String name,Pageable pageable){
        return iBlogRepository.findAllByNameContaining(name, pageable);
    }
    public Page<Blog> searchByCategoryById(long id,Pageable pageable){
        return iBlogRepository.findAllByCategory_Id(id, pageable);
    }
    public List<Blog> searchByCategoryById(long id){
        return iBlogRepository.findAllByCategory_Id(id);
    }
}
