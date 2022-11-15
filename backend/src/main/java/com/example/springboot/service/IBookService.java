package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.entity.Book;
import com.example.springboot.entity.BooksType;

import java.util.List;

public interface IBookService extends IService<Book> {
    boolean saveBook(Book book);

}
