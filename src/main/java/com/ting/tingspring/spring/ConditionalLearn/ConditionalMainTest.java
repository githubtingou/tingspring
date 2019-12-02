package com.ting.tingspring.spring.ConditionalLearn;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 类测试
 *
 * @author LISHUANG
 * @date 2019/12/2
 */
public class ConditionalMainTest implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return true;
    }
}
