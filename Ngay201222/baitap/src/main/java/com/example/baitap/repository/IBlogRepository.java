package com.example.baitap.repository;

import com.example.baitap.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {

    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByNameContaining(String name,Pageable pageable);
    Page<Blog> findAllByCategory_Id(long id,Pageable pageable);
}
