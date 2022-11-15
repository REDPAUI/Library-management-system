package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
public class UserBooksOV {
    //多表数据
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String bookname;
    private String user;
    private Date begintime;
    private Date endtime;
    private Boolean  stat;
    private String type;
}
