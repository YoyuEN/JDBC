package com.yoyuen.jdbc.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yoyuen.jdbc.dao.bookDao;
import com.yoyuen.jdbc.entity.Book;
import com.yoyuen.jdbc.mapper.BookMapper;
import com.yoyuen.jdbc.repository.AdminRepository;
import com.yoyuen.jdbc.service.BookService;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Component
@Service
public class bookDaoImpl implements BookService {

    bookDao bookDao;
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BookMapper bookMapper;

//    @Autowired
//    private Scheduler scheduler;

//    @Autowired
//    private Trigger trigger;

//    @Autowired
//    private JobDetail jobDetail;

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
//        try {
//            scheduler.scheduleJob(trigger);
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
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
                int id = rs.getInt("id");
                String username = rs.getString("name");
                String auther = rs.getString("author");
                double price = rs.getDouble("price");
                return new Book(id, username, auther, price);
            }
        });
    }

    @Override
    public PageInfo<Book> findBookByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);  //指定分页的参数
        List<Book> lists = getAllBooksName();
        //SQL仍然查询所有图书，拦截器截住这个查询语句，顺势加入limit (PageNo-1)*pageSize
        return new PageInfo<Book>(lists);
    }
}
