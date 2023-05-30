package com.wyx.nacosconsumer.config;

import com.wyx.nacosconsumer.FeignService.NacosProviderService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: SpringCloudDemo
 * @BelongsPackage: com.wyx.nacosconsumer.config
 * @Author: Origami
 * @Date: 2023/5/29 14:45
 */
// 服务降级
@Component
public class ProviderFallbackFactory implements FallbackFactory<NacosProviderService> {

    @Override
    public NacosProviderService create(Throwable cause) {
        throw new RuntimeException("服务维护中，请稍后再试！");
    }


}
