package com.ting.tingspring.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * springbeen启动
 *
 * @author LISHUANG
 * @date 2019/10/23
 */
public class SpringBeanRun {

    public static void main(String[] args) {
        // 读取xml配置
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/springBean.xml");
        System.out.println("启动成功");
        // 获取been
        SpringBeanTest bean = context.getBean(SpringBeanTest.class);
        System.out.println(bean.out());

    }
}
