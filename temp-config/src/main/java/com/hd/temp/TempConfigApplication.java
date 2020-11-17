package com.hd.temp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // @EnableDiscoveryClient 注解表示支持服务发现
public class TempConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempConfigApplication.class, args);
    }
}
