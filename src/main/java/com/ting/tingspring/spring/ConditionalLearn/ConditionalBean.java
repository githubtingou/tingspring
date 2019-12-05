package com.ting.tingspring.spring.ConditionalLearn;

import com.ting.tingspring.dto.UserDto;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 测试@Conditional注解
 *
 * @author LISHUANG
 * @date 2019/12/2
 */
@Configuration
@Conditional({ConditionalMainTest.class})
public class ConditionalBean {

    @Bean(name = "李四")
    @Conditional({ConditionalTest.class})
    public UserDto name() {
        return new UserDto(1L, "李四", 20, "123@qq.com");
    }

    @Bean(name = "王五")
    @Conditional({ConditionalTest1.class})
    public UserDto age() {
        return new UserDto(2L, "王五", 40, "456@qq.com");
    }

    @Bean(name = "赵六")
    @Conditional({ConditionalTest1.class, ConditionalTest.class})
    public UserDto email() {
        return new UserDto(3L, "赵六", 50, "789@qq.com");
    }

    @Bean(name = "钱二")
    public UserDto user() {
        return new UserDto(4L, "钱二", 60, "789@qq.com");
    }

    /**
     * 如果bean已注册UserDto就不注册
     * 此处要注意bean的注册顺序
     *
     * @return
     */
    @Bean(name = "赵四")
    @ConditionalOnMissingBean(UserDto.class)
    @Order(1000)
    public UserDto zhaoSi() {
        return new UserDto(7L, "赵四", 70, "789@qq.com");
    }

    @Bean(name = "赵四1")
    @Order(1001)
    @ConditionalOnMissingClass(value = {"com.ting.tingspring.dto.UserDto"})
    public UserDto zhaoSi1() {
        return new UserDto(7L, "赵四1", 70, "789@qq.com");
    }
}
