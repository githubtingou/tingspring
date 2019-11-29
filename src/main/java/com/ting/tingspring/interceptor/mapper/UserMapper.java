package com.ting.tingspring.interceptor.mapper;

import com.ting.tingspring.interceptor.dao.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * yongh
 *
 * @author LISHUANG
 * @date 2019/11/28
 */
@Mapper
public interface UserMapper {
    List<User> query(User user);
}
