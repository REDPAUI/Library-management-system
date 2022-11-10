package com.example.springboot.service;

import com.example.springboot.entity.UserBook;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bay-max
 * @since 2022-11-02
 */
public interface IUserBookService extends IService<UserBook> {

    boolean saveuserBook(UserBook userBook);
}
