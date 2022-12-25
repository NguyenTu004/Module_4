package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.User;
import com.example.book.service.book.BookService;
import com.example.book.service.book.IBookService;
import com.example.book.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    ModelAndView home(@PageableDefault(value = 2) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("listBook",iBookService.findAllPag(pageable));
        modelAndView.addObject("listUser",iUserService.findAllUser(pageable));
        return modelAndView;
    }
    @RequestMapping(value = "/borrow/{id}" , method = RequestMethod.GET)
    ModelAndView borrowForm(@PathVariable("id")long id) {
        ModelAndView modelAndView = new ModelAndView("borrow");
        modelAndView.addObject("book",iBookService.findById(id));
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
    @RequestMapping(value = "/borrow" , method = RequestMethod.POST)
    String borrow(@ModelAttribute("user") User user,
                  @RequestParam("bookId")long id) {
        user.setBook(iBookService.findById(id));
        iUserService.save(iUserService.borrowBook(user));
        iBookService.borrowBook(user);
        return "redirect:/book/home";
    }
    @RequestMapping(value = "/returnBook" , method = RequestMethod.POST)
    String returnBook(@RequestParam("code")String code) {
        User user = iUserService.findByCode(code);
        iBookService.returnBook(user);
        user.setCode(user.getCode() + "Paid");
        iUserService.save(user);
        return "redirect:/book/home";
    }
}
