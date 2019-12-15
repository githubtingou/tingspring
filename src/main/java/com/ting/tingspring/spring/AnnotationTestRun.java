package com.ting.tingspring.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;

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
            AnnotationTest annotation1 = AnnotationUtils.getAnnotation(annotationRuns, AnnotationTest.class);

            log.info("获取该方法上的注解");
            AnnotationTest annotation = annotationRuns.getAnnotation(AnnotationTest.class);
            log.info("AnnotationUtils---->name:{},age:{},value:{}", annotation1.name(), annotation1.age(), annotation1.value());
            log.info("annotation1---->name:{},age:{},value:{}", annotation.name(), annotation.age(), annotation.value());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
