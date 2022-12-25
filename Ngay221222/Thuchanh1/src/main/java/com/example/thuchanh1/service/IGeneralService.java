package com.example.thuchanh1.service;

import com.example.thuchanh1.exception.DuplicateEmailException;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll() ;

    Optional<T> findById(Long id) throws Exception ;

    void save(T t) throws DuplicateEmailException;

    void remove(Long id);
}
