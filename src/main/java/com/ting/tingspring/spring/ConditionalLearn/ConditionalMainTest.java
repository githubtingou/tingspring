package com.ting.tingspring.spring.ConditionalLearn;

import com.ting.tingspring.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 类测试
 *
 * @author LISHUANG
 * @date 2019/12/2
 */
@Slf4j
public class ConditionalMainTest implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        // 获取当前启用的环境配置
        String[] activeProfiles = environment.getActiveProfiles();
        if (activeProfiles.length > 0) {
            return "dev".equals(activeProfiles[0]);
        }

        metadata.getAnnotationAttributes(UserDto.class.getName());
        return true;
    }
}
