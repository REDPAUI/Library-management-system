package com.example.springboot.controller;


import com.example.springboot.entity.UserBooksOV;
import com.example.springboot.mapper.UserBooksOVMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ubookov")
public class UserBooksOVController {
    @Autowired
    private UserBooksOVMapper userBooksOVMapper;

    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<UserBooksOV> data = userBooksOVMapper.selectPage(pageNum, pageSize);
        Integer total = userBooksOVMapper.selectTotal();
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
    //单个用户查询
    @GetMapping("/pageOne")
    public Map<String, Object> findPageOne(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Integer id) {
        pageNum = (pageNum - 1) * pageSize;
        List<UserBooksOV> data = userBooksOVMapper.searchOne(pageNum, pageSize,id);
        Integer total = userBooksOVMapper.selectTotalOne(id);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

}
