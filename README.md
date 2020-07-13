# lf-bili-java-sprig-cloud

>2020最新版SpringCloud(H版&alibaba)框架开发
>https://www.bilibili.com/video/BV18E411x7eT?p=149
>0基础：0-4
>初级：5-9
>中级：10-16
>高级：17-21

## 目录：

* 1.微服务架构零基础理论入门-小白入门
* 2.从2.2.X和H版开始说起
* 3.关于cloud各种组件的停更，升级，替换
* 4.微服务架构编码构建
* 5.Eureka服务注册与发现
* 6.zookeeper服务注册与发现
* 7.Consul服务注册与发现
* 8.Ribbon负载均衡与服务调用
* 9.OpenFeign服务接口调用
* 10.Hystrix断路由
* 11.zuul路由网关
* 12.GateWay新一代网关
* 13.spring-cloud config 分布式配置中心
* 14.spring-cloud BUS总线
* 15.spring-cloud Stream 消息驱动
* 16.spring-cloud Sleuth 分布式请求链路跟踪
* 17.spring-cloud Alibaba 入门简介
* 18.spring-cloud Alibaba Nacos 服务注册和配置中心
* 19.spring-cloud Alibaba Sentinel实现熔断与限流
* 20.spring-cloud Alibaba seata处理分布式事务
* 21.spring-cloud Alibaba 大厂面试题第三季

## 1.微服务架构零基础理论入门-小白入门
### 1.课程说明：
1.课程内容：spring-cloud / spring-cloud alibaba  
2.技术要求：java8，maven，github，git，nginx，rabbitmq，springboot2.X  

### 2.0基础微服务架构理论入门：
1.微服务：轻量级，可独立部署  
2.包含技术：-- 看file/2-  

## 2.从2.2.X和H版开始说起
### 3.第二季boot和could技术选型：
1.上篇：boot2.X + cloud H版，官方强烈建议升级到boot2.X   
2.下篇：cloud alibaba  
3.选择合适的boot和cloud版本：lf-bili-java-sprig-cloud\file\3-i-boot和cloud的版本选择.jpg
    
    1.查看大版本对应关系：https://spring.io/projects/spring-cloud
    2.查看小版本对应关系：https://start.spring.io/actuator/info
    3.推荐版本: 选定cloud版本后，可在官网点进查看推荐的boot版本
    
4.选用版本：必须一致
    
    1.java8
    2.maven3.5及以上
    3.mysql5.7及以上
    4.cloud Hoxton.SR1
    5.boot 2.2.2.RELEASE
    6.cloud alibaba 2.1.0.RELEASE

## 3.关于cloud各种组件的停更，升级，替换
### 4.cloud组件停更说明：
1.停更引发的"升级惨案":
    
    1.停更不停用： 
        ·被动修复bug
        ·不接受合并请求
        ·不再发布新版本
        
2.cloud升级：
    
    1.服务注册中心：
        ·Eureka 停止更新，不建议使用
        ·替换：Zookeeper
        ·替换：Consul
        ·替换：Nacos（推荐，阿里巴巴的，已经过市场检验）
        ·替换：子主题
    2.服务调用：
        ·Ribbon 维护中，停更不停用，未来会推出新的
        ·LoadBalancer 刚开始，未来会替换Ribbon，还没有成品出现
    3.服务调用2：
        ·Feign：开发者不维护了，跟Eureka相同，不推荐使用
        ·OpenFeign：spring等不及维护，自己开发的OpenFeign，推荐使用
    4.服务降级，服务熔断
        ·Hystrix：开发者维护问题，跟Eureka相同，不推荐使用
        ·resilience4j：官网推荐使用（国外）
        ·alibaba Sentinel（哨兵）：国内的替换产品，推荐使用
    5.服务网关：
        ·Zuul：内部分裂，准备出zuul2的时候，内部意见不统一，不推荐使用
        ·Gateway：spring自己出的，推荐使用
    6.服务配置：
        ·Config：可以使用
        ·apolo：携程网站推出的，主流，推荐使用
        ·Nacos：阿里巴巴，强烈推荐使用
    7.服务总线：
        ·Bus：可以使用
        ·Nacos：阿里，推荐使用
    8.具体问题查看Cloud官网    
