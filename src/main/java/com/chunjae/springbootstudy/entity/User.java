package com.chunjae.springbootstudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String userId;
    private String pwd;
    private String name;
    private String email;
    private String tel;
    private String addr1;
    private String addr2;
    private String regdate;
}