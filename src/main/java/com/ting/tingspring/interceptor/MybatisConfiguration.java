package com.ting.tingspring.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册mybatis拦截器
 *
 * @author LISHUANG
 * @date 2019/12/2
 */
@Configuration
public class MybatisConfiguration {

    @Bean
    public TestInterceptor testInterceptor() {
        return new TestInterceptor();

    }
}
