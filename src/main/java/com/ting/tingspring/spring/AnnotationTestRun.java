package com.ting.tingspring.spring;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * 自定义注解启动类
 *
 * @author LISHUANG
 * @date 2019/11/16
 */
@Slf4j
public class AnnotationTestRun {

    public static void main(String[] args) {

        try {
            Class forName = Class.forName("com.ting.tingspring.spring.AnnotationTestMethod");
            Method annotationRuns = forName.getMethod("annotationRun");
            if (annotationRuns.isAnnotationPresent(AnnotationTest.class)) {
                log.info("获取该方法上的注解");
                AnnotationTest annotation = annotationRuns.getAnnotation(AnnotationTest.class);
                log.info("name:{},age:{},value:{}", annotation.name(), annotation.age(), annotation.value());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
