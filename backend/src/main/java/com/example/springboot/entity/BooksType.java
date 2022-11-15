package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@TableName(value = "tb_books_type")
@ToString
public class BooksType {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String type;
    private Integer typemaxnum;
}
