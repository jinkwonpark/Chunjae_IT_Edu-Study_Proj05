package com.chunjae.springbootstudy.persis;

import com.chunjae.springbootstudy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    // 회원 목록
    @Select("select * from user")
    public List<User> userList();
    // 회원 목록 상세보기
    @Select("select * from user where id = #{id}")
    public User userDetail(Integer id);
    // 회원 정보 수정
    // @Update("updaet user set ")

    // pwd, name, email, tel, addr1, addr2,
}
