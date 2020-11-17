package com.hd.temp.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon负载均衡配置
 */
@Configuration
public class RibbonConfig {

    /**
     * 使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
