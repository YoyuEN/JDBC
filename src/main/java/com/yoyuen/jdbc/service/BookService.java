package com.yoyuen.jdbc.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yoyuen.jdbc.entity.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    void save(String name);

    List<Book> getAllBooksName();

    public PageInfo<Book> findBookByPage(int page, int pageSize);
}
