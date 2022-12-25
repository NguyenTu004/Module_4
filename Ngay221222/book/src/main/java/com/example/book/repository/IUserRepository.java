package com.example.book.repository;

import com.example.book.model.Book;
import com.example.book.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    @Override
    Page<User> findAll(Pageable pageable);
    User findByCode(String code);
}
