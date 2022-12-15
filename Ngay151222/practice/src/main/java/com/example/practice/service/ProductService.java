package com.example.practice.service;

import com.example.practice.model.Category;
import com.example.practice.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private static List<Product> productList;
    private static List<Category> categoryList;
    private static long index;
    static {
        productList = new ArrayList<>();
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1L,"fruit"));
        categoryList.add(new Category(2L,"Vegetables"));
        categoryList.add(new Category(3L,"meat"));
        productList.add(new Product(1L,"Tao",123,categoryList.get(0)));
        productList.add(new Product(2L,"Thit Heo",123,categoryList.get(2)));
        index = productList.get(productList.size()-1).getId();
    }
    public List<Product> findAllProducts() {
        return productList;
    }
    public List<Category> findAllCategory() {
        return categoryList;
    }
    public Product findByIdProduct (long id) {
        for (Product product : productList){
            if (product.getId() == id){
                return product;
            }
        }
        return new Product();
    }
    public Category findByIdCategory (long id) {
        for (Category c : categoryList){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }
    public void saveProduct(Product product) {
        if (product.getId() == 0) {
            product.setId(++index);
            productList.add(product);
        }else {
            productList.set(productList.indexOf(findByIdProduct(product.getId())),product);
        }
    }
    public  void deleteProduct(Product product) {
        productList.remove(product);
    }
}
