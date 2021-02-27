package com.lemonzuo.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author LemonZuo
 * @create 2019-08-28 16:44
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.lemonzuo")
public class ManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class, args);
    }
}
