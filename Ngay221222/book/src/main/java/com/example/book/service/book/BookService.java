package com.example.book.service.book;

import com.example.book.model.Book;
import com.example.book.model.User;
import com.example.book.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BookService implements IBookService{
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(long id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void delete(long id) {
        iBookRepository.deleteById(id);
    }
    @Override
    public Page<Book> findAllPag(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }
    public Book borrowBook(User user) {
        Book book  = iBookRepository.findById(user.getBook().getId()).get();
        book.setQuantity(book.getQuantity()-1);
        return book;
    }
    public Book returnBook(User user) {
        Book book  = iBookRepository.findById(user.getBook().getId()).get();
        book.setQuantity(book.getQuantity()+1);
        return book;
    }


}
