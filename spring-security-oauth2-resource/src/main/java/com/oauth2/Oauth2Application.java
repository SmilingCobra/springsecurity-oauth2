package com.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.oauth2.mapper")
public class Oauth2Application {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class);
    }
}
