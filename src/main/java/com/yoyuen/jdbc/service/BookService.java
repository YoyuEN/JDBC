package com.yoyuen.jdbc.service;


import com.yoyuen.jdbc.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    void addBook(Book book);

    void save(String name);

    List<Book> getAllBooksName();
}
