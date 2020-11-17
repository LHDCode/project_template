package com.hd.temp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients // @EnableFeignClients注解来启用Feign的客户端功能
@EnableDiscoveryClient // @EnableDiscoveryClient 注解表示支持服务发现
//@EnableEurekaClient // @EnableEurekaClientt注解表明是一个Eureka客户端
//@EnableCircuitBreaker // @EnableCircuitBreaker开启Hystrix的断路器功能
@EnableSwagger2 // 启动SwaggerUI
public class TempXxServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempXxServiceApplication.class, args);
    }
}
