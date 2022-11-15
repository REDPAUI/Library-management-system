package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@TableName(value = "tb_user")
@ToString
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String user;
    //如果不想展示密码可以添加注解
//    @JsonIgnore
    private String passwd;

}
