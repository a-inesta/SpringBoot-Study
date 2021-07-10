package com.kuang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/books")
    public List<Map<String,Object>> userList() {
        String sql = "select * from books";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/addBooks")
    public String addBook() {
        String sql = "insert into ssmbuild.books (bookID,bookName,bookCounts,detail) values (9,'墓主的产后护理','123123'" +
                ",'改革春风吹满地')";
        jdbcTemplate.update(sql);
        return "update-ok";
    }

    @GetMapping("/delBooks/{id}")
    public String delBook(@PathVariable("id") Integer id) {
        String sql = "delete from ssmbuild.books where bookID=" + id;
        jdbcTemplate.update(sql);
        return "deleteBooks-ok";
    }

    @GetMapping("/updateBooks/{bookCounts}/{id}")
    public String updateBook(@PathVariable("bookCounts") Integer bookCounts, @PathVariable("id") Integer id) {
        String sql = "update ssmbuild.books set bookCounts=?  where bookID=?";
        Object[] objects = new Object[2];
        objects[0] = bookCounts;
        objects[1] = id;
        jdbcTemplate.update(sql,objects);
        return "redirect:/books";
    }


}
