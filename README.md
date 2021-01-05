# project_template
微服务项目模板结构

```
xx—common     -- 工具类及通用代码模块
xx-codegen    -- MyBatisGenerator生成的数据库操作代码模块
xx-auth       -- 认证中心(Spring Security Oauth2 / Shrio)
xx-gateway    -- 微服务API网关服务(Spring Cloud Gateway / Zuul)
xx-monitor    -- 微服务监控中心(Spring Boot Admin)
xx-registry   -- 微服务注册中心(Eureka / Consul[外部客户端] / Zookeeper / Nacos[外部客户端])
xx-conifg     -- 配置中心(Spring Cloud Config[稍复杂] / Consul[简单])
xx-search     -- 搜索系统服务(Elasticsearch)
xx-admin      -- 后台管理微服务
xx-xxService  -- xx微服务
```
