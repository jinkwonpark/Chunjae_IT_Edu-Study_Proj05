package com.chunjae.springbootstudy.service;

import com.chunjae.springbootstudy.entity.Board;

import java.util.List;

public interface BoardService {
    public List<Board> boardList();
    public Board boardDetail(Integer bno);
    public void boardInsert(Board board);
    public void boardEdit(Board board);
    public void boardDelete(Integer bno);
    public void boardVisited(Integer bno);
}