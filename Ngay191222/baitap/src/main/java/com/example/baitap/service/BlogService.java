package com.example.baitap.service;

import com.example.baitap.model.Blog;
import com.example.baitap.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
    public Blog findById(long id) {
        return blogRepository.findById(id);
    }
    public void save(Blog blog) {
        blogRepository.save(blog);
    }
    public void delete(Blog blog) {
        blogRepository.delete(findById(blog.getId()));
    }
}
