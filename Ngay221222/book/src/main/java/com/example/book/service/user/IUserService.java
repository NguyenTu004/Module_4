package com.example.book.service.user;


import com.example.book.model.User;
import com.example.book.service.ICrud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends ICrud<User> {
    Page<User> findAllUser(Pageable pageable);
    User borrowBook(User user);
    User findByCode(String code);
}
