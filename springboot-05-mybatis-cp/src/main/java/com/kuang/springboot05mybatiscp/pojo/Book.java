package com.kuang.springboot05mybatiscp.pojo;

import lombok.Data;

@Data
public class Book {
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
