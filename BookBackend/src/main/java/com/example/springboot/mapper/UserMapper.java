package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.*;

//数据库接口
//@Mapper
public interface UserMapper extends BaseMapper<User> {
////查询所有数据
//    @Select("Select * from sys_user")
//    List<User> findAll();
////    添加数据
//    @Insert("INSERT INTO sys_user(username, password, nickname, email, phone, address)VALUES(#{username},#{password},#{nickname},#{email},#{phone},#{address})")
//    int insert(User user);6
////    修改数据
//   // @Update("UPDATE sys_user SET username=#{username}, password=#{password}, nickname=#{nickname}, email=#{email}, phone=#{phone}, address=#{address} WHERE id=#{id}")
//    int update(User user);
//
    //删除数据
//    @Delete("DELETE FROM sys_user WHERE id=#{id}")
//    Integer deleteById(@Param("id") Integer id);


//    //分页
//    @Select("select * from sys_user limit #{pageNum} , #{pageSize} ")
//    List<User> selectPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
//
////查询总条数
//    @Select("select  count(*) from sys_user ")
//    Integer selectTotal();
}
