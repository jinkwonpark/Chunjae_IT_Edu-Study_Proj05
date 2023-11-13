package com.chunjae.springbootstudy.service;

import com.chunjae.springbootstudy.entity.Product;
import com.chunjae.springbootstudy.persis.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> productList() { return productMapper.productList(); }

    @Override
    public Product productDetail(Integer pno) { return productMapper.productDetail(pno); }

    @Override
    public void productInsert(Product product) { productMapper.productInsert(product); }

    @Override
    public void productEdit(Product product) { productMapper.productEdit(product); }

    @Override
    public void productDelete(Integer pno) { productMapper.productDelete(pno); }
}
