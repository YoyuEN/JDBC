package com.yoyuen.jdbc.mapper;

import com.github.pagehelper.PageInfo;
import com.yoyuen.jdbc.dao.bookDao;
import com.yoyuen.jdbc.entity.Book;
import com.yoyuen.jdbc.impl.bookDaoImpl;
import com.yoyuen.jdbc.repository.AdminRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;
    @Test
    public void testSelectBook() {
        Book book1 = bookMapper.selectBook("时间");
        Assertions.assertNotNull(book1);
    }

    @Autowired
    private bookDaoImpl bookDaoImpl;
    @Test
    public void testPage() {
        PageInfo<Book> page = bookDaoImpl.findBookByPage(3, 10);
        Assertions.assertNotNull(page);
    }

    @Test
    public void testGetAllBook() {

    }
}
