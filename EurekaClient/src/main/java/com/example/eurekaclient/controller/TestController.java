package com.example.eurekaclient.controller;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: SpringCloudDemo
 * @BelongsPackage: com.example.eurekaclient.controller
 * @Author: Origami
 * @Date: 2023/5/28 14:08
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/hello")
    public String hell() {
        return "Hello world";
    }

}
