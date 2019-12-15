package com.ting.tingspring.spring;

/**
 * 自定义注解方法
 *
 * @author LISHUANG
 * @date 2019/11/16
 */
public class AnnotationTestMethod {


    @AnnotationTest(value = "李四", age = 10)
    public void annotationRun() {
        System.out.println("自定义注解");
    }
}
