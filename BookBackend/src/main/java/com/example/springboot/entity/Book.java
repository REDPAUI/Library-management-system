package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@TableName(value = "tb_books")
public class Book {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String isbn;
    private String bookname;
    private BigDecimal bookprice;
    private String bookauthor;
    private String publishedhouse;
    private  Integer bookcategory;


}
