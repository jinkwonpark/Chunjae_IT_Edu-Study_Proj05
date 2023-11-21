package com.chunjae.springbootstudy.ctrl;

import com.chunjae.springbootstudy.entity.User;
import com.chunjae.springbootstudy.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/user/*")
public class UserCtrl {

    @Autowired
    private UserService userService;

    @Autowired
    HttpSession httpSession;

    // 회원목록
    @GetMapping("userList")
    public String userList(Model model) {
        List<User> userList = userService.userList();
        model.addAttribute("userList", userList);
        return "user/userList";
    }

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
                httpSession.setAttribute("suno", userCheck.getUno());
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

    // 로그아웃
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
        userService.userInsert(userInsert);
        return "redirect:/user/login";  // url 링크, postmapping일때 redirect
        //return "user/login"; // html 파일
    }

     // 아이디 중복 확인
     @PostMapping("idCheckPro")
     public ResponseEntity idCheckPro(@RequestBody User user) {
         String id = user.getId();
         boolean result = userService.idCheck(id);
         return new ResponseEntity<>(result, HttpStatus.OK);
     }

    // 마이페이지
    @GetMapping("myPage")
    public String myPage() { return "user/myPage"; }

    // 회원정보 상세보기
    @GetMapping("userDetail")
    public String userDetail(HttpServletRequest request, Model model) {
        Integer uno = (Integer) httpSession.getAttribute("suno");
        User userDetail = userService.userDetail(uno);
        model.addAttribute("ud", userDetail);
        return "user/userDetail";
    }

    // 회원정보 수정하기
    @GetMapping("userEdit")
    public String userEditForm(HttpServletRequest request, Model model) {
        Integer uno = (Integer) httpSession.getAttribute("suno");
//        Integer uno = Integer.parseInt(request.getParameter("uno"));
        User userEdit = userService.userDetail(uno);
        model.addAttribute("userEdit", userEdit);
        return "user/userEdit";
    }

    @PostMapping("userEdit")
    public String userEdit(HttpServletRequest request, Model model) {
        Integer uno = (Integer) httpSession.getAttribute("suno");
        User userEdit = new User(); // 전체 정보 업데이트 방식
//        User userEdit = userService.userDetail(uno); // 부분 정보 업데이트 방식
        userEdit.setUno(uno);
        userEdit.setPw(request.getParameter("pw"));
        userEdit.setName(request.getParameter("name"));
        userEdit.setTel(request.getParameter("tel"));
        userEdit.setEmail(request.getParameter("email"));
        userEdit.setAddr1(request.getParameter("addr1"));
        userEdit.setAddr2(request.getParameter("addr2"));
        userEdit.setPostcode(request.getParameter("postcode"));
//        System.out.println("-------------------------");
//        System.out.println(userEdit.toString());
        userService.userEdit(userEdit);
        return "redirect:myPage";
    }

    // 회원 탈퇴하기
    @GetMapping("userDelete")
    public String userDelete(HttpServletRequest request, Model model) {
        Integer uno = (Integer) httpSession.getAttribute("suno");
//        Integer uno = Integer.parseInt(request.getParameter("uno"));
        userService.userDelete(uno);
        httpSession.invalidate();
        return "redirect:/";
    }
}