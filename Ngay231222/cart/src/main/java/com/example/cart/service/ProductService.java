package com.example.cart.service;

import com.example.cart.model.Product;
import com.example.cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private IProductRepository iProductRepository;

    public List<Product> findAll(){
        return iProductRepository.findAll();
    }
    public Product findById(long id){
        return iProductRepository.findById(id).get();
    }

}
