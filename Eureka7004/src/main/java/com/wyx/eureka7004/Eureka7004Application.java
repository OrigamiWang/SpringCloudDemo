package com.wyx.eureka7004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka7004Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka7004Application.class, args);
    }

}
