package com.example.springboot.service.impl;


import com.example.springboot.entity.Book;
import com.example.springboot.entity.BooksType;
import com.example.springboot.mapper.BookMapper;
import com.example.springboot.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService{
    public boolean saveBook(Book book) {
        return saveOrUpdate(book);
    }
}

