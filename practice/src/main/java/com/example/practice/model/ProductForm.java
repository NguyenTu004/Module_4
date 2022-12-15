package com.example.practice.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
    private long id;
    private String name;
    private double price;
    private Category category;
    private MultipartFile img;

    public ProductForm() {
    }

    public ProductForm(long id, String name, double price, Category category, MultipartFile img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.img = img;
    }

    public ProductForm(String name, double price, Category category, MultipartFile img) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
