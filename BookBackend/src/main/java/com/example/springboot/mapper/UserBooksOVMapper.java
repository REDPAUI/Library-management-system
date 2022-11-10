package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.UserBooksOV;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserBooksOVMapper extends BaseMapper<UserBooksOV> {
    @Select("SELECT ub.id,b.bookname,u.user,ub.begintime,ub.endtime,ub.stat,bt.type FROM tb_user_book ub, tb_user u, tb_books b , tb_books_type bt WHERE ub.userid=u.id and ub.bookid=b.id and b.bookcategory=bt.id limit #{pageNum},#{pageSize}")
    List<UserBooksOV> selectPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    @Select("SELECT COUNT(*) FROM tb_user_book ub, tb_user u, tb_books b , tb_books_type bt WHERE ub.userid=u.id and ub.bookid=b.id and b.bookcategory=bt.id ")
    Integer    selectTotal();
    //固定用户查询
    @Select("SELECT ub.id,b.bookname,u.user,ub.begintime,ub.endtime,ub.stat,bt.type FROM tb_user_book ub, tb_user u, tb_books b , tb_books_type bt WHERE ub.userid=u.id and ub.bookid=b.id and b.bookcategory=bt.id and u.id=#{id} limit #{pageNum},#{pageSize}")
    List<UserBooksOV> searchOne(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("id") Integer id);
    @Select("SELECT COUNT(*) FROM tb_user_book ub, tb_user u, tb_books b , tb_books_type bt WHERE ub.userid=u.id and ub.bookid=b.id and b.bookcategory=bt.id and u.id=#{id}")
    Integer    selectTotalOne(Integer id);
//    搜索方法

}
