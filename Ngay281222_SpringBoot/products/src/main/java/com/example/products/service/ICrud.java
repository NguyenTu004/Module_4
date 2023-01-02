package com.example.products.service;

import java.util.Optional;

public interface ICrud<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    boolean remove(Long id);
}
