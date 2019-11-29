package com.ting.tingspring.interceptor.service;

import com.ting.tingspring.interceptor.dao.User;
import com.ting.tingspring.interceptor.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LISHUANG
 * @date 2019/11/28
 */
@Service("userServicev2")
public class UserService {

    @Autowired
    UserMapper userMapper;


    public Object findUserList(User user) {
        List<User> query = userMapper.query(user);
        return query;
    }

}
