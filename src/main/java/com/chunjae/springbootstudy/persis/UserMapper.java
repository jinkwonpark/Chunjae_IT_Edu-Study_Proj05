package com.chunjae.springbootstudy.persis;

import com.chunjae.springbootstudy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    // 회원 목록
    @Select("select * from user")
    public List<User> userList();
    // 회원 상세보기
    @Select("select * from user where uno = #{uno}")
    public User userDetail(Integer uno);
    // 회원 등록하기
    @Insert("insert into user(id, pw, name, tel, email, addr1, addr2, postcode) values (#{id}, #{pw}, #{name}, #{tel}, #{email}, #{addr1}, #{addr2}, #{postcode})")
    public void userInsert(User user);
    // 회원 정보 수정하기
    @Update("update user set pw = #{pw}, name = #{name}, tel = #{tel}, email = #{email}, addr1 = #{addr1}, addr2 = #{addr2}, postcode = #{postcode}")
    public void userEdit(User user);
    // 회원 삭제하기
    @Delete("delete from user where uno = #{uno}")
    public void userDelete(Integer uno);
    // 회원 로그인
    @Select("select * from user where id = #{id}")
    public User userLogin(String id);
}