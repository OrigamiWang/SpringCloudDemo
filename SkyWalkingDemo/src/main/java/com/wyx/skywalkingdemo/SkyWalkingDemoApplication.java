package com.wyx.skywalkingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SkyWalkingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkyWalkingDemoApplication.class, args);
    }

}
