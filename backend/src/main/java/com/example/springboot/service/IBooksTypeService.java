package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.controller.dto.UserDTO;
import com.example.springboot.entity.BooksType;
import com.example.springboot.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bay-max
 * @since 2022-10-23
 */
public interface IBooksTypeService extends IService<BooksType> {

    boolean saveBooksType(BooksType booksType);
}
