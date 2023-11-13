package com.chunjae.springbootstudy.ctrl;

import com.chunjae.springbootstudy.entity.Product;
import com.chunjae.springbootstudy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product/*")
public class ProductCtrl {

    @Autowired
    private ProductService productService;

    // 상품 목록
    @GetMapping("productList")
    public String productList(Model model) {
        List<Product> productList = productService.productList();
        model.addAttribute("productList", productList);
        return "product/productList";
    }

    // 상품 상세보기
    @GetMapping("productDetail")
    public String productDetail(HttpServletRequest request, Model model) {
        Integer pno = Integer.parseInt(request.getParameter("pno"));
        Product productDetail = productService.productDetail(pno);
        model.addAttribute("pd", productDetail);
        return "product/productDetail";
    }

    // 상품 글 삭제하기
    @GetMapping("productDelete")
    public String productDelete(HttpServletRequest request, Model model) {
        Integer pno = Integer.parseInt(request.getParameter("pno"));
        productService.productDelete(pno);
        return "redirect:productList";
    }

    // 상품 글쓰기
    @GetMapping("productInsert")
    public String productInsertForm(HttpServletRequest request, Model model) {
        return "product/productInsert";
    }

    @PostMapping("productInsert")
    public String productInsert(HttpServletRequest request, Model model) {
        Product productInsert = new Product();
        productInsert.setTitle(request.getParameter("title"));
        productInsert.setContent(request.getParameter("content"));
        productService.productInsert(productInsert);
        return "redirect:productList";
    }
    
    // 상품 수정하기
}
