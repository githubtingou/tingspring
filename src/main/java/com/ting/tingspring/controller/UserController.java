package com.ting.tingspring.controller;

import com.alibaba.fastjson.JSON;
import com.ting.tingspring.commom.ResponseCode;
import com.ting.tingspring.dto.UserDto;
import com.ting.tingspring.handle.MyException;
import com.ting.tingspring.spring.PropertisCustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
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

    @Value("${ting.age}")
    private int age;

    @Value("${ting.name}")
    private String name;

    @Autowired
    private PropertisCustom propertisCustom;

    /**
     * 获取用户信息
     *
     * @param userDto 入参
     * @return userDto返参
     */
    @RequestMapping(value = "getUser")
    public UserDto getUser(@RequestBody UserDto userDto) {
        log.info("hashMap--->{}", JSON.toJSONString(propertisCustom.getHashMap()));
        log.info("list--->{}", JSON.toJSONString(propertisCustom.getList()));
        log.info("email-->{}", JSON.toJSONString(propertisCustom.getEmail()));
        return userDto;
    }

    @RequestMapping(value = "error/test")
    public String test() {
        try {
            int a = 0;
            int c = 100 / a;

        } catch (Exception e) {
            throw new MyException(e.getMessage(), ResponseCode.REQ_FAIL);
        }
        return "";
    }

    @RequestMapping("/valid")
    public UserDto valid(@RequestBody @Validated UserDto userDto) {

        return userDto;
    }


}
