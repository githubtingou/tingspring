package com.ting.tingspring.spring.ConditionalLearn;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * condition 注册使用类
 *
 * @author LISHUANG
 * @date 2019/12/2
 */
public class ConditionalTest1 implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // true 注册bean，false 不注册
        return true;
    }
}
