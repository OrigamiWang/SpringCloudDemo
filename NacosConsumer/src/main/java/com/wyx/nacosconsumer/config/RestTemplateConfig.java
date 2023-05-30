package com.wyx.nacosconsumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @BelongsProject: SpringCloudDemo
 * @BelongsPackage: com.wyx.nacosprovider.config
 * @Author: Origami
 * @Date: 2023/5/29 13:06
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced   // 自定义负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
