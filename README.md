# lf-bili-java-sprig-cloud

>2020最新版SpringCloud(H版&alibaba)框架开发 2月
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
### 1.1 （1）课程说明：
1.课程内容：spring-cloud / spring-cloud alibaba  
2.技术要求：java8，maven，github，git，nginx，rabbitmq，springboot2.X  

### 1.2 （2）基础微服务架构理论入门：
1.微服务：轻量级，可独立部署  
2.包含技术：-- 看file/2-  

## 2.从2.2.X和H版开始说起
### 2.1 （3）第二季boot和could技术选型：
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
### 3.1 (4) cloud组件停更说明：
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
## 4.微服务架构编码构建
### 4.1 （5）父工程Project空间新建：
> 约定 > 配置 > 编码  
> 新建工程步骤：

    ·new Project
    ·聚合总父工程名称
    ·maven版本
    ·工程名字
    ·字符编码: 5-i-设置字符编码.jpg
    ·注解生效激活：5-i-配置注解生效.jpg
    ·java编译版本选8：5-i-设置编译版本.jpg
    ·File Type过滤：5-i-设置FileType过滤.jpg

### 4.2 （6）父工程pom文件：
* 添加pom依赖管理
### 4.3 （7）dependencyManagement 和dependencies的区别：
### 4.4  (8)支付模块构建-1：
1.建module  
2.改pom  
3.写yml  
4.主启动  
5.业务类
### 4.5  (9)支付模块构建-2：
    
### 4.7  (10) 支付模块构建-3：
    
     1.请求：http://localhost:8001/payment/get/31
         响应：{"code":200,"message":"查询成功,serverPort:  ","data":{"id":31,"serial":"尚硅谷"}}
     2.请求：http://localhost:8001/payment/create 【post】
       参数：
         {
             "serial":"hhhhhh"
         }
       响应：
         {
             "code": 200,
             "message": "插入数据库成功,serverPort: ",
             "data": 1
         }
         
### 4.8  (11)热部署DevTools
    
    1.子工程加依赖：spring-boot-devtools
    2.父工程加插件：spring-boot-maven-plugin
    
### 4.9  (12) 消费者订单模块1
    
    两个服务交互的方式：
        1.HttpClient
        2.RestTemplate：Spring自己提供的远程调用的方法
            ·提供了多种便捷访问远程Http服务的方法
            ·是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集
            ·官网：https://docs.spring.io/spring-framework/docs/5.2.2.RELEASE/javadoc-api/org/springframework/web/client/RestTemplate.html
            ·使用：
                1.添加配置config
                2.(url,requestMap,ResponseBean.class) 分别代表rest请求地址，参数，http响应转换被转换成的对象类型
        
### 4.10  (13) 消费者订单模块2

    http://localhost/consumer/payment/get/31
    http://localhost/consumer/payment/create?serial=111

### 4.11  (14) 工程重构
    
    0基础结束，0-4章
    
## 5.Eureka服务注册与发现
### 5.1  （15） Eureka基础知识
    
    1.服务治理：
        SpringCloud封装了Netflix公司开发的EureKa模块来实现服务治理
        传统的rpc调用框架中，管理每个服务与服务之间的依赖关系比较复杂，管理复杂所以需要服务治理，实现服务调用，负载均衡，容错等，实现服务注册与发现
    2.服务注册与发现：注意集群配置，防止单点故障
        Eureka采用了CS的架构设计，EurekaServer作为服务注册功能的服务器，他是服务注册中心。系统中其他的微服务，使用Eureka的客户端连接到EUreka Server服务端并维持
        心跳连接。这样系统人员就可以通过Eureka Server 来监控系统中各个微服务是否正常运行
        
        服务提供者：将当前服务器的信息注册到注册中心（服务通讯地址，别名等）
        服务消费者：根据别名获取到实际的通讯地址，通过本地rpc进行远程调用
        RPC核心设计思想：注册中心管理服务和服务之间的依赖关系，任何rpc都有注册中心，存放服务地址相关信息（即接口地址）
    3.组件：
        ·Eureka Server：服务注册
            各个微服务节点通过配置启动后，会在Server进行注册,服务节点信息可在界面直接查看
        ·Eureka Client：访问
            java客户端，简化与server的交互，其具备一个内置的，使用轮询（round-robin）负载算法的负载均衡器。在应用启动后，将会向Eureka Server发送心跳，默认周期为30秒
            如果Eureka在多个心跳周期内没有接收到某个节点的心跳，Eureka将会从服务注册表把这个服务节点移除，默认90秒
            
### 5.2  （16） Eureka Server服务端安装
    
    cloud-eureka-server7001     服务注册中心：http://localhost:7001/
    
### 5.3  （17） 支付微服务8001 入驻进eurekaServer
### 5.4  （18） 订单微服务80   入驻进eurekaServer
### 5.5  （19） Eureka集群原理说明

    微服务远程调用核心：高可用，防止单点故障
    处理：搭建Eureka注册中心集群，实现负载均衡+故障容错
    集群原理：互相注册，相互守望
    
### 5.6  （20） Eureka集群环境构建

    C:\Windows\System32\drivers\etc\host 文件添加映射关系
        127.0.0.1 eureka7001.com
        127.0.0.1 eureka7002.com
        127.0.0.1 eureka7003.com
    相互注册：7001注册7002 ，7002注册7001
    
### 5.7  （21） 订单支付两微服务注册进Eureka集群

    defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka

### 5.8  （22） 支付微服务集群配置
    
    加注解@LoadBalanced
    改访问地址：http://CLOUD-PAYMENT-SERVICE
    
### 5.9  （23） actuator微服务信息完善

    主机名称、服务名称的修改：eureka界面上出现主机名，去掉，例如：
        CLOUD-ORDER-SERVICE	n/a (1)	(1)	UP (1) - DESKTOP-PVHJEH1:cloud-order-service:80
        需要去掉DESKTOP-PVHJEH1
        修改yml文件：
            添加：instance:
                     instance-id: payment8002
    IP显示修改：
        修改yml：
            添加：
                     prefer-ip-address: true
    
### 5.10 （24） 服务发现Discovery
### 5.11 （25） eureka自我保护理论知识
### 5.12 （26） 怎么禁止自我保护
### 5.13 （27） eureka停更说明

## 6. zookeeper服务注册与发现
### 5.9  （23） actuator微服务信息完善
### 5.9  （23） actuator微服务信息完善


### FInal.模块介绍
cloud-api-commons           公共模块
cloud-provider-payment8001  支付模块
cloud-consumer-order80      消费者订单模块
cloud-eureka-server7001     服务注册中心：http://localhost:7001/

