package com.yoyuen.jdbc.controller;

import com.github.pagehelper.PageInfo;
import com.yoyuen.jdbc.entity.Book;
import com.yoyuen.jdbc.impl.bookDaoImpl;
import com.yoyuen.jdbc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    private final BookService bookService;

    private bookDaoImpl bookDaoImpl;

    @Autowired
    public HelloController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/user/{name}")
    public String save(@PathVariable String name) {
        bookService.save(name);
        return name;
    }

    @GetMapping("/list")
    public List<Book> list() {
        List<Book> books = bookService.getAllBooksName();
        return books;
    }


}
