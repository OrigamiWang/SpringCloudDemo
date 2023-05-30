package com.wyx.nacosconsumer;

import com.wyx.nacosconsumer.config.LoadBalancerConfigForOpenFeign;
import com.wyx.nacosconsumer.config.LoadBalancerConfigForRestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient // 开启服务发现
@EnableFeignClients // 开启远程调用
@EnableHystrix // 开启服务降级
//@LoadBalancerClients(value = {
//        @LoadBalancerClient(name = "nacos-provider", configuration = LoadBalancerConfigForRestTemplate.class)
//}) // RestTemplate自定义负载均衡
@RibbonClient(name = "nacos-provider", configuration = LoadBalancerConfigForOpenFeign.class) // OpenFeign Ribbon自定义负载均衡
public class NacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);
    }

}
