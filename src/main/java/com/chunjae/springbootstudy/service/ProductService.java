package com.chunjae.springbootstudy.service;

import com.chunjae.springbootstudy.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> productList();
    public Product productDetail(Integer pno);
    public void productInsert(Product product);
    public void productEdit(Product product);
    public void productDelete(Integer pno);
}