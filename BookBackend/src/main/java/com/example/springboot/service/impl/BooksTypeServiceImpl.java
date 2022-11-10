package com.example.springboot.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.BooksType;
import com.example.springboot.mapper.BooksTypeMapper;

import com.example.springboot.service.IBooksTypeService;
import org.springframework.stereotype.Service;

@Service
public class BooksTypeServiceImpl extends ServiceImpl<BooksTypeMapper, BooksType> implements IBooksTypeService {

    @Override
    public boolean saveBooksType(BooksType booksType) {
        return saveOrUpdate(booksType);
    }
}
