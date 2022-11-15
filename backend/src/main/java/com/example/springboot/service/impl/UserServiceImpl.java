package com.example.springboot.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.common.Constants;
import com.example.springboot.controller.dto.UserDTO;
import com.example.springboot.entity.User;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.IUserService;
import com.example.springboot.utils.TokenUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bay-max
 * @since 2022-10-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private static final Log LOG = Log.get();

    @Override
    public UserDTO login(UserDTO userDTO) {
       User one = getUserInfo(userDTO);
       //业务异常
        if(one != null){
            BeanUtil.copyProperties(one, userDTO,true);
            //设置token
            String token= TokenUtils.genToken(one.getId().toString(), one.getPasswd());
            userDTO.setToken(token);
            return userDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    @Override
    public boolean saveUser(User user) {
        return saveOrUpdate(user);
    }

    @Override
    public User register(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if(one == null){
//            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
            one = new User();
            BeanUtil.copyProperties(userDTO,one,true);
            save(one);//copy的数据存入sql
        }else {
            throw new ServiceException(Constants.CODE_600, "用户名已存在");
        }
        return one;
    }

    @Override
    public UserDTO search(UserDTO userDTO) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user",userDTO.getUser());
        User one=getOne(wrapper);
        if(one!=null){
            BeanUtil.copyProperties(one,userDTO,true);
            return userDTO;
        }else{
            throw new ServiceException(Constants.CODE_600, "00");
        }
    }

    private User getUserInfo(UserDTO userDTO) {
     QueryWrapper<User> queryWrapper = new QueryWrapper<>();
     queryWrapper.eq("user", userDTO.getUser());
     queryWrapper.eq("passwd", userDTO.getPasswd());
     // 处理异常情况
     User one;
     try {
         one = getOne(queryWrapper);//从数据库查询用户信息
     } catch (Exception e) {
         LOG.error(e);
         throw new ServiceException(Constants.CODE_500, "系统错误");
     }
     return one;
 }
}
