package com.example.book.service;

import java.util.List;

public interface ICrud<T> {
    List<T> findAll();

    T findById(long id);

    void save(T t);

    void delete(long id);
}
