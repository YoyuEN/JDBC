package com.yoyuen.jdbc.mapper;

import com.yoyuen.jdbc.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookMapper {
    Book selectBook(String name);
}
