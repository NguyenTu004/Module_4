package com.example.demo.service.interface_service;

import com.example.demo.model.Category;

import com.example.demo.service.core.ICrud;

import java.util.Map;

public abstract class ICategoryService implements ICrud<Category> {
    public Map<Long, Category> findAllMap() {
        return null;
    }
}
