package com.ting.tingspring.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 注解been
 *
 * @author LISHUANG
 * @date 2019/10/23
 */
@ComponentScan
public class BeanTest {

    @Bean
    public String beanTest() {
        return "注解";
    }
}
