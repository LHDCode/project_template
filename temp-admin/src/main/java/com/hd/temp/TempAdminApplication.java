package com.hd.temp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.hd"})
//@EnableEurekaClient // @EnableEurekaClient注解表明是一个Eureka客户端
@EnableDiscoveryClient // @EnableDiscoveryClient 注解表示支持服务发现
@EnableSwagger2 // 启动SwaggerUI
public class TempAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempAdminApplication.class, args);
    }
}
