package com.hd.temp.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: huidong.liu
 * @Time: 2020-10-16 10:11
 * @Description: Swagger API文档相关配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.hd")
                .title("xxService服务")
                .description("xxService服务相关接口文档")
                .contactName("xxService")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
