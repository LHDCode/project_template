package com.hd.temp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient // @EnableDiscoveryClient 注解表示支持服务发现
//@EnableEurekaClient // @EnableEurekaClientt注解表明是一个Eureka客户端
//@EnableZuulProxy // @EnableZuulProxy注解来启用Zuul的API网关功能
public class TempGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempGateWayApplication.class, args);
    }
}
