package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Files;
import com.example.springboot.entity.UserBook;
import com.example.springboot.mapper.UserBookMapper;
import com.example.springboot.service.IUserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ubook")
public class UserBookController {
    @Resource
    private IUserBookService userBookService;

    @Autowired
    private UserBookMapper userBookMapper;
//fen
    @GetMapping("/page")
    public IPage<UserBook> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        IPage<UserBook> page = new Page<>(pageNum, pageSize);
        QueryWrapper<UserBook> queryWrapper = new QueryWrapper<>();

        return userBookService.page(page,queryWrapper);
    }
    @PostMapping
    public  boolean save(@RequestBody UserBook userBook) {//前台转json数据转java对象
        //新+或者更新
        return userBookService.saveuserBook(userBook);
    }
    //删除数据
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {return userBookService.removeById(id);}
    //批量删除接口
    @PostMapping ("/del/batch")
    public Boolean deleteBatch(@RequestBody List<Integer> ids ) {return userBookService.removeByIds(ids);}
//用户端查询接口
    @GetMapping("/userpage")
    public IPage<UserBook> findUserPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") Integer userid) {
        IPage<UserBook> page = new Page<>(pageNum, pageSize);
        QueryWrapper<UserBook> queryWrapper = new QueryWrapper<>();
        if (!"".equals(userid)) {
            queryWrapper.like("userid", userid);
        }
        return userBookService.page(page, queryWrapper);
    }
}
