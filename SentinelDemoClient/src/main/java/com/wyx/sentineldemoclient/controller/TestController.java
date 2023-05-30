package com.wyx.sentineldemoclient.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.degrade.circuitbreaker.CircuitBreakerStrategy;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: SpringCloudDemo
 * @BelongsPackage: com.wyx.sentineldemoclient.controller
 * @Author: Origami
 * @Date: 2023/5/29 19:46
 */
@RestController
@RequestMapping("/test")
public class TestController {

    // 构造函数执行之后执行，init执行之前执行，只会执行一次
    // 设置的规则为：每秒仅允许访问一次，即QPS=1
    @PostConstruct
    public void initRules() {
        String resourceName = "sayHello";
        initFlowQpsRule(resourceName);
        initDegradeRule(resourceName);
    }

    /**
     * 初始化qps流量控制规则
     */
    private void initFlowQpsRule(String resourceName) {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        //定义资源，表示sentinel会对这个资源生效
        rule.setResource(resourceName);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // max qps = 1
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    /**
     * 初始化熔断规则
     */
    private void initDegradeRule(String resourceName) {
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule(resourceName);
        rule.setGrade(CircuitBreakerStrategy.ERROR_RATIO.getType())
                .setCount(0.7)
                .setMinRequestAmount(100)
                .setStatIntervalMs(30000)
                .setTimeWindow(3);
        rules.add(rule);
        DegradeRuleManager.loadRules(rules);
    }


    @SentinelResource(value = "sayHello", fallback = "sayDefaultHello", blockHandler = "blockWarn")
    @RequestMapping("/hello")
    public String hello() {
//        用于测试 服务降级
//        int b = 1 / 0;
        return String.format("Hello %s", "Origami");
    }

    // 服务降级
    public String sayDefaultHello() {
        return "服务正在维护，请稍后再试！";
    }

    // 服务熔断、限流
    public String blockWarn(BlockException e) {
        if (e instanceof FlowException) {
            return "访问太频繁，稍后重试！";
        }

        if (e instanceof DegradeException) {
            return "服务已自动断开，稍后重试！";
        }

        return "稍后重试";
    }

}
