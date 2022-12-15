package com.example.practice.model;

public class Product {
    private long id;
    private String name;
    private double price;
    private Category category;
    private String img;

    public Product() {
    }

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(long id, String name, double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(long id, String name, double price, Category category, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.img = img;
    }

    public Product(String name, double price, Category category, String img) {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
