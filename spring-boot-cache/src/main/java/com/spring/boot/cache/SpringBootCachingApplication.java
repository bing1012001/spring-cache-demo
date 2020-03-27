package com.spring.boot.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.spring.boot.cache.mapper")
@EnableCaching
public class SpringBootCachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCachingApplication.class, args);
    }
}
