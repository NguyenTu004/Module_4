package com.example.demo.repository;

import com.example.demo.model.Category;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ICategoryRepository extends CrudRepository<Category, Long> {
}
