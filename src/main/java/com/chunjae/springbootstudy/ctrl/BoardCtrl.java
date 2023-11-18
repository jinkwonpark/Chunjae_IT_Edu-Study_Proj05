package com.chunjae.springbootstudy.ctrl;

import com.chunjae.springbootstudy.entity.Board;
import com.chunjae.springbootstudy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board/*")
public class BoardCtrl {

    @Autowired
    private BoardService boardService;

    // 자유게시판 목록
    @GetMapping("boardList")
    public String boardList(Model model) {
        List<Board> boardList = boardService.boardList();
        model.addAttribute("boardList", boardList);
        return "board/boardList";
    }

    // 자유게시판 상세보기
    @GetMapping("boardDetail")
    public String boardDetail(HttpServletRequest request, Model model) {
        Integer bno = Integer.parseInt(request.getParameter("bno"));
        // 조회수 증가 넣기
        Board boardDetail = boardService.boardDetail(bno);
        model.addAttribute("bd", boardDetail);
        return "board/boardDetail";
    }

    // 자유게시판 글 삭제하기
    @GetMapping("boardDelete")
    public String boardDelete(HttpServletRequest request, Model model) {
        Integer bno = Integer.parseInt(request.getParameter("bno"));
        boardService.boardDelete(bno);
        return "redirect:boardList";
    }

    // 자유게시판 글쓰기
    @GetMapping("boardInsert")
    public String boardInsertForm(HttpServletRequest request, Model model) {
        return "board/boardInsert";
    }

    @PostMapping("boardInsert")
    public String boardInsert(HttpServletRequest request, Model model) {
        Board boardInsert = new Board();
        boardInsert.setTitle(request.getParameter("title"));
        boardInsert.setContent(request.getParameter("content"));
        boardService.boardInsert(boardInsert);
        return "redirect:boardList";
    }

    // 자유게시판 수정하기
    @GetMapping("boardEdit")
    public String boardEditForm(HttpServletRequest request, Model model) {
        Integer bno = Integer.parseInt(request.getParameter("bno"));
        Board boardEdit = boardService.boardDetail(bno);
        model.addAttribute("boardEdit", boardEdit);
        return "board/boardEdit";
    }

    @PostMapping("boardEdit")
    public String boardEdit(HttpServletRequest request, Model model) {
        Integer bno = Integer.parseInt(request.getParameter("bno"));
        Board boardEdit = new Board();
        boardEdit.setBno(bno);
        boardEdit.setTitle(request.getParameter("title"));
        boardEdit.setContent(request.getParameter("content"));
        boardService.boardEdit(boardEdit);
        return "redirect:boardList";
    }
}

//    boolean canDelete = false;
//      if(로그인한 아이디 작성자) {
//        canDelete = true;
//        }
//        model.