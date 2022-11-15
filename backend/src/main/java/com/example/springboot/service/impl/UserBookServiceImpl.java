package com.example.springboot.service.impl;

import com.example.springboot.entity.UserBook;
import com.example.springboot.mapper.UserBookMapper;
import com.example.springboot.service.IUserBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bay-max
 * @since 2022-11-02
 */
@Service
public class UserBookServiceImpl extends ServiceImpl<UserBookMapper, UserBook> implements IUserBookService {

    /**
     * @param userBook
     * @return
     */
    @Override
    public boolean saveuserBook(UserBook userBook) {
        return saveOrUpdate(userBook);
    }
}
