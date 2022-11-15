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
    //条数查询
  @GetMapping("/nu")
    public Integer find(){
        return userBooksOVMapper.selectTotalT();
  }
  //条件查询
    @GetMapping("/pasc")
    public Map<String, Object> fin(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String user, @RequestParam String bookname , @RequestParam String stat, @RequestParam String begintime, @RequestParam String endtime ) {
        pageNum = (pageNum - 1) * pageSize;
        user="%"+ user+"%";
        bookname = "%" + bookname + "%";
        stat = "%" + stat + "%";
        begintime= "%" + begintime + "%";
        endtime= "%" + endtime + "%";
        List<UserBooksOV> data = userBooksOVMapper.searchBook(pageNum, pageSize, user,bookname, stat,begintime,endtime);
        Integer total = userBooksOVMapper.selectTotaBook(user,bookname,stat,begintime,endtime);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

}
