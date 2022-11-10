package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.BooksType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public  interface BooksTypeMapper extends BaseMapper<BooksType> {
//    //分页
//    @Select("select * from tb_books_type WHERE isdelete=0  limit #{pageNum} , #{pageSize} ")
//    List<BooksType> selectPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize );
//    //查询总条数
//    @Select("SELECT COUNT(*) FROM tb_books_type WHERE isdelete=0")
//    Integer selectTotal();
}
