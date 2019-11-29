package com.ting.tingspring.spring;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author LISHUANG
 * @date 2019/11/16
 */
// 注解使用的地址
@Target(value = {ElementType.METHOD})
// 运行的生命周期
@Retention(value = RetentionPolicy.RUNTIME)
// 是否被生成doc
@Documented
public @interface AnnotationTest {
    @AliasFor("name")
    String value() default "";

    @AliasFor("value")
    String name() default "";

    int age() default 20;


}
