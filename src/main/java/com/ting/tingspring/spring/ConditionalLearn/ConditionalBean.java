package com.ting.tingspring.spring.ConditionalLearn;

import com.ting.tingspring.dto.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

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
}
