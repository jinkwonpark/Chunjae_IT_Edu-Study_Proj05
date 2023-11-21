package com.chunjae.springbootstudy.service;

import com.chunjae.springbootstudy.entity.User;
import com.chunjae.springbootstudy.persis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> userList() { return userMapper.userList(); }

    @Override
    public User userDetail(Integer uno) { return userMapper.userDetail(uno); }

    @Override
    public void userInsert(User user) { userMapper.userInsert(user); }

    @Override
    public void userEdit(User user) { userMapper.userEdit(user); }

    @Override
    public void userDelete(Integer uno) { userMapper.userDelete(uno); }

    @Override
    public User userLogin(String id) { return userMapper.userLogin(id); }

    //아이디 중복 확인
    @Override
    public boolean idCheck(String id) {
        boolean pass = true;
        int cnt = userMapper.idCheck(id);
        if(cnt>0) pass = false;
        return pass;
    }
}