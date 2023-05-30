package com.wyx.nacosclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: SpringCloudDemo
 * @BelongsPackage: com.wyx.nacosclient.controller
 * @Author: Origami
 * @Date: 2023/5/29 9:48
 */
@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {

    @Value("${user.name}")
    private String username;

    @Value("${user.pswd}")
    private String pswd;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/username")
    public String getUsername() {
        return username;
    }

    @GetMapping("/pswd")
    public String getPswd() {
        return pswd;
    }
}
