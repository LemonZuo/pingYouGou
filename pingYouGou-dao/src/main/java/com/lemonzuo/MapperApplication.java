package com.lemonzuo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LemonZuo
 * @create 2019-08-29 22:27
 */
@SpringBootApplication
@MapperScan("com.lemonzuo.mapper")
public class MapperApplication {
    public static void main(String[] args) {
        SpringApplication.run(MapperApplication.class, args);
    }
}
