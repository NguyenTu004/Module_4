package com.example.book.service.user;

import com.example.book.model.Book;
import com.example.book.model.User;
import com.example.book.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserService implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return iUserRepository.findById(id).get();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void delete(long id) {
        iUserRepository.deleteById(id);
    }
    public User borrowBook(User user) {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int num = (int) (Math.random() * 10);
            code.append(num);
        }
        user.setCode(code.toString());
        return user;
    }

    @Override
    public User findByCode(String code) {
        return iUserRepository.findByCode(code);
    }

    @Override
    public Page<User> findAllUser(Pageable pageable) {
        return iUserRepository.findAll(pageable);
    }
}
