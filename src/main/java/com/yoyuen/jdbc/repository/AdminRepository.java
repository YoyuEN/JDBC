package com.yoyuen.jdbc.repository;

import com.yoyuen.jdbc.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminRepository {
    Book selectBook(String name);

}
