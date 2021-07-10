package com.kuang.controller;

import com.kuang.mapper.BookMapper;
import com.kuang.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookMapper bookMapper;

    @ResponseBody
    @RequestMapping("/bookList")
    public String bookList() {
        List<Book> books = bookMapper.queryBookList();
        return books.toString();
    }
}
