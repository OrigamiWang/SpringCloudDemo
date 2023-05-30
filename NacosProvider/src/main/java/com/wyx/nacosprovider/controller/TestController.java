package com.wyx.nacosprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: SpringCloudDemo
 * @BelongsPackage: com.wyx.nacosprovider.controller
 * @Author: Origami
 * @Date: 2023/5/29 12:44
 */
@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {



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


}
