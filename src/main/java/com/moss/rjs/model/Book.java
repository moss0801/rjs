package com.moss.rjs.model;

import java.util.Date;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String content;
    private Integer price = 10000;
    private Integer salePrice = 5000;
    private String isbn = "9791130604084";
    private Date publishDate = new Date();
    private Integer page = 352;
    private Integer weight = 448;
    private Integer salePoint = 37371;
}
