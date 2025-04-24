package com.yoyuen.jdbc.impl;

import com.yoyuen.jdbc.dao.bookDao;
import com.yoyuen.jdbc.entity.Book;
import com.yoyuen.jdbc.service.BookService;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Component
@Service
public class bookDaoImpl implements BookService {

    bookDao bookDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private Trigger trigger;

    @Autowired
    private JobDetail jobDetail;

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
        try {
            scheduler.scheduleJob(trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(String name) {
        String sql = "insert into book(name) values(?)";
        jdbcTemplate.update(sql, name);
    }

    @Override
    public List<Book> getAllBooksName() {
        String sql = "select * from book";
        return jdbcTemplate.query(sql, new RowMapper<Book>(){
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                String username = rs.getString("name");
                String auther = rs.getString("author");
                double price = rs.getDouble("price");
                return new Book(username, auther, price);
            }
        });
    }
}
