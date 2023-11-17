package com.chunjae.springbootstudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer uno;
    private String id;
    private String pw;
    private String name;
    private String tel;
    private String email;
    private String addr1;
    private String addr2;
    private String postcode;
    private String regdate;
}
