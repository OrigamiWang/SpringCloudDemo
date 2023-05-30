package com.wyx.nacosconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @BelongsProject: SpringCloudDemo
 * @BelongsPackage: com.wyx.nacosconsumer.controller
 * @Author: Origami
 * @Date: 2023/5/29 12:48
 */
@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @Value("${config.name}")
    private String name;

    @Value("${config.port}")
    private String port;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/config")
    public String getConfig() {
        return "The name of service is: " + name + ".\n" + "The listening port is: " + port + "\n";
    }

    // 写死url
    // 通过RestTemplate与服务的生产者通信
    @GetMapping("/consume")
    public String consume() {
//        在restTemplate开启负载均衡后，需要将127.0.0.1:8021改成服务名字
//        https://blog.csdn.net/qq_41250182/article/details/119077991
//        return restTemplate.getForObject("http://127.0.0.1:8021/test/config", String.class);
        return restTemplate.getForObject("http://nacos-provider/test/config", String.class);

    }



}
