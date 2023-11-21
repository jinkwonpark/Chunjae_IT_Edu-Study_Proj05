package com.chunjae.springbootstudy.service;

import com.chunjae.springbootstudy.entity.Board;
import com.chunjae.springbootstudy.persis.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Board> boardList() {
        return boardMapper.boardList();
    }

    @Override
    public Board boardDetail(Integer bno) {
        return boardMapper.boardDetail(bno);
    }

    @Override
    public void boardInsert(Board board) { boardMapper.boardInsert(board); }

    @Override
    public void boardEdit(Board board) {
        boardMapper.boardEdit(board);
    }

    @Override
    public void boardDelete(Integer bno) {
        boardMapper.boardDelete(bno);
    }

    @Override
    public void boardVisited(Integer bno) { boardMapper.boardVisited(bno); }
}
