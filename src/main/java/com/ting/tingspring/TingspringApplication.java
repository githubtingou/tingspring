package com.ting.tingspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ting.tingspring.interceptor.mapper")
class TingspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TingspringApplication.class, args);
    }

}
