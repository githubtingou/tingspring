package com.ting.tingspring.spring.bean;

/**
 * springbeen测试
 *
 * @author LISHUANG
 * @date 2019/10/23
 */
public class SpringBeanTest implements SpringBeanTestImpl {
    @Override
    public String out() {
        return "Hello World";
    }
}
