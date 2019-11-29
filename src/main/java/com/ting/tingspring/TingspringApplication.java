package com.ting.tingspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.ting.tingspring"})
public class TingspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TingspringApplication.class, args);
    }

}
