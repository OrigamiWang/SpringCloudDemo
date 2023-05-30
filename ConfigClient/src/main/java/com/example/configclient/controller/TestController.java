package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: SpringCloudDemo
 * @BelongsPackage: com.example.configclient.controller
 * @Author: Origami
 * @Date: 2023/5/28 10:24
 */
@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {

    @Value("${config.info}")
    private String info;


    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/info")
    public String getInfo() {
        return info;
    }

}
