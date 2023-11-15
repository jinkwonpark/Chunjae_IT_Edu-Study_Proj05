package com.chunjae.springbootstudy.persis;

import com.chunjae.springbootstudy.entity.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    // 자유게시판 목록
    @Select("select * from board")
    public List<Board> boardList();
    // 자유게시판 상세보기
    @Select("select * from board where bno = #{bno}")
    public Board boardDetail(Integer bno);
    // 자유게시판 글쓰기
    @Insert("insert into board(title, content, author) values(#{title}, #{content}, #{author})")
    public void boardInsert(Board board);
    // 자유게시판 글 수정하기
    @Update("update board set title = #{title}, content = #{content} where bno = #{bno}")
    public void boardEdit(Board board);
    // 자유게시판 글 삭제하기
    @Delete("delete from board where bno = #{bno}")
    public void boardDelete(Integer bno);
}