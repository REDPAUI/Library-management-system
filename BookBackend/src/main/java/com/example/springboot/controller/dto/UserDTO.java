package com.example.springboot.controller.dto;
import lombok.Data;

/**
 * 接受前端请求的参数
 */
@Data
public class UserDTO {
    private Integer id;
    private String user;
    private String passwd;
    private String token;

}
