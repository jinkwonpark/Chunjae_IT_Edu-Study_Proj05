package com.chunjae.springbootstudy.ctrl;

import com.chunjae.springbootstudy.entity.User;
import com.chunjae.springbootstudy.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Log4j2
@Controller
@RequestMapping("/user/*")
public class UserCtrl {

    @Autowired
    private UserService userService;

    @Autowired
    HttpSession httpSession;

    // 로그인
    @GetMapping("login")
    public String userLogin(){
        return "user/login";
    }

    @PostMapping("login")
    public String userLoginPro(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        User userCheck = userService.userLogin(id);
        if(userCheck != null) {
            log.info("userCheck >>>>> " + userCheck.toString());
            if(userCheck.getPw().equals(pw)) {
                httpSession.invalidate();
                httpSession.setAttribute("sid", id);
                System.out.println(httpSession.getAttribute("sid"));
                log.info("pwcheck 맞음");
            } else {
                model.addAttribute("msg", "error02");
                return "redirect:/user/login";
            }
        } else {
            model.addAttribute("msg", "error01");
            return "redirect:/user/login";
        }

        //System.out.println("=================== 로그인 프로1 ===================");
        //log.info("=================== 로그인 프로2 ===================");

        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request, Model model){
        httpSession.invalidate();
        return "redirect:/";
    }

    // 회원약관
    @GetMapping("term")
    public String term() { return "user/term"; }
}