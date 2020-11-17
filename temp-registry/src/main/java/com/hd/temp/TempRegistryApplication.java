package com.hd.temp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // @EnableEurekaServer注解来启用Euerka注册中心功能
@SpringBootApplication
public class TempRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempRegistryApplication.class, args);
    }
}
