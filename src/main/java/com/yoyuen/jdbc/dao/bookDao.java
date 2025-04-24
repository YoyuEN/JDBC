package com.yoyuen.jdbc.dao;

import com.yoyuen.jdbc.demos.web.User;
import com.yoyuen.jdbc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Mapper
public interface bookDao {
    void addBook(Book book);

}
