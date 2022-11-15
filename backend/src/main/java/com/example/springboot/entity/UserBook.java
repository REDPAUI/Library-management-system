package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_user_book")
public class UserBook {
    @TableId(type = IdType.AUTO)
    private  Integer id;
    private String userid;
    private String bookid;
    private Date begintime;
    private Date endtime;
    private Boolean  stat;
}
