package com.example.springboot.service;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.UserDTO;
import com.example.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bay-max
 * @since 2022-10-23
 */
public interface IUserService extends IService<User> {


    UserDTO login(UserDTO userDTO);
    boolean saveUser(User user);

    User register(UserDTO userDTO);

    UserDTO search(UserDTO userDTO);

}
