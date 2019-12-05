package com.ting.tingspring.interceptor.controller;

import com.ting.tingspring.interceptor.dao.User;
import com.ting.tingspring.interceptor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LISHUANG
 * @date 2019/11/28
 */
@RestController
@RequestMapping(value = "/test")
public class UserTestController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/query")
    public Object query(@RequestBody User user) {
      return userService.findUserList(user);
    }
}
