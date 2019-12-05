package com.ting.tingspring.spring.ConditionalLearn;

import com.ting.tingspring.dto.UserDto;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;

/**
 * 测试执行顺序对改Conditional注解的影响
 *
 * @author LISHUANG
 * @date 2019/12/3
 */
@AutoConfigureBefore(ConditionalBean.class)
public class ConditionalBeanBefore {

    /**
     * 如果bean已注册UserDto就注册
     * 此处要注意bean的注册顺序
     *
     * @return
     */
    @Bean(name = "孙三")
    @ConditionalOnBean(ConditionalBean.class)
    public UserDto sunSan() {
        System.out.println("孙三");
        return new UserDto(5L, "孙三", 70, "789@qq.com");
    }


//    /**
//     * @return
//     */
//    @Bean(name = "孙三1")
//    @ConditionalOnClass(ConditionalBean.class)
//    public UserDto sunSan1() {
//        return new UserDto(5L, "孙三1", 70, "789@qq.com");
//    }
}
