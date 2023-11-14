package com.chunjae.springbootstudy.ctrl;

import com.chunjae.springbootstudy.entity.Faq;
import com.chunjae.springbootstudy.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/faq/*")
public class FaqCtrl {

    @Autowired
    private FaqService faqService;

    // FAQ
    @GetMapping("faqList")
    public String faqList(Model model) {
        List<Faq> faqList = faqService.faqList();
        model.addAttribute("faqList", faqList);
        return "faq/faqList";
    }
}
