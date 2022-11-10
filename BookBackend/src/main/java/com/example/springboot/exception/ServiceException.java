package com.example.springboot.exception;

import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class ServiceException extends RuntimeException{
    private String code;

    public ServiceException(String code, String msg){//构造器
        super(msg);
        this.code = code;
    }


}
