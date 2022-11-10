package com.example.springboot.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Constants;
import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.UserDTO;
import com.example.springboot.entity.User;
import com.example.springboot.service.IUserService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")//这个注解是统一的给结构加前缀
public class UserController {
    @Resource
    private IUserService userService;
//增加或修改数据
    @PostMapping
    public  boolean save(@RequestBody User user) {//前台转json数据转java对象
        //新+或者更新
        return userService.saveUser(user);
    }

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUser();
        String password = userDTO.getPasswd();
      if(StrUtil.isBlank(username)||StrUtil.isBlank(password)){
          return Result.error(Constants.CODE_400,"参数错误");
      }
       UserDTO dto= userService.login(userDTO);

        return Result.success(dto);
    }

    //注册
    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO){
        String user = userDTO.getUser();
        String passwd = userDTO.getPasswd();
        if(StrUtil.isBlank(user)||StrUtil.isBlank(passwd)){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        return Result.success(userService.register(userDTO));
    }
    //个人信息
    @PostMapping("/search")
    public Result search(@RequestBody UserDTO userDTO) {
           return Result.success(userService.search(userDTO));
    }
    //查询数据
    @GetMapping
    public List<User> index() {
        return userService.list();
    }

    //分页查询，mybatisPlus的方法
    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize, @RequestParam(defaultValue = "") String user){
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(!"".equals(user)){
            queryWrapper.like("user",user);
        }
        return userService.page(page,queryWrapper);
    }
    //删除数据
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {return userService.removeById(id);}
    //批量删除接口
    @PostMapping ("/del/batch")
    public Boolean deleteBatch(@RequestBody List<Integer> ids ) {return userService.removeByIds(ids);}




}
