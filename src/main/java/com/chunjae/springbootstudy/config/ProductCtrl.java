package com.chunjae.springbootstudy.config;

import com.chunjae.springbootstudy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/*")
public class ProductCtrl {
    @Autowired
    private ProductService productService;

    // 상품 목록
    @GetMapping("productList")
    public String productList(Model model) {

    }
}
