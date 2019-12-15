package com.ting.tingspring;

import com.alibaba.fastjson.JSON;
import com.ting.tingspring.dto.UserDto;
import com.ting.tingspring.spring.ConditionalLearn.ConditionalBean;
import com.ting.tingspring.spring.ConditionalLearn.ConditionalBeanBefore;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
@Slf4j
public class TingspringApplicationTests {

    /**
     * 测试Conditional注解生效的信息
     */
    @Test
    public void ConditionalMain() {

        // 获取注册到bean的信息
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalBean.class, ConditionalBeanBefore.class);

        log.info("获取bean信息{}",
                JSON.toJSONString(applicationContext.getBeansOfType(UserDto.class)));
//

    }

}
