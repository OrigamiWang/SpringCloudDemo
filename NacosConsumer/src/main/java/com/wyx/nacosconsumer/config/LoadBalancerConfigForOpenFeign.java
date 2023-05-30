package com.wyx.nacosconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: SpringCloudDemo
 * @BelongsPackage: com.wyx.nacosconsumer.config
 * @Author: Origami
 * @Date: 2023/5/29 22:52
 */
@Configuration
public class LoadBalancerConfigForOpenFeign {
    @Bean
    @LoadBalanced
    public IRule myRule() {
        return new RandomRule();
    }
}
