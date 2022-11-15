package com.example.springboot.mapper;

import com.example.springboot.entity.UserBook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author bay-max
 * @since 2022-11-02
 */
@Mapper
public interface UserBookMapper extends BaseMapper<UserBook> {

}
