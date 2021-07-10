package com.kuang.springboot05mybatiscp.mapper;

import com.kuang.springboot05mybatiscp.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    List<Book> queryBookList();

    Book queryBookById(int id);

    int addBook(Book book);

    int updateBook(Book book);

    int deleteBook(int id);
}
