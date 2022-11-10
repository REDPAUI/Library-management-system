package com.example.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.Book;
import com.example.springboot.entity.BooksType;
import com.example.springboot.entity.User;
import com.example.springboot.service.IBookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private IBookService bookService;

    @GetMapping
    public List<Book> index() {
//      List<User> all= userMapper.findAll();return all;
        return bookService.list();
    }

    @PostMapping
    public  boolean save(@RequestBody Book book) {//前台转json数据转java对象
        //新+或者更新
        return bookService.saveBook(book);
    }

    @GetMapping("/page")
    public IPage<Book> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize , @RequestParam(defaultValue = "") String bookname){
        IPage<Book> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        if(!"".equals(bookname)){
            queryWrapper.like("bookname",bookname);
        }
        return bookService.page(page,queryWrapper);
    }
    //删除数据
    @DeleteMapping("/{id}")
//    public Integer delete(@PathVariable Integer id) {return  userMapper.deleteById(id);}
    public Boolean delete(@PathVariable Integer id) {return bookService.removeById(id);}
    //批量删除接口
    @PostMapping ("/del/batch")
    public Boolean deleteBatch(@RequestBody List<Integer> ids ) {return bookService.removeByIds(ids);}

}
