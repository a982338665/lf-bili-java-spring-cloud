# lf-bili-java-sprig-cloud

>2020最新版SpringCloud(H版&alibaba)框架开发 2月
>https://www.bilibili.com/video/BV18E411x7eT?p=149
>0基础：0-4
>初级：5-9
>中级：10-16
>高级：17-21
>host文件修改：
    C:\Windows\System32\drivers\etc\host
>Hystrix：https://github.com/Netflix/Hystrix/wiki
    
>
## 目录：

- [1.微服务架构零基础理论入门-小白入门](#1微服务架构零基础理论入门-小白入门)
- [2.从2.2.X和H版开始说起](#2从22X和H版开始说起)
- [3.关于cloud各种组件的停更，升级，替换](#3关于cloud各种组件的停更升级替换)
- [4.微服务架构编码构建](#4微服务架构编码构建)
- [5.Eureka服务注册与发现](#5Eureka服务注册与发现)
- [6.zookeeper服务注册与发现](6zookeeper服务注册与发现)
- [7.Consul服务注册与发现](#7Consul服务注册与发现)
- [8.Ribbon负载均衡与服务调用](#8Ribbon负载均衡与服务调用)
- [9.OpenFeign服务接口调用](#9OpenFeign服务接口调用)
- [10.Hystrix断路由](#10Hystrix断路由)
- [11.zuul路由网关](#11zuul路由网关)
- [12.GateWay新一代网关](#12GateWay新一代网关)
- [13.spring-cloud config 分布式配置中心](#13spring-cloud-config-分布式配置中心)
- [14.spring-cloud BUS总线](#14spring-cloud-BUS总线)
- [15.spring-cloud Stream 消息驱动](#15spring-cloud-Stream-消息驱动)
- [16.spring-cloud Sleuth 分布式请求链路跟踪](#16spring-cloud-Sleuth-分布式请求链路跟踪)
- [17.spring-cloud Alibaba 入门简介](#17spring-cloud-Alibaba-入门简介)
- [18.spring-cloud Alibaba Nacos 服务注册和配置中心](#18spring-cloud-Alibaba-Nacos-服务注册和配置中心)
- [19.spring-cloud Alibaba Sentinel实现熔断与限流](#19spring-cloud-Alibaba-Sentinel实现熔断与限流)
- [20.spring-cloud Alibaba seata处理分布式事务](#20spring-cloud-Alibaba-seata处理分布式事务)
- [21.spring-cloud Alibaba 大厂面试题第三季](#21spring-cloud-Alibaba-大厂面试题第三季)

## 1.微服务架构零基础理论入门-小白入门
>二级标题为目录对应的章节 例如 ## 1.  
>三级标题对应视频课程的目录小节 1.1 为章小节排序，（1）对应视频小节，例如：### 1.1 （1）
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
        127.0.0.1 localhost
        127.0.0.1 localhost
        127.0.0.1 eureka7003.com
    相互注册：7001注册7002 ，7002注册7001
    
### 5.7  （21） 订单支付两微服务注册进Eureka集群

    defaultZone: http://localhost:7001/eureka,http://localhost:7002/eureka

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

    1.功能：
        对于注册进eureka里面的微服务，可以通过服务发现来获得该服务信息
    2.修改：8001，8002的controller
    3.启动类添加注解
    4.访问：
        http://localhost:8001/payment/discovery
        {"services":["cloud-payment-service","cloud-order-service"],"order":0}
    
### 5.11 （25） eureka自我保护理论知识
    
    1.官方概述：保护模式主要用于一组客户端和eureka server之间存在网络分区场景下的保护，一旦进入保护模式，eureka将会尝试保护其服务注册表中的信息，
        不在删除服务注册表中的数据，也就是不会注销任何微服务
        若在eureka首页看到提示：
            EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
            则说明其进入了保护模式
    2.解释：某时刻一个微服务不能用了，Eureka也不会立刻清理，依旧对该服务的信息进行保存
            属于CAP里的AP分支
            理由：可能由于网络等原因，导致暂时不能用，等恢复后可继续使用，所以不会立刻清理
    3.Eureka的自我保护机制：
        为防止EurekaClient可以正常运行，但是由于EurekaServer网络不通的情况下，Server不会立刻将client剔除掉
    4.什么是自我保护模式？
        默认情况下，如果EurekaServer在一定时间内没有接收到某个微服务实例的心跳，Eureka将会注销该实例（默认90秒）
        但是当网络分区故障发生，延迟，卡顿，拥挤时，微服务与EUrekaServer无法正常通信，以上行为可能变得非常危险了，因为微服务本身是健康的，此时本不该注销这个微服务。Eureka通过自我保护模式
        来解决此问题。即当Eureka节点在短时间丢失过多客户端时，可能发生了网络分区故障，那么这个节点就会进入自我保护模式
    5.触发点：
        client定时向server发送心跳包
        server在一定时间内（90秒）没有收到client发送的心跳包，便会直接从服务注册列表中提出该服务，但是若在这90秒中，有大量的服务实例心跳丢失，这时候eurekaserver会开启自我保护机制，
        不会剔除该服务，所以自我保护机制是为了解决：网络延时问题导致的暂时访问不通而被错误的剔除出注册中心的问题。宁可保留错误的信息，也不误删
    6.总结：自我保护是应对网络异常的安全保护措施，可以让集群更加健壮，稳定
        
### 5.12 （26） 怎么禁止自我保护

    检测不在线，直接删除。了解知识，不推荐配置
    1.修改注册中心7001：
    2.修改生产者客户端8001：

### 5.13 （27） eureka停更说明

    eureka2.0不在维护，停止更新，若还在使用，后果自负
    zookeeper替代eureka

## 6. zookeeper服务注册与发现
### 6.1  （28） 支付服务注册进zookeeper
    
    1.docker启动一个zookeeper：暂时不关注集群
        $ docker pull zookeeper:3.4.9
        $ docker run --name some-zookeeper --restart always -d zookeeper:3.4.9  总是重启，测试不建议
        $ docker run --name some-zookeeper -d zookeeper:3.4.9   启动方式，不暴露外网
        $ docker run --name some-zookeeper -p 2181:2181 -d zookeeper:3.4.9   启动方式，端口2181暴露外网，测试时使用命令
        启动后会EXPOSE端口：2181， 2888， 3888。并设置为始终重启。
        $ docker exec -it 容器id zkCli.sh  启动zk客户端
        docker exec -it 容器 bash
        [zk: localhost:2181(CONNECTED) 4] ls /
        [zk: localhost:2181(CONNECTED) 4] ls /services 进入容器内部查看注册信息
        [zk: localhost:2181(CONNECTED) 4] ls /services/cloud-provider-payment
        [6c24d3fe-6b34-4096-8d97-0ef664843a51]
        [zk: localhost:2181(CONNECTED) 5] ls /services/cloud-provider-payment/6c24d3fe-6b34-4096-8d97-0ef664843a51
        []
        [zk: localhost:2181(CONNECTED) 6] get /services/cloud-provider-payment/6c24d3fe-6b34-4096-8d97-0ef664843a51 查看详细注册信息
        {"name":"cloud-provider-payment","id":"6c24d3fe-6b34-4096-8d97-0ef664843a51","address":"DESKTOP-PVHJEH1","port":8004,"sslPort":null,"payload":{"@class":"org.springframework.cloud.zookeeper.discovery.ZookeeperInstance","id":"application-1","name":"cloud-provider-payment","metadata":{}},"registrationTimeUTC":1595411152787,"serviceType":"DYNAMIC","uriSpec":{"parts":[{"value":"scheme","variable":true},{"value":"://","variable":false},{"value":"address","variable":true},{"value":":","variable":false},{"value":"port","variable":true}]}}
        cZxid = 0x8
        ctime = Wed Jul 22 09:45:49 GMT 2020
        mZxid = 0x8
        mtime = Wed Jul 22 09:45:49 GMT 2020
        pZxid = 0x8
        cversion = 0
        dataVersion = 0
        aclVersion = 0
        ephemeralOwner = 0x17375d0d34b0001
        dataLength = 536
        numChildren = 0
        [zk: localhost:2181(CONNECTED) 7] 
    2.访问：http://localhost:8004/payment/zk
        springcloud with zookeeper: 8004 a461f050-628a-48cb-92cc-3d494b0fc581
    3.zk可视化工具：zkui     原文链接：https://blog.csdn.net/hacker_Lees/article/details/104989284
        0.假设我们的程序是分布式部署在多台机器上，如果我们要改变程序的配置文件，需要逐台机器去修改，非常麻烦，现在把这些配置全部放到zookeeper上去，保存在 zookeeper 的某个目录节点中，
          然后所有相关应用程序对这个目录节点进行监听，一旦配置信息发生变化，每个应用程序就会收到 zookeeper 的通知，然后从 zookeeper 获取新的配置信息应用到系统中。
        1.git clone https://github.com/DeemOpen/zkui.git
        2.源码编译需要安装 maven
           # wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
           #cd zkui/
           //若服务器中已安装maven，忽略此命令
           #yum install -y maven
           //打jar包
           #mvn clean install
        3.修改配置文件默认值
           #vim config.cfg
                serverPort=9090     #指定端口
                zkServer=172.168.0.110:2181
                sessionTimeout=300000
        4.启动程序至后台
            2.0-SNAPSHOT 会随软件的更新版本不同而不同，执行时请查看target 目录中真正生成的版本
            nohup java -jar target/zkui-2.0-SNAPSHOT-jar-with-dependencies.jar & 
        5.用浏览器访问：
            http://172.168.0.110:9090/
    
### 6.2  （29） 临时还是持久节点

    1.服务节点是临时性的，当应用服务停止或者宕机后，zookeeper心跳检测后如没有反应，则会移除该应用，当应用重新启动后，则会新生成一个，由其id不相同而判断
    （根据 ls /services/cloud-provider-payment 获取到的id变化可知）
    
### 6.3  （30） 订单服务注册进zookeeper
## 7.Consul服务注册与发现
### 7.1  （31） Consul简介

    1.go语言写的，提供了微服务系统中的服务治理，配置中心，控制总线等功能，每个功能都可以独立使用，也可以一起使用构建全方位的服务网格，提供了完整的服务网格解决方案
    2.具有很多优点：
        基于raft协议，比较简洁，支持健康检查，同时支持http和DNS协议，支持跨数据中心的WAN集群，提供图形界面，跨平台，支持linux，mac，windows    
        kv存储：key，value存储
        多数据中心
        可视化界面
    3.官网：https://www.consul.io 下载地址也在这
    4.文档：https://www.springcloud.cc/
        https://www.springcloud.cc/spring-cloud-consul.html
        
### 7.2  （32） 安装并运行Consul

    下载地址：https://www.consul.io/downloads
    下载解压：consul.exe
    当前目录执行查看版本：consul --version 
    启动：consul agent --dev
        D:\install-soft\chrome\consul_1.8.0_windows_amd64>D:\install-soft\chrome\consul_1.8.0_windows_amd64>consul agent --dev
    访问：localhost:8500
    
### 7.3  （33） 服务提供者注册进Consul

    先启动consul,后启动8006
    访问 localhost:8500
    
### 7.4  （34） 服务消费者注册进Consul

    先启动consul,后启动8006,在启动80
    访问 localhost:8500

### 7.5  （35） 三个注册中心的异同点
|组件名|语言|CAP|服务健康检查|对外暴露接口|springcloud集成
|----|----|----|----|----|----|
Eureka  |   java    |AP|可配支持|http|已集成
Consul  |   go      |CP|支持|HTTP/DNS|已集成
Zookeeper|  java    |CP|支持|客户端|已集成
CAP ：

    C：Consistency 强一致性
    A：Avaliability 可用性
    p：Partition tolerance  分布式的分区容错性
        一个分布式系统里面，节点组成的网络本来应该是连通的。然而可能因为一些故障，使得有些节点之间不连通了，整个网络就分成了几块区域。数据就散布在了这些不连通的区域中。这就叫分区。
        当你一个数据项只在一个节点中保存，那么分区出现后，和这个节点不连通的部分就访问不到这个数据了。这时分区就是无法容忍的。
        提高分区容忍性的办法就是一个数据项复制到多个节点上，那么出现分区之后，这一数据项就可能分布到各个区里。容忍性就提高了。
        然而，要把数据复制到多个节点，就会带来一致性的问题，就是多个节点上面的数据可能是不一致的。要保证一致，每次写操作就都要等待全部节点写成功，而这等待又会带来可用性的问题。
        总的来说就是，数据存在的节点越多，分区容忍性越高，但要复制更新的数据就越多，一致性就越难保证。为了保证一致性，更新所有节点数据所需要的时间就越长，可用性就会降低。
    由于项目本身就是分布式，所以要么AP，要么CP
    CAP理论关注的粒度是数据，而不是整体系统设计的
    CAP经典图：
        ·最多只能同时较好的满足两个
        ·CAP的理论核心是：
            一个分布式系统不可能同时很好的满足一致性，可用性，和分区容错这三个需求
            因此，根据CAP原则，将nosql数据库分成了满足CA，CP，AP原则的三大类
        ·CA：单点集群满足一致性，可用性的系统，通常在可拓展性上不太行
        ·CP：满足一致性，分区容忍性 的系统，通常性能不是特别高
        ·AP：满足可用性，分区容忍性 的系统，通常对一致性要求不高
    一般要先保证可用性，在保证一致性
    A主要保证高可用
    C主要保证数据一致
    
## 8.Ribbon负载均衡与服务调用
### 8.1  （36） ribbon入门介绍
    
    1.Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端，负载均衡的工具
    2.Ribbon是Netflix发布的开源项目，主要功能是提供客户端的软件负载均衡算法和服务调用。Ribbon客户端组件提供一系列完善的配置项，如连接超时，重试等，简单说就是在配置文件中
        列出Load Balancer（检查LB）后面的所有机器，Ribbon会自动的帮助你基于某种规则（如简单轮询，随机连接等）去连接这些机器。我们很容易使用Ribbon实现自定义的负载均衡算法
    3.官网：https://github.com/Netflix/ribbon/wiki/Getting-Started
    4.Ribbon目前也进入了维护模式：比较好，现在还在用，没有替代品，未来可能使用 Spring Cloud Starter Loadbalancer 2.2.1-RELEASE 替换掉 
    5.用途：
        1.负载均衡LB：
            解释：将用户的请求分摊到多个服务器上，从而达到系统的高可用
            常见的负载均衡：软件nginx，LVS ，硬件F5
            分类：
                ·集中式LB，即在消费方和提供方之间使用独立的LB设施（可以是硬件F5，可以使软件nginx），由该设施负责把访问请求听过某种策略转发至服务的提供方
                ·进程内LB, 将LB逻辑集成到消费方，消费方从服务中心获取那些地址可用，然后再从这些地址中选出合适的服务器
        2.Ribbon本地负载均衡客户端 VS Nginx服务端负载均衡区别
            集中式LB：nginx是服务器负载均衡，客户端所有的请求都会交给nginx，然后由nginx实现转发请求，即负载均衡是由服务器端实现的
            进程内的LB：Ribbon本地负载均衡，在调用微服务接口时，会在注册中心上获取注册信息服务列表之后再缓存到JVM本地，从而在本地实现RPC远程服务调用技术
                它只是一个类库，集成于消费方进程，消费方通过它来获取到服务提供方的地址
        3.负载2均衡+restTemplate调用
            之前写过:最新版的spring-cloud-starter-netflix-eureka-client包含ribbon
            依次启动 Eurekaa的 7001,7002,8001,8002,80 后访问：http://localhost/consumer/payment/get/31 即可看到
            返回值：交替出现以下两种结果
            {"code":200,"message":"查询成功,serverPort: 8001","data":{"id":31,"serial":"尚硅谷"}}
            {"code":200,"message":"查询成功,serverPort: 8002","data":{"id":31,"serial":"尚硅谷"}}
    
### 8.2  （37） ribbon的负载均衡和rest调用

    1.ribbon其实就是一个软负载均衡的客户端组件，他可以和其他所需请求的客户端结合使用，和eureka结合只是其中一种实例
    2.工作步骤：
        1.先选择EurekaServer，优先选择同一区域内负载较少的Server
        2.再根据用户指定的策略，再从server取到的服务注册列表中选择一个地址。其中ribbon提供了多种策略，比如轮询，随机和根据响应时间加权
    3.restTemplate的使用:
        1.官网：https://docs.spring.io/spring-framework/docs/5.2.2.RELEASE/javadoc-api/org/springframework/web/client/RestTemplate.html
        2.getForObject/getForEntity
        3.postForObject/postForEntity
        4.get
        5.post
     
### 8.3  （38） ribbon自带的负载规则
    
    1.ribbon核心组件IRule：根据特点算法 从服务列表中选取一个要访问的服务
    2.ribbon自带的负载均衡算法：7种
        ·import com.netflix.loadbalancer.RoundRobinRule; 【轮询】
        ·import com.netflix.loadbalancer.RandomRule;    【随机】
        ·import com.netflix.loadbalancer.RetryRule;     先按照【轮询】的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
        ·import com.netflix.loadbalancer.WeightedResponseTimeRule;对【轮询】的拓展，响应速度越快的实例，选择权重越大，越容易被选择
        ·import com.netflix.loadbalancer.BestAvailableRule; 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
        ·import com.netflix.loadbalancer.AvailabilityFilteringRule; 先过滤掉故障实例，再选择并发较小的实例
        ·import com.netflix.loadbalancer.ZoneAvoidanceRule;默认规则，符合判断server所在区域的性能和serve的可用性选择服务器
    2.如何替换默认轮询：
    
### 8.4  （39） ribbon负载规则替换

    1.替换负载规则：
        此自定义配置类不能放在 @ComponentScan所扫描的当前包下及子包下
        否则自定义的配置类就会被所有Ribbon客户端所共享，达不到特殊化定制目的   
        所以该目录必须放在启动类上级目录的平级目录下，因为启动类中有这个注解
    2.具体：
        添加同级配置类
        启动类添加注解@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MySelfRule.class)
        测试：http://localhost/consumer/payment/get/31 无规则交替出现 8001,8002
        
### 8.5  （40） ribbon默认负载轮询算法原理（3台机器的轮询？？？）
    
    1.负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标，每次服务重启后，rest接口计数从1开始
        服务数量：2台
        第一次请求：1%2 = 1 取下标为1的服务
        第二次请求：2%2 = 0 取下标为0的服务
        ...
    
### 8.6    （41） RoundRobinRule源码分析
    
    CAS+自寻锁：尚硅谷Java大厂面试题第二季(java面试必学，周阳主讲)
    https://www.bilibili.com/video/bv18b411M7xz/?spm_id_from=333.788.b_636f6d6d656e74.19
    
### 8.7    （42） ribbon之手写轮询算法

    1.原理：JUC （CAS+自旋锁的复习）
    2.步骤：手写本地负载均衡器
        1.7001/7002集群启动
        2.8001/8002微服务改造
        3.80订单微服务改造
        
    
## 9.OpenFeign服务接口调用
### 9.1    （43） OpenFeign是什么

    1.官网：https://cloud.spring.io/spring-cloud-static/Hoxton.SR1/reference/htmlsingle/#spring-cloud-openFeign
    2.github:github.com/spring-cloud/spring-cloud-openfeign
    2.介绍：-以下Feign指的是openFeign
        Feign是一个申明式webservice客户端。使用Feign能让编写webservice客户端更加简单
        他的使用方法是定义一个服务接口然后在上面添加注解。feign也支持可拔插式的编码器和解码器。springcloud对feign进行了封装，使其支持spring mvc标准注解
        和HttpMessageConverters。Feign可以与Eureka和Ribbon组合使用以支持负载均衡
    3.能做什么：
        Feign旨在使编写java http客户端变得更容易
        前面在使用ribbon+RestTemplate时，利用RestTemplat对http请求的封装处理，形成一套模板化的调用方法，但是实际开发中，由于对服务依赖的调用可能不止一处，往往一个接口会被多处调用
        所以，feign在此基础上，做了进一步封装，由他来帮助我们定义和实现依赖服务接口的定义，在Feign的实现下，我们只需创建一个接口并使用注解的方式来配置他（以前是dao接口上面标准mapper界面，
        现在是一个微服务上标注一个Feign注解即可），即可完成服务提供方的接口绑定，简化了使用Ribbon时，自动封装服务调用客户端的开发量
    4.Feign集成Ribbon
        利用Ribbon维护了Payment的服务列表信息，并且通过轮询实现了客户端的负载均衡。而与Ribbon不同的是，通过Feign只需定义服务绑定接口，且以声明式的方法，优雅简单的实现了服务调用
    
### 9.2    （44） OpenFeign服务调用

    1.注解+接口
    2.新建 feign-cloud-consumer-order80，添加依赖+代码
        pom：openFeign
        yml：配置，从哪个eureka中获取集群的地址
        主启动类：添加注解@EnableFeignClients
        业务类：新建service接口+添加注解,新建controller接口，调用service接口
            @Component
            @FeignClient(value = "CLOUD-PAYMENT-SERVICE")//服务提供者的名称
            public interface PaymentFeignService
            {
                @GetMapping(value = "/payment/get/{id}")
                public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
            
                @GetMapping(value = "/payment/feign/timeout")
                public String paymentFeignTimeout();
            }
        测试:
            1.启动eureka集群 7001 7002
            2.启动提供者 8001 8002
            3.启动openFeign 80
            4.http://localhost/consumer/payment/get/31
            5.Feign自带负载均衡配置项
    
### 9.3    （45） OpenFeign超时控制
    
    1.超时设置，故意设置超时演示出错情况
        1.服务提供方【8001】故意写暂停程序：paymentFeignTimeout，睡眠3秒
        2.服务消费方【80】添加超时方法，默认1秒超时
        3.依次启动：
            eureka服务集群：7001,7002
            服务提供方：8001
            服务调用方：openFiegn 80
        3.测试：
            1.直接访问8001端口：http://localhost:8001/payment/feign/timeout
                等待3秒后，出现执行结果
            2.通过feign去访问服务提供者：
                http://localhost/consumer/payment/feign/timeout
                由于走负载均衡，其默认1秒，所以超过1秒报错，而不是正确显示执行结果
                    Read timed out executing GET http://CLOUD-PAYMENT-SERVICE/payment/feign/timeout
                    feign.RetryableException: Read timed out executing GET http://CLOUD-PAYMENT-SERVICE/payment/feign/timeout
                        at feign.FeignException.errorExecuting(FeignException.java:213)
        4.由于openFeign也依赖ribbon，其超时控制也由ribbon控制，所以若有些业务时间较长，超过了超时控制的默认时间，则需要单独设置
            该设置针对于微服务，而非某个特定的接口
            修改方式：在yml文件中设置超时配置，然后通过测试不会再报错
    
### 9.4    （46） OpenFeign日志增强

    1.openFeign的日志打印功能：
        可以通过配置调整日志级别，从而了解feign中http的细节输出
    2.日志级别：
        1.NONE：默认的不显示任何日志
        2.BASIC：仅记录请求方法，URL，响应状态码及执行时间
        3.HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息
        4.FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据
    3.使用：
        1.配置日志Bean：
            新建配置文件：FeignConfig，注入log的bean
        2.yml文件中开启
        3.启动访问：http://localhost/consumer/payment/get/31
        4.查看日志：
             [PaymentFeignService#getPaymentById] ---> GET http://CLOUD-PAYMENT-SERVICE/payment/get/31 HTTP/1.1
             [PaymentFeignService#getPaymentById] ---> END HTTP (0-byte body)
             ...
             [PaymentFeignService#getPaymentById] <--- HTTP/1.1 200 (493ms)
             [PaymentFeignService#getPaymentById] connection: keep-alive
             [PaymentFeignService#getPaymentById] content-type: application/json
             [PaymentFeignService#getPaymentById] date: Wed, 25 Nov 2020 06:34:38 GMT
             [PaymentFeignService#getPaymentById] keep-alive: timeout=60
             [PaymentFeignService#getPaymentById] transfer-encoding: chunked
             [PaymentFeignService#getPaymentById] 
             [PaymentFeignService#getPaymentById] {"code":200,"message":"查询成功,serverPort: 8001","data":{"id":31,"serial":"尚硅谷"}}
             [PaymentFeignService#getPaymentById] <--- END HTTP (92-byte body)
    
## 10.Hystrix断路由
### 10.1   （47） Hystrix是什么
    
    1.简介：Hystrix已停更，resilience4j是官网推荐的，国内主要用的是 阿里巴巴的 【sentinel】
        主要讲解 Hystrix和sentinel
    2.概述：
        1.分布式系统面临的问题：
            复杂分布式体系结构中的引用程序有数十个依赖关系，每个依赖关系在某些时候将不可避免的失败
            例如：消费者链路调用：A,P,H,I服务，若I服务超时会出现什么问题？[网络卡顿，调用超时，机房断电]
                一个服务不通会导致服务雪崩，宕机
        2.服务雪崩：
            多个服务之间调用，假设服务A调用服务B，服务C，服务B和服务C又调用其他微服务，这就是所谓的‘扇出’，
            如果扇出的链路上某个微服务的调用响应时间过长或者不可用，对微服务A的调用就会占用越来越多的资源，进而引起系统崩溃，即雪崩效应
        3.对于高流量的引用来说，单一的后端依赖可能会导致所有服务器上的所有资源都在几秒钟内饱和，比失败更糟糕的是，这些应用程序还可能导致服务之间的延迟增加
            ，备份队列，线程和其他系统资源紧张，导致整个系统发生更多的级联故障。这些都表示需要对故障和延迟进行隔离和管理，
    3.Hystrix介绍：
        1.是一个处理分布式系统延迟和容错的开源库，在分布式系统里，许多依赖不可避免的会调用失败，比如超时异常等等，
            Hystrix能够保证在一个依赖出问题的情况下，不会导致服务整体失败，避免级联故障，以提高分布式系统的弹性
        2.断路器，本身是一种开关装置，当某个服务单元发生故障之后，通过断路器的故障监控-熔断保险丝，向调用方返回一个符合预期的，可处理的备选响应（FallBack）,而不是长时间的等待
            或者抛出调用方无法处理的异常，这样就保证了服务调用方的线程不会被长时间，不必要的占用，从而避免了故障级联导致的雪崩
        
### 10.2   （48） Hystrix停更进维

    1.github：https://github.com/Netflix/Hystrix/wiki
    2.github首页：Hystrix is no longer in active development, and is currently in maintenance mode.
    
### 10.3   （49） Hystrix服务降级熔断限流概念初讲
    
    1.重要概念：
        ·服务降级：fallback
            1.服务器忙，请稍后再试。不让客户端等待，立即返回友好提示
            2.哪些情况会触发降级：
                ·程序运行异常
                ·超时
                ·服务熔断触发服务降级
                ·线程池，信号量打满也会导致服务降级
        ·服务熔断：break
            1.类比保险丝，服务达到最大访问后，直接拒绝访问，拉闸限电，然后调用服务降级的方法返回友好提示
            2.被动的进行服务降级
        ·服务限流：flowlimit
            1.秒杀高并发等操作，严禁一窝蜂过来拥挤，每秒N个，有序进行
    
### 10.4   （50） Hystrix支付微服务构建

    1.恢复7001为单机版
    2.新建服务提供者8001：hystrix-cloud-provider-payment8001
        1.pom：hystrix
        2.yml：无需额外配置
        3.代码
            启动类：
            service
            controller
    3.初步测试：
        启动7001
        启动8001
        访问：
            成功：http://localhost:8001/payment/hystrix/ok/31
            等待3秒：http://localhost:8001/payment/hystrix/timeout/31
    4.以上为基础，从正确---错误---降级熔断---恢复
    
### 10.5   （51） Jmeter高并发压测后卡顿

    1.高并发测试：
        1.上述可在非高并发下正常使用
        2.jmeter测试：
            1.20000并发压测8001，20000请求都去访问【超时接口】:http://localhost:8001/payment/hystrix/timeout/31
            2.然后在浏览器访问正常接口：http://localhost:8001/payment/hystrix/ok/31 会发现正常接口返回也开始不及时了，有延迟
            3.为什么两个接口最后都会卡死？
                资源占用厉害无法去分解精力处理其他接口

### 10.6   （52） 订单微服务调用支付服务出现卡顿

    1.新建80消费者:hystrix-cloud-consumer-feign-order80
        pom:
        yml
        启动类：@EnableFeignClients
    2.启动测试：消费者是否可以正常条用服务提供者
        启动7001,8001
        正常：http://localhost/consumer/payment/hystrix/ok/31
        压测接口：http://localhost:8001/payment/hystrix/timeout/31
            压测过程中，访问正常接口，会出现延迟，或者超时报错
        所以为了消费端能正常工作，服务端需要做熔断降级
    3.故障现象及导致原因：
        8001同一层次的其它接口服务被困死，因为tomcat线程池里面的工作线程已经被挤占完毕
        所以80在此时调用8001，客户端响应缓慢
        正因为有此故障，才会有 容错，降级，限流
    
### 10.7   （53） 降级容错解决的维度要求
    
    1.解决
        1.超时错误页面：不返回错误页面，返回【服务器忙】
        2.程序出错：兜底的 finally【服务器错误】
        3.解决：
            1.对方服务（8001）超时了，调用者（80）不能一直卡死等待，需要有服务降级
            2.对方服务（8001）down机，调用者（80）不能一直卡死等待，需要有服务降级
            3.对方服务（8001）没问题，调用者（80）故障（80的等待回复的时间小于8001服务处理的时间），自己处理服务降级
        
### 10.8   （54） Hystrix服务降级支付侧fallback

    1.降级方式：查看官网
        注解方式替代编码
    2.分析：
        8001自身问题：
            设置自身调用超时时间的峰值，峰值内可以正常运行，超过了需要有兜底的方法，做服务降级，保证服务其他接口能正常使用
            修改8001，添加注解
                @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
                            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
                })
                一旦调用服务方法失败并抛出错误信息后，会自动调用fallbackMethod申明的方法
            主启动类，添加注解@EnableCircuitBreaker
    3.测试：
        启动7001,8001
        访问：http://localhost:8001/payment/hystrix/timeout/31
        返回：线程池: HystrixTimer-1 8001系统繁忙或者运行报错，请稍后再试,id: 31 o(╥﹏╥)o
              之所以打印线程，是为了直观的看出，断路由并不是当前线程去执行的
        说明：断路器起作用了，在服务提供端，接口时间超过了3秒，直接调用断路器中申明的方法并返回
        
### 10.9   （55） Hystrix服务降级订单侧fallback
### 10.10  （56） Hystrix全局服务降级DefaultProperties
### 10.11  （57） Hystrix通配服务降级FeignFallback
### 10.12  （58） Hystrix服务熔断理论
### 10.13  （59） Hystrix服务熔断案例(上)
### 10.14  （60） Hystrix服务熔断案例(下)
### 10.15  （61） Hystrix服务熔断总结
### 10.16  （62） Hystrix工程流程，最后总结
### 10.17  （63） Hystrix图形化 DashBoard搭建
### 10.18  （64） Hystrix图形化 DashBoard监控实战
## 11.zuul路由网关
### 11.1   （65） GateWay和Zuul课程说明
## 12.GateWay新一代网关
### 12.1   （66） GateWay是什么
### 12.2   （67） GateWay非阻塞异步模型
### 12.3   （68） GateWay工作流程
### 12.4   （69） GateWay9527搭建
### 12.5   （60） GateWay配置路由的两种方式
### 12.6   （71） GateWay配置动态路由
### 12.7   （72） GateWay常用的Predicate
### 12.8   （73） GateWay的Filter
## 13.spring-cloud config 分布式配置中心
### 13.1   （74） Config分布式配置中心介绍
### 13.2   （75） Config分布式配置 总控中心搭建
### 13.3   （76） Config客户端配置与测试
### 13.4   （77） Config动态刷新之手动版
## 14.spring-cloud BUS总线
### 14.1   （78） BUS消息总线是什么
### 14.2   （79） BUS之RabbitMq环境配置
### 14.3   （80） BUS动态刷新全局广播的设计思想和选型
### 14.4   （81） BUS动态刷新全局广播配置实现
### 14.5   （82） BUS动态刷新定点通知
## 15.spring-cloud Stream 消息驱动
### 15.1   （83） Stream为什么被引入
### 15.2   （84） Stream是什么及Binder介绍
### 15.3   （85） Stream的设计思想
### 15.4   （86） Stream编码常用注解简介
### 15.5   （87） Stream消息启动及生产者
### 15.6   （88） Stream消息启动及消费者
### 15.7   （89） Stream之消息重复消费
### 15.8   （90） Stream之group解决消息重复消费
### 15.9   （91） Stream之消息持久化
## 16.spring-cloud Sleuth 分布式请求链路跟踪
### 16.1   （92） Sleuth是什么
### 16.2   （93） Sleuth之zipkin搭建安装
### 16.3   （94） Sleuth链路监控展现
## 17.spring-cloud Alibaba 入门简介
### 17.1   （95） cloud alibaba简介
## 18.spring-cloud Alibaba Nacos 服务注册和配置中心
### 18.1   （96）  Nacos简介和下载
### 18.2   （97）  Nacos安装
### 18.3   （98）  Nacos之服务提供者注册
### 18.4   （99）  Nacos之服务消费者注册和负载
### 18.5   （100） Nacos服务注册中心对比提升
### 18.6   （101） Nacos之服务配置中心
### 18.7   （102） Nacos之命名空间分组和DataID三者关系
### 18.8   （103） Nacos之DataID配置
### 18.9   （104） Nacos之Group分组方案
### 18.10  （105） Nacos之Namespace空间方案
### 18.11  （106） Nacos之集群架构说明
### 18.12  （107） Nacos之持久化切换配置
### 18.13  （108） Nacos之linux版本安装
### 18.14  （109） Nacos之集群配置上
### 18.15  （110） Nacos之集群配置下
## 19.spring-cloud Alibaba Sentinel实现熔断与限流
### 19.1   （111） Sentinel是什么
### 19.2   （112） Sentinel下载安装运行
### 19.3   （113） Sentinel初始化监控
### 19.4   （114） Sentinel流控规则简介
### 19.5   （115） Sentinel流控-QPS直接失败
### 19.6   （116） Sentinel流控-线程数直接失败
### 19.7   （117） Sentinel流控-关联
### 19.8   （118） Sentinel流控-预热
### 19.9   （119） Sentinel流控-排队等待
### 19.10  （120） Sentinel降级简介
### 19.11  （121） Sentinel降级-RT
### 19.12  （122） Sentinel降级-异常比例
### 19.13  （123） Sentinel降级-异常数
### 19.14  （124） Sentinel热点key 上
### 19.15  （125） Sentinel热点key 下
### 19.16  （126） Sentinel系统规则
### 19.17  （127） SentinelResource配置上
### 19.18  （128） SentinelResource配置中
### 19.19  （129） SentinelResource配置下
### 19.20  （130） Sentinel服务熔断Ribbon环境预说
### 19.21  （131） Sentinel服务熔断无配置
### 19.22  （132） Sentinel服务熔断只配置fallback
### 19.23  （133） Sentinel服务熔断只配置blockHandler
### 19.24  （134） Sentinel服务熔断配置fallback和blockHandler
### 19.25  （135） Sentinel服务熔断exceptionsToIgnore
### 19.26  （136） Sentinel服务熔断OpenFeign
### 19.27  （137） Sentinel持久化规则
## 20.spring-cloud Alibaba seata处理分布式事务
### 20.1   （138） 分布式事务问题由来
### 20.2   （139） Seata 术语
### 20.3   （140） Seata-Server 安装
### 20.4   （141） Seata业务数据库准备
### 20.5   （142） Seata之Order-Module配置搭建
### 20.6   （143） Seata之Order-Module代码上
### 20.7   （144） Seata之Order-Module代码下
### 20.8   （145） Seata之Storage-Module说明
### 20.9   （146） Seata之Account-Module说明
### 20.10  （147） Seata之@GloablTransactional验证
### 20.11  （148） Seata之原理简介
## 21.spring-cloud Alibaba 大厂面试题第三季
### 21.1   （149） 雪花算法上
### 21.2   （150） 雪花算法下

### FInal.模块介绍
cloud-api-commons           公共模块
cloud-provider-payment8001  支付模块
cloud-consumer-order80      消费者订单模块
cloud-eureka-server7001     服务注册中心：http://localhost:7001/

