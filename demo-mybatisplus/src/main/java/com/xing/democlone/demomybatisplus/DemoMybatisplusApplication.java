package com.xing.democlone.demomybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xing.demomybatisplus.dao")
public class DemoMybatisplusApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoMybatisplusApplication.class, args);
    }

}
