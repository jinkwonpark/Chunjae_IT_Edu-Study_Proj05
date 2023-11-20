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

    // 회원가입
    @GetMapping("join")
    public String userInsertForm() { return "user/join"; }

    @PostMapping("join")
    public String userInsert(HttpServletRequest request, Model model) {
        User userInsert = new User();
        userInsert.setId(request.getParameter("id"));
        userInsert.setPw(request.getParameter("pw"));
        userInsert.setName(request.getParameter("name"));
        userInsert.setTel(request.getParameter("tel"));
        userInsert.setEmail(request.getParameter("email"));
        userInsert.setAddr1(request.getParameter("addr1"));
        userInsert.setAddr2(request.getParameter("addr2"));
        userInsert.setPostcode(request.getParameter("postcode"));
        //userService.userInsert(userInsert);
        return "redirect:/user/login";  // url 링크, postmapping일때 redirect
        //return "user/login"; // html 파일
    }

    // 마이페이지
    @GetMapping("myPage")
    public String myPage() { return "user/myPage"; }

    // 회원정보 상세보기
    @GetMapping("userDetail")
    public String userDetail(HttpServletRequest request, Model model) {
        Integer uno = Integer.parseInt(request.getParameter("uno"));
        User userDetail = userService.userDetail(uno);
        model.addAttribute("ud", userDetail);
        return "user/userDetail";
    }

    // 회원정보 수정하기
    @GetMapping("userEdit")
    public String userEditForm(HttpServletRequest request, Model model) {
        Integer uno = Integer.parseInt(request.getParameter("uno"));
        User userEdit = userService.userDetail(uno);
        model.addAttribute("userEdit", userEdit);
        return "userEdit";
    }

    @PostMapping("userEdit")
    public String userEdit(HttpServletRequest request, Model model) {
        Integer uno = Integer.parseInt(request.getParameter("uno"));
        User userEdit = new User();
        userEdit.setUno(uno);
        userEdit.setPw("pw");
        userEdit.setName("name");
        userEdit.setTel("tel");
        userEdit.setEmail("email");
        userEdit.setAddr1("addr1");
        userEdit.setAddr2("addr2");
        userEdit.setPostcode("postcode");
        userService.userEdit(userEdit);
        return "redirect:myPage";
    }
}