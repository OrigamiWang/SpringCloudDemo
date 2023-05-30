package com.wyx.nacosconsumer.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.loadbalancer.NacosLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @BelongsProject: SpringCloudDemo
 * @BelongsPackage: com.wyx.nacosconsumer.config
 * @Author: Origami
 * @Date: 2023/5/29 22:29
 */
public class LoadBalancerConfigForRestTemplate {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Bean
    public ReactorServiceInstanceLoadBalancer reactorServiceInstanceLoadBalancer
            (Environment environment, LoadBalancerClientFactory loadBalancerClientFactory) {

        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        //返回随机轮询负载均衡方式
        //return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider
        // (name, ServiceInstanceListSupplier.class), name)

        //返回加权随机轮询负载均衡方式
        //return new RoundRobinLoadBalancer(loadBalancerClientFactory.getLazyProvider
        // (name, ServiceInstanceListSupplier.class), name);

        //nacos服务注册中心权重的负载均衡策略
        return new NacosLoadBalancer(loadBalancerClientFactory.getLazyProvider
                (name, ServiceInstanceListSupplier.class), name, nacosDiscoveryProperties);

    }

}
