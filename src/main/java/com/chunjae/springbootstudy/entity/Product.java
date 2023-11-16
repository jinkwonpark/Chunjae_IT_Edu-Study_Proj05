package com.chunjae.springbootstudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer pno;
    private String title;
    private String content;
    private String price;
    private Integer location;
    private Integer status;
    private String author;
    private String regdate;
    private Integer visited;
    private String contact;
}
