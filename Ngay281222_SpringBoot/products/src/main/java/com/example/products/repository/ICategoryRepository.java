package com.example.products.repository;

import com.example.products.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
