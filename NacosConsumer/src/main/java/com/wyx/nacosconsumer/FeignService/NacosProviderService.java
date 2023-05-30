package com.wyx.nacosconsumer.FeignService;

import com.wyx.nacosconsumer.config.ProviderFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @BelongsProject: SpringCloudDemo
 * @BelongsPackage: com.wyx.nacosconsumer.Service
 * @Author: Origami
 * @Date: 2023/5/29 14:34
 */
@FeignClient(name = "nacos-provider",
        contextId = "nacosProviderService",
        fallback = ProviderFallbackFactory.class) // 失效的服务降级
public interface NacosProviderService {
    @GetMapping("/test/config")
    String getConfig();
}

