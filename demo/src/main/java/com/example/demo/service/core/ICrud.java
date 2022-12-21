package com.example.demo.service.core;

import java.util.List;

public interface ICrud<E>{
    List<E> findAll();
    E findById(long id);
    void save(E e);
    void delete(E e);

}
