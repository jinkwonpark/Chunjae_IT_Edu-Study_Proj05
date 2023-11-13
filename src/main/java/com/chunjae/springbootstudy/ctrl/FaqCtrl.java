package com.chunjae.springbootstudy.ctrl;

import com.chunjae.springbootstudy.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faq/*")
public class FaqCtrl {
    @Autowired
    private FaqService faqService;

    @GetMapping
}
