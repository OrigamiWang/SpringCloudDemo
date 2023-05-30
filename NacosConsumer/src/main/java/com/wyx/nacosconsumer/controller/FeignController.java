package com.wyx.nacosconsumer.controller;

import com.wyx.nacosconsumer.FeignService.NacosProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: SpringCloudDemo
 * @BelongsPackage: com.wyx.nacosconsumer.controller
 * @Author: Origami
 * @Date: 2023/5/29 14:31
 */
@RestController
@RequestMapping("/consume")
public class FeignController {

    @Autowired
    private NacosProviderService providerService;

    @GetMapping("/config")
    public String getConfig() {
        return providerService.getConfig();
    }


}
