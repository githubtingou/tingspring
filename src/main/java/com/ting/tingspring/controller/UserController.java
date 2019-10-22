package com.ting.tingspring.controller;

import com.ting.tingspring.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户Controller
 *
 * @author LISHUANG
 * @date 2019/10/22
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {
    /**
     * 获取用户信息
     *
     * @param userDto 入参
     * @return userDto返参
     */
    @RequestMapping(value = "getUser")
    public UserDto getUser(@RequestBody UserDto userDto) {
        return userDto;
    }

}
