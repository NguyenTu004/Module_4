package com.example.book.model;

import org.hibernate.annotations.Check;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;

@Entity
@Table
@Check(constraints = "quantity >= 0")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    private Double quantity;

    public Book() {
    }

    public Book(Long id, String name, Double quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
