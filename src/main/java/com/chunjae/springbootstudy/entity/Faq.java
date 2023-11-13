package com.chunjae.springbootstudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faq {
    private Integer fno;
    private String question;
    private String answer;
}
