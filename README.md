# BUG 记录

`测试了一晚上，没有解决，config center访问配置文件404的问题，暂时搁置，选用更高级的nacos，替代eureka、config center、bus的功能`

## ConfigServer

- Github裸连不上，挂梯子会报错，因此暂时选用本地配置native
- 经过测试发现，本地配置中心无法实现实时刷新，必须要重启config server

## ConfigClient

- 使用bootstrap.yml，必须引入spring-cloud-starter-bootstrap,否则会报错No spring.config.import set
- 配置文件中的application name和profiles activate必须和config server中的配置文件对应, 对应关系为 application-profile.yml
- 实现@RefreshScope运行时动态刷新配置，需要引入spring-boot-starter-actuator，另外，必须虽然不用重启config-client，但是必须重启config-center

## EurekaServer

- 管理界面不生效：设置defaultZone: http://127.0.0.1:8761/eureka
- 记得加@EnableEurekaServer

## GateWayDemo

- 转发时会保留路径

## NacosServer

- bin目录下(d:/env/nacos) --> `startup.cmd -m standalone`
- 涉及一个nacos的持久化，将数据库Derby改成mysql

## NacosClient

- 需要引入bootstrap
- 配置文件需要写在boostrap.yml
- (Windows不需要)需要开放偏移端口+1000 +1001 参考网址`https://nacos.io/zh-cn/docs/v2/upgrading/2.0.0-compatibility.html`
- 草，我以为nacos可以在java跑server，结果只能用cmd跑

## NacosConsumer

- @FeignClient注解必须要name, fallback, contextId属性
- 引入openfeign报错：FeignService注入失败 ----> 引入spring-cloud-starter-loadbalancer
- ProviderFallbackFactory用于服务降级，当调用远程服务失败时，会调用fallback指定的方法，而不是抛出异常
  `遗留问题 -------------> 服务降级失效，怎么配置都不能用，求解啊啊啊啊`

## Sentinel 控制台(d:/env/sentinel)

- 打开控制台并设置端口号为8070
  ---> `java -Dserver.port=8070 -Dcsp.sentinel.dashboard.server=localhost:8070 -jar sentinel-dashboard-1.8.6.jar`
    - *注意，必须要照着上面的指令启动，不能写个java -jar xxx.jar,这样会导致找不到服务！！！*
      `

## SentinelDemoClient

- 服务降级、熔断成功！
- `https://sentinelguard.io/zh-cn/docs/basic-api-resource-rule.html`
- `但是不知道为什么sentinel dashboard中设置规则没有效果`

## 两种不同的服务间交流方式实现的自定义负载均衡策略

- RestTemplate: 参考 `https://blog.csdn.net/qq_41250182/article/details/119077991`
- OpenFeign: 引入spring-cloud-starter-netflix-ribbon，自定义配置类负载均衡IRule(RandomRule...等等)

## SkyWalking
- `.\elasticsearch.bat`
- `.\oapService.bat`
- `.\webappService.bat`
- `用chrome找不到服务，换成edge就好了，嘛，就是说我虽然在edge找到了服务，但是无法追踪我发起的http请求...`


## 整合架构

- nacos 服务注册中心，配置中心
- feign 服务间交流
- sentinel 服务限流、降级、熔断、网关流控
- spring cloud gateway 网关
- openFeign 自定义负载均衡，舍弃ribbon
  (这里指的是客户端的负载均衡，主要设置在consumer，服务的请求方，决定服务由哪一个provider执行)
  (另外还可以通过nginx服务端负载均衡)
- spring boot admin用于通过actuator监控服务
- 据说可以整合nacos和sentinel实现持久化，但是不知道怎么搞
- skywalking服务追踪

