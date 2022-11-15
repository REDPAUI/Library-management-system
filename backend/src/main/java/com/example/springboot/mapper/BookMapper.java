package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper  extends BaseMapper<Book> {

//    @Select("select * from sys_user limit #{pageNum},#{pageSize}")
//@Select("select * from tb_books  limit #{pageNum} , #{pageSize} ")
//    List<Book> selectPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize );
//
//    //查询总条数
//    @Select("SELECT COUNT(*) FROM tb_books ")
//    Integer selectTotal();
}
