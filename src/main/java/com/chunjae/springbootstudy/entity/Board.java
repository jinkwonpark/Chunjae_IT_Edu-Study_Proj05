package com.chunjae.springbootstudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private Integer bno;
    private String title;
    private String content;
    private String author;
    private String regdate;
    private Integer visited;
}