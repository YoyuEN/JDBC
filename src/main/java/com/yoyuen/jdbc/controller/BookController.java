package com.yoyuen.jdbc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yoyuen.jdbc.entity.Book;
import com.yoyuen.jdbc.impl.bookDaoImpl;
import com.yoyuen.jdbc.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private bookDaoImpl bookDaoImpl;

    @GetMapping("/book")
    public Book BookSelectByName() {
        return bookMapper.selectBook("YoyuEN");
    }


    @GetMapping("/book/{pageNo}/{pageSize}")
    public PageInfo<Book> findBookByPage(@PathVariable int pageNo, @PathVariable int pageSize) {
        return bookDaoImpl.findBookByPage(pageNo, pageSize);
    }
}
