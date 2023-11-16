package com.chunjae.springbootstudy.persis;

import com.chunjae.springbootstudy.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    // 상품 목록
    @Select("select * from product")
    public List<Product> productList();
    // 상품 상세보기
    @Select("select * from product where pno = #{pno}")
    public Product productDetail(Integer pno);
    // 상품 글쓰기
    @Insert("insert into product(title, content, price, location, author, contact) values(#{title}, #{content}, #{price}, #{location}, #{author}, #{contact})")
    public void productInsert(Product product);
    // 상품 글 수정하기
    @Update("update product set title = #{title}, content = #{content}, price = #{price}, location = #{location}, status = #{status}, contact = #{contact} where pno = #{pno}")
    public void productEdit(Product product);
    // 상품 글 삭제하기
    @Delete("delete from product where pno = #{pno}")
    public void productDelete(Integer pno);
}