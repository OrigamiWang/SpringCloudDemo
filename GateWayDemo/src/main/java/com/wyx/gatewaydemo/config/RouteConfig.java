package com.wyx.gatewaydemo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: SpringCloudDemo
 * @BelongsPackage: com.wyx.gatewaydemo.config
 * @Author: Origami
 * @Date: 2023/5/28 15:27
 */
@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        // 将 127.0.0.1:9527/test/hello 转发到 http://127.0.0.1:8000/test/hello
        return builder.routes()
                .route(p -> p
                        .path("/test/hello")
                        .uri("http://127.0.0.1:8000"))
                .build();
    }
}
