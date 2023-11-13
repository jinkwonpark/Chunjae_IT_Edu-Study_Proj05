package com.chunjae.springbootstudy.persis;

import com.chunjae.springbootstudy.entity.Faq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FaqMapper {
    @Select("select * from faq")
    public List<Faq> faqList();
}
