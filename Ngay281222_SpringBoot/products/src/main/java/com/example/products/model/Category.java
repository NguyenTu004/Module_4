package com.example.products.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category_springboot")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
