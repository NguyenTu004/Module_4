package com.example.products.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_springboot")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private int quantity;
    @ManyToOne
    private Category category;
}
