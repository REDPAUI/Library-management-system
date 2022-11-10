package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Files;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FileMapper extends BaseMapper<Files> {

    @Select("select * from sys_file")
    List<Files> findAll();
    //分页
    @Select("select * from sys_file WHERE isdelete=0  limit #{pageNum} , #{pageSize} ")
    List<Files> selectPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize );
   //查询总条数
    @Select("SELECT COUNT(*) FROM sys_file WHERE isdelete=0")
    Integer selectTotal();
    @Select("select * from sys_file WHERE isdelete=0 and `name` LIKE '%#{name}%' limit #{pageNum} , #{pageSize} ")
    List<Files> findone(@Param("name") String name, @Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
    @Select("select * from sys_file WHERE isdelete=0 AND name LIKE '%#{name%}'")
    Integer searchTotal();
}
