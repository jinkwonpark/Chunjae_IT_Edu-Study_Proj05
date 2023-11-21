package com.chunjae.springbootstudy.service;

import com.chunjae.springbootstudy.entity.User;

import java.util.List;

public interface UserService {
    // 회원 목록
    public List<User> userList();
    // 회원 상세보기
    public User userDetail(Integer uno);
    // 회원 등록하기
    public void userInsert(User user);
    // 회원 정보 수정하기
    public void userEdit(User user);
    // 회원 삭제하기
    public void userDelete(Integer uno);
    // 회원 로그인
    public User userLogin(String id);
    // 아이디 중복 확인
    public boolean idCheck (String id);
}