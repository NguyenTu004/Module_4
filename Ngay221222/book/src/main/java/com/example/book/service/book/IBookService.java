package com.example.book.service.book;

import com.example.book.model.Book;
import com.example.book.model.User;
import com.example.book.service.ICrud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService extends ICrud<Book> {
    Page<Book> findAllPag(Pageable pageable);
    Book borrowBook(User user);
    Book returnBook(User user);
}
