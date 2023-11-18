package com.chunjae.springbootstudy.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class HomeCtrl {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Locale locale, Model model) { return "index";}
}
