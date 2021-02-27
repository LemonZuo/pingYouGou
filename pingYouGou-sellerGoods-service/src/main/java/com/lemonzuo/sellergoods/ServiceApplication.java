package com.lemonzuo.sellergoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author LemonZuo
 * @create 2019-08-27 22:38
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.lemonzuo")
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}
