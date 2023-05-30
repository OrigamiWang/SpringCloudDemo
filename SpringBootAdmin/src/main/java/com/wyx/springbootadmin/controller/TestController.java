package com.wyx.springbootadmin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: SpringCloudDemo
 * @BelongsPackage: com.wyx.springbootadmin.controller
 * @Author: Origami
 * @Date: 2023/5/30 11:36
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
