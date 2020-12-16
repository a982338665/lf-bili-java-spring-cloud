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
>Stream： https://spring.io/projects/spring-cloud-stream
>Nacos：https://github.com/alibaba/nacos/releases/download/1.1.4/
>springcloud集成sentinel文档：https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/en-us/index.html#_spring_cloud_alibaba_sentinel
>下载地址：https://github.com/alibaba/Sentinel/releases/download/1.7.0/sentinel-dashboard-1.7.0.jar
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

    1.客户端（消费者）进行降级保护
        1.设置等待时间，若服务端长时间无响应，则放弃
    2.修改80服务：
        yml: 开启hystrix
        代码：
            主启动：@EnableHystrix
            业务：添加注解
    3.测试：
        1.修改8001服务，使服务在3秒后返回，而80服务中设置超时时间为1.5秒，因此肯定会超时
            故，最后查看是否 走了 80服务中的断路由方法
            访问：http://localhost/consumer/payment/hystrix/timeout/31
            结果：我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o
            说明：表示消费者在1.5秒内未获得请求结果，从而走了断路由方法
    
### 10.10  （56） Hystrix全局服务降级DefaultProperties

    1.出现问题：
        1.每一个业务方法，都有相对应的一个熔断降级方法，会导致代码膨胀
        2.统一的和自定的分开：设置全局降级方法+单独自定义降级方法
               类上注解：配置默认降级方法
               方法上注解：若配置降级方法则按降级方法，若没有配置，则按全局降级方法
    3.测试，同55
    
### 10.11  （57） Hystrix通配服务降级FeignFallback
    
    1.80服务，统一服务降级，抽取
    2.为Feign客户端定义的接口 添加一个服务降级处理的实现类即可实现解耦
    3.未来面对的异常：
        ·运行
        ·超时
        ·宕机
    5.通过service实现类，一次性解耦降级方法PaymentFallbackService
    6.测试：
        启动7001
        启动8001
        启动80
        测试访问80：http://localhost/consumer/payment/hystrix/ok/31 正常返回
        关闭8001：继续访问 http://localhost/consumer/payment/hystrix/ok/31 返回错误
            -----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o   表示解耦成功
            此时provider服务宕机，而客户端不会再去等待，而是做了服务降级处理，返回提示信息，防止连锁效应，耗死消费者服务器
    
### 10.12  （58） Hystrix服务熔断理论
    
    服务熔断：
        熔断机制：对雪崩效应的一种微服务链路保护机制  ，当扇出链路的某个微服务报错不可用或者响应时间过长，会进行服务降级，进而熔断该服务的调用，快速返回错误响应
                  当检测到该服务调用响应正常后，恢复调用链路
        在springcloud框架里，熔断机制通过hytstrix实现，他会监控微服务间的调用情况，当失败的调用达到某一个阀值，缺省是5秒内调用20次调用失败，就会启动熔断机制，注解为@HystrixCommand
    
### 10.13  （59） Hystrix服务熔断案例(上)
    
    0.hutool.cn ===>  工具包的使用
    1.操作：
        修改8001：-> PaymentService
    2.默认属性：HystrixCommandProperties
        //表示在10秒内，10次请求中，超过60%是失败的（即6次以上），则触发断路器，待服务器恢复后，关闭断路器，重新连接使用
        //其他参数以官网为准
        //详细的默认参数查看类 HystrixCommandProperties
        
### 10.14  （60） Hystrix服务熔断案例(下)
    
    1.启动7001,8001
    2.测试：
        负数：断路由 http://localhost:8001/payment/circuit/-31
            id 不能负数，请稍后再试，/(ㄒoㄒ)/~~ id: -31
        正数：正常访问 http://localhost:8001/payment/circuit/31
    3.10秒内频繁访问 http://localhost:8001/payment/circuit/-31
      多次造成断路由，可能会进行服务熔断，此时再去访问正确的路径  http://localhost:8001/payment/circuit/31，仍会报错
      直到隔一段时间后，再次恢复正确访问
    
### 10.15  （61） Hystrix服务熔断总结

    1.熔断：错误率太高，造成熔断，返回错误，然后随正确率越来越高，逐步恢复服务
    2.熔断类型
        1.熔断打开-请求不在进行调用当前服务，内部设置时钟一般为MTTR（平均故障处理时间），当打开时长达所设时钟则进入半熔断状态
        2.熔断关闭-熔断关闭不会对服务进行熔断
        3.熔断半开-部分请求根据规则调用当前服务，如果请求成功且符合规则认为服务恢复正常，关闭熔断，恢复链路
    3.涉及到断路器的三个重要参数：快照时间窗，请求总数阀值，错误百分比阀值
        1.快照时间窗：熔断器确定是否打开需要统计一些请求和错误数据，而统计的时间范围就是快照时间窗，默认为最近的10秒
        2.请求总数阀值：在快照时间窗内必须满足请求总数阀值才有资格熔断，默认为20，意味着10秒内，如果hystrix命令的调用次数不足20次
            即使所有请求都超时或其他原因失败，断路器都不会打开
        3.错误百分比阀值：当请求总数在快照时间窗内超过了阀值，比如发生了30次调用，有15次发生了异常，也就是超过了50%的错误百分比，在默认
            设置50%阀值情况下，这时就会将熔断器打开
    4.断路器开启关闭的条件
        1.默认10秒内超过20个请求，其中请求的50%都是失败的，就会 开启断路器，此后请求不会被转发，直接调用服务降级fallback
        2.一段时间后，默认5秒，断路器半开状态，会让其中一个请求进行转发，如果成功，断路器关闭，服务正常
        
### 10.16  （62） Hystrix工程流程，最后总结
    
    1.服务限流：后面讲解阿里巴巴的Sentinel时说明
    2.工作流程：查看github
    
### 10.17  （63） Hystrix图形化 DashBoard搭建
    
    1.新建模块仪表盘9001:hystrix-cloud-consumer-dashboard9001
    2.依赖
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
        </dependency>
    3.注解：@EnableHystrixDashboard
    4.所有的Provider微服务提供类 8001,8002,8003都需要监控依赖配置
        provider中需要引入依赖
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-actuator</artifactId>
            </dependency>
    5.启动访问：
        localhost:9001/hystrix
    
### 10.18  （64） Hystrix图形化 DashBoard监控实战

    1.通过在9001服务界面上填写服务地址，来监控服务
    2.修改8001以支持图形化：
        1.pom中必须有：--图形化标配
              <dependency>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-starter-web</artifactId>
              </dependency>
              <dependency>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-starter-actuator</artifactId>
              </dependency>
        2.启动类中加方法：注入bean
        3.测试：
            启动7001,8001,9001
            1.访问：http://localhost:9001/hystrix
                地址栏输入：http://localhost:8001/hystrix.stream
                    Delay: 2000 
                    Title: T3
                先不点击 Monitor Stream
            2.访问：
                正确的一次：http://localhost:8001/payment/circuit/31
                错误的一次：http://localhost:8001/payment/circuit/-31
                然后多次访问以上地址
            3.点击1中的Monitor Stream按钮，进入监控
            4.看图：-- 具体看图片 64-i.jpg
                7色：Success | Short-Circuited | Bad Request | Timeout | Rejected | Failure | Error %
                1圈:健康度：绿>黄>橙>红     流量越大，圈越大，所以通过圆的大小就能快速在大量实例中发现故障实例和高压实例
                1线：记录两分钟内流量的相对变化 ，用来观察流量的上升下级趋势
        
## 11.zuul路由网关
### 11.1   （65） GateWay和Zuul课程说明
    
    1.所有微服务都应该有服务网关，来对服务进行日志记录，限流，鉴权，安全架构等工作，类似于医院的分诊台
    2.zuul网关由于内部发生重大分歧，暂时弃用
        zuul原计划生成zuul2，其核心人员跳槽，zuul生成zuul2的分歧较大。Netflix自研
    3.主要内容 gateway-新一代网关：用到了netty，spring5.0后的新特性等,spring社区等不及Netflix自研
    
## 12.GateWay新一代网关
### 12.1   （66） GateWay是什么

    1.为什么选择GateWay？
        ·Netflix不靠谱，zuul2.0迟迟不发布，而gateway是springcloud团队研发的，使用便捷
        ·gateway是基于异步非阻塞模型开发的，性能无需担忧
        ·gateway的特性：
            1.基于spring framework 5，Project Reactor和SpringBoot2.0 进行构建
            2.动态路由，能够匹配任何请求属性
            3.可以对路由指定Predicate（断言）和Filter（过滤）
            4.集成hystrix的断路由功能
            5.集成spring cloud的服务发现功能
            6.易于编写的Predicate（断言）和Filter（过滤）
            7.请求限流功能
            8.支持路径重写
    2.zuul和gateway的区别？
        ***** 在SpringCloud Finchley 正式版之前，springcloud推荐的网关是NetFlix提供的zuul*****
        1.zuul 1.x，是一个基于阻塞I/O的API GateWay
        2.zuul 1.x 是基于servlet2.5使用阻塞架构他不支持任何长连接（如Websocket），Zuul的设计模式和nginx较像，每次I/O
            操作都是从工作线程中选择一个执行，请求线程被阻塞到工作线程完成，但是差别是，nginx使用c++实现，zuul使用java实现
            而jvm本身有第一次加载慢的情况，使得zuul的性能相对较差
        3.zuul2.x的理念更先进，基于netty的非阻塞和支持长连接，但是springcloud目前还未整合，zuul2.x的性能叫zuul1.x的性能有较大提升
        4.在性能方面，根据官方提供的基准测试，gateway的RPS（每秒请求数）是zuul的1.6倍
        5.gateway建立在spring framework 5 ，project Reactor 和springboot2 之上，使用非阻塞API
        6.gateway还支持websocket，并与spring紧密集成 拥有更好的开发体验
    3.zuul1.x的模型：
        springcloud所集成的zuul版本，采用的是tomcat容器，使用的是传统的Servlet IO处理模型
            servlet的生命周期，servlet由servlet container 进行生命周期管理
            1.container 启动时构造 servlet对象并调用servlet init()进行初始化
            2.container 运行时接收请求，并为每个请求分配一个线程（一般从线程池中获取空线程），然后调用service（）
            3.container 关闭时调用servlet destory()销毁servlet  
        上述模式的缺点：
            1.servlet是一个简单的网络IO模型，当请求进入servlet container时，servlet container就会为其绑定一个线程，在并发不高的场景下，这种模式是适用的
                但是，在高并发场景下（jmeter），线程数量就会上涨，而线程资源代价是昂贵的，（上下文切换，内存消耗大），严重影响请求的处理时间，在一些简单业务场景下
                不希望为每个request分配一个线程，只需要1个或几个线程就能应对极大的并发请求，这种场景下servelt模型没有优势
            2.所以zuul1.x是基于servlet之上的一个阻塞式处理模型，即spring实现了处理所有request请求的一个servlet（DispatcherServlet）并由该servlet阻塞式处理请求，
                所以zuul1.x无法摆脱servlet的弊端
    4.gateway模型：
        WebFlux：
            1.官网：https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html
            2.说明：
                传统的web框架，例如 struct2，springmvc，都是基于servlet api与servlet容器基础上运行的【servlet2.5】
                但是
                在servlet3.1之后有了异步非阻塞的支持，而webflux是一个典型的异步非阻塞框架，他的核心是基于Reactor的相关api实现的。相对于传统的web框架来说，他可以运行在诸如
                netty，Undertow及支持servlet3.1的容器上，非阻塞式+ 函数式编程（spring 5必须使用java8）
                Spring WebFlux是spring 5.0引入的新的响应式框架，区别于springmvc，他不需要依赖Servlet api，他是完全异步非阻塞的，并且基于Reactor来实现响应式流规范  
                
### 12.2   （67） GateWay非阻塞异步模型
### 12.3   （68） GateWay工作流程

    1.三大核心概念：   
        1.Route（路由）
            是构建网关的基本模块，由id，目标URL，一系列的断言和过滤器组成，如果断言为true则匹配该路由
        2.Predicate（断言）
            参考的是java8的java.util.function.Predicate，开发人员可以匹配http请求中的所有内容（例如请求头或请求参数），如果请求与断言相匹配则进行路由
        3.Filter（过滤）
            指的是Spring框架中GatewayFilter的实例，使用过滤器，可以在请求被路由前或者之后对请求进行修改
            Filter-pre：参数校验，鉴权，流量监控，日志输出，协议转换
            Filter-after：响应内容，响应头的改变，日志输出，流量监控
        4.总体：
            web请求，通过一些匹配条件，定位到真正的服务节点，并在这个转发过程的前后，进行一些精细化控制。predicate就是我们的匹配条件，而filter可以理解为一个拦截器，再加上一个
            目标uri就能实现一个具体的路由了
    
### 12.4   （69） GateWay9527搭建

    1.pom
    2.yml:网关也是微服务，需要注册进注册中心
    3.启动类：@EnableEurekaClient
    
    4.选择路由：eureka-cloud-provider-payment8001查看controller路由：get   lb
        目前不想暴露8001端口，所以在外面套一层9527
    5.修改9527的yml配置：添加转发配置
    6.测试：
        启动7001,8001,9527 [eureka-cloud-provider-payment8001]
        访问说明：
            添加网关之前
                http://localhost:8001/payment/lb
                http://localhost:8001/payment/get/31
            添加网关之后
                http://localhost:9527/payment/lb
                http://localhost:9527/payment/get/31
        访问结果：都能正常访问，接下来就是隐藏原来端口了  
                
### 12.5   （70） GateWay配置路由的两种方式：可混用

    1.yml中进行配置：见【59】
    2.代码编辑：代码中注入RouteLocator的Bean-GateWayConfig
        1.要求：通过9527网关访问到外网的百度新闻网址
        2.取消yml配置，进行编码
    3.测试：
        http://localhost:9527/guonei  会跳转到百度新闻
        http://localhost:9527/guoji   会跳转到百度新闻
    
### 12.6   （71） GateWay配置动态路由-网关默认的负载均衡

    1.默认情况下GateWay会根据注册中心注册的服务列表，以注册中心上微服务名为路径创建动态路由进行转发，从而实现动态路由功能
    2.启动：一个7001+两个服务提供者8001/8002
    3.pom：spring-cloud-starter-netflix-eureka-client
    4.yml：开启动态路由，替换url
    5.测试：
        1.必须先启动7001,8001,8002，待成功后再启动9527
        2.访问：http://localhost:9527/payment/lb 交替出现 8001,8002

### 12.7   （72） GateWay常用的Predicate

    1.spring cloud gateway将路由匹配作为Spring webflux HandleMapping基础架构的一部分。
      spring cloud gateway包括许多内置的Route Predicate工厂，所有这些Predicate都与http请求的不同属性匹配，多个predicate可以组合使用
    2.spring cloud gateway创建Route对象时，使用RoutePredicateFactory创建Predicate对象，Predicate对象可以赋值给Route。其包含许多的Route Predicate Factories
      所有这些谓词都匹配http请求的不同属性。多种谓词工厂可以组合，并通过逻辑and
    3.测试：
        curl http://localhost:9527/payment/lb
        curl http://localhost:9527/payment/lb --cookies "username=zzyy"
        curl http://localhost:9527/payment/lb -H "X-Request-Id:123"
        curl http://localhost:9527/payment/lb?username=123
        curl返回中文乱码问题：http://blog.csdn.net/leedee/article/details/82685636
    
### 12.8   （73） GateWay的Filter
    
    1.生命周期：pre post
    2.种类：私有+全局
        ·GatewayFilter：直接在yml中配置
        ·GlobalFilter：-- 编码
            ·作用：全局日志记录，统一网关鉴权
    3.测试：
        http://localhost:9527/payment/lb 返回406
        http://localhost:9527/payment/lb?uname=1 正确访问
        
## 13.spring-cloud config 分布式配置中心
### 13.1   （74） Config分布式配置中心介绍

    1.目前市面主要三套：
        1.Config+Bus：北京用的多
        2.apolo：携程网站推出的，主流，推荐使用,上海用的比较多
        3.Alibaba Nacos：北京用的多
    2.分布式面临的问题：一处修改出处生效
        由于微服务项目很多，每一个项目都有一个yml，那么修改共用配置的时候就会非常麻烦，因此抽取作为公共配置便成为必然趋势
        spring Cloud提供了ConfigServer解决这个问题
    3.是什么？
        提供了集中化的外部支持，中心化的外部配置,例如github，gitlab，gitee等
    4.怎么用？
        Config分为客户端和服务端：
            服务端：也称分布式配置中心，是一个独立的微服务应用，用来连接配置服务器并未客户端提供获取配置信息，加密/解密信息等访问接口
            客户端：通过指定的配置中心来管理应用资源，以及与业务相关的配置内容，并在启动的时候从配置中心获取和加载配置信息，
                配置服务器默认采用git来存储配置信息，这样就有助于对环境配置进行版本管理，并且可以通过git客户端工具来方便管理和访问配置内容
    5.作用：
        1.集中管理配置文件
        2.不同环境不同配置，动态化的配置更新，分环境部署，例如dev/test/prod/beta/release
        3.运行期间动态调整配置，不在需要在每个服务部署的机器上编写配置文件，服务会向配置中心统一拉去配置自己的信息
        4.当配置发生变动时，服务不需要重启即可感知配置文件的变化，并应用新的配置
        5.将配置信息以rest接口的形式暴露：post，curl命令刷新即可
    6.与github整合配置：
        由于springcloud config 默认使用git来存储配置文件（其他方式svn，本地文件），但最推荐的还是git，而且使用http、https访问的形式
    
### 13.2   （75） Config分布式配置 总控中心搭建

    1.使用步骤：
        0.视屏中的github地址：zzyybs/springcloud=config.git
        1.用自己的账号在github上新建一个名为config-spring-cloud20201130的新仓库
        2.获取仓库地址
        3.检出该仓库:D:\git-20200518\config-spring-cloud20201130
        4.在该仓库下新建yml
            test，prod，dev等
            表示多个环境的配置文件，保存格式必须为utf-8
            git操作，commit ，add ，push
        5.新建模块：config-spring-cloud-center3344
        6.测试：是否能够正常获取github上的数据内容
            依次启动7001,3344
            localhost:3344/master/config-dev.yml 【主分支名称被修改，所以会失败】
            localhost:3344/main/config-dev.yml 【现今主分支名为 main】
        7.启动报错问题：auth fail 
            解决01：使用http/https的git地址，在配置文件中加入账号密码
                git:
                  uri: git@github.com:a982338665/config-spring-cloud20201130.git #GitHub上面的git仓库名字
                  search-paths:
                    - config-spring-cloud20201130
                  pawwword:XXX
                  username:XXX
        8.访问路径的配置规则： http请求地址和资源文件映射如下: 
            /{application}/{profile}[/{label}]
            /{application}-{profile}.yml
            /{label}/{application}-{profile}.yml
            /{application}-{profile}.properties
            /{label}/{application}-{profile}.properties
            #{application}映射客户端的"spring.application.name"
            #{profile}映射客户端的"spring.profiles.active"（逗号分隔列表）
            示例：
                http://localhost:3344/cloud-config-center/dev/main
                    {"name":"cloud-config-center","profiles":["dev"],"label":"main","version":"dd0c22cba896ae0cf6180a875c08dd73282611fb","state":null,"propertySources":[]}
                http://localhost:3344/main/config-dev.yml
                    config:
                      info: master branch,springcloud-config/config-dev.yml version=7
                http://localhost:3344/config/dev/main
                    {"name":"config","profiles":["dev"],"label":"main","version":"dd0c22cba896ae0cf6180a875c08dd73282611fb","state":null,"propertySources":[{"name":"https://github.com/a982338665/config-spring-cloud20201130.git/config-dev.yml","source":{"config.info":"master branch,springcloud-config/config-dev.yml version=7"}}]}
    
### 13.3   （76） Config客户端配置与测试

    1.新建客户端3355：config-spring-cloud-client3355
       ·pom依赖：与服务端的不一样，需要注意
            spring-cloud-starter-config
            spring-cloud-config-server
       ·bootstrap.yml：
            是什么？
                application.yml是用户级的资源配置项，bootstrap.yml是系统级的，优先级更高
                springcloud会创建一个“bootstrap Context”，作为spring应用的“application context”的父上下文，初始化的时候，“bootstrap Context”负责从外部源加载配置属性并解析配置，这两个上下文共享
                一个从外部获取的“Environment”
                Bootstrap有高优先级，默认情况下不会被本地配置覆盖，bootstrap Context和application context有着不同的约定，所以新增了一个bootstrap.yml文件，保证两者配置分离
                【将application.yml更名为bootstrap.yml是很关键的】
                bootstrap优先于application.yml加载
            内容：--
       ·修改config-dev.yml配置并提交到Github，比如价格变量age或者版本号version
       ·主启动
       ·业务类
       ·测试：
            启动7001，3344，3355
            测试3344：localhost:3344/main/config-dev.yml
            测试3355：localhost:3355/configInfo    ==== 通过github获取到了配置信息
       ·分布式配置的动态刷新问题：
            1.linux运维修改github上的配置文件做内容修改
            2.刷新3344，发现ConfigServer配置中心立刻响应
            3.刷新3355，发现ConfigClient客户端没有任何响应
            4.3355没有变化，除非重启或者重新加载
            5.每次运维修改配置文件，客户端需要重启？？？？
    
### 13.4   （77） Config动态刷新之手动版
    
    0.解决动态刷新问题
    1.修改3355，pom引入actuator监控
    2.修改yml，暴露监控端点
    3.@RefreshScope业务类controller修改
    4.测试：
        1.修改github配置文件
        2.查看3344                    localhost:3344/main/config-dev.yml
        3.查看3355，看是否同步更新    localhost:3355/configInfo
        4.测试后仍发现，3344访问获取到的数据是最新的，而3355不是
            需要运维人员发送post请求刷新3355【手动】
                1.curl -X POST "http://localhost:3355/actuator/refresh" 返回值：["config.client.version","config.info"]
                2.使用idea自带的client：Tools--HTTP Client -- Test RESULTFul Web Service
        5.然后重复上面的步骤测试，就发现3355已经被同步过来了，避免重启
    5.针对于手动解决动态刷新问题，还会有什么其他问题？？？
        1.假设有多个微服务客户端3355,33366,3377等，是不是每次更新都需要去各个微服务调用POST请求刷新客户端配置
        2.可否广播，一次修改，出处生效？ --> 消息总线
        
## 14.spring-cloud BUS总线
### 14.1   （78） BUS消息总线是什么

    1.分布式自动刷新配置功能，SpringCloud Bus配合Cloud Config可以实现配置的动态刷新
    2.Bus是什么？支持两种消息代理
        1.kafka
        2.Rabbitmq
        SpringCloud Bus是用来将分布式系统的节点与轻量级消息系统连接起来的框架，它整合了java的事件处理机制和消息中间件的功能
        StringCloud Bus目前仅支持kafka，rabbitmq
        3.流程：
            1.github:运维修改github仓库的配置中心的文件
            2.ConfigServer:获取github配置中心文件
            3.POST /bus/refresh
            4.ConfigClient01 向 ConfigServer获取配置信息 并想CloudBus订阅
            5.ConfigClient02 向 ConfigServer获取配置信息 并想CloudBus订阅
            6.通过Post请求，通知刷新所有订阅到Bus的消息从新获取配置信息
    3.作用：
        CloudBus能管理和传播分布式系统间的消息，就像一个分布式执行器，可以用来广播状态更改，事件推送等，也可以当做微服务间的通信通道
        可以让Post请求去更新COnfigServer，然后Client去订阅server，达到通知目的
    3.什么是总线：
        在微服务架构中，通常会使用轻量级的消息代理来构建一个公共的消息主题，并让系统中所有的微服务连接上来，由于该主题产生的消息会被所有实例监听和消费，所以称为消息总线
        在总线的各个实例，都可以方便的广播一些需要让其他连接在该主题上的实例都知道的消息
    4.基本原理：
        ConfigClient实例都监听MQ中的同一个topic（默认为springCloudBus），当一个服务刷新数据的时候，他会把这个信息放到Topic中，这样其他监听同一topic的服务就能得到通知，然后去更新自身配置
    
### 14.2   （79） BUS之RabbitMq环境配置
    
    1.启动：docker run -d --hostname rabbit-host --name rabbitmq -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=pwd -p 15672:15672 -p 5672:5672 rabbitmq:3-management
        访问：http://server-ip:15672  账号： guest 密码： guest   或者 user/pwd
    
### 14.3   （80） BUS动态刷新全局广播的设计思想和选型
    
    1.条件：安装好的Rabbitmq环境
    2.以3355为模板，做3366服务
    3.设计思想：
        1.利用消息总线触发一个客户端/bus/refresh,进而刷新所有客户端配置
        2.利用消息总线触发一个服务端ConfigServer的/bus/refresh端点，进而刷新所有客户端配置
        3.第二个更合适，原因如下：
            1.破坏了微服务的职责单一性，因为微服务本身是业务模块，不应该承担配置刷新责任
            2.破坏了微服务各节点的对等性
            3.有一定的局限性，例如，微服务在潜迁移时，他的网络地址常常会发生变化，此时若要自动刷新，就会增加更多修改
    
### 14.4   （81） BUS动态刷新全局广播配置实现

    1.3344服务端添加消息总线支持
        pom:spring-cloud-starter-bus-amqp
        yml:rabbitmq配置+端点暴露
    2.3355客户端添加消息总线支持
        pom:spring-cloud-starter-bus-amqp
        yml:rabbitmq配置+端点暴露
    3.3366客户端添加消息总线支持
        pom:spring-cloud-starter-bus-amqp
        yml:rabbitmq配置+端点暴露
    4.测试
        1.依次启动 7001,3344,3355,3366
        2.访问3344：localhost:3344/main/config-dev.yml               info: master branch,springcloud-config/config-dev.yml version=888
        3.访问3355：localhost:3355/configInfo                         master branch,springcloud-config/config-dev.yml version=888
        4.访问3366：localhost:3366/configInfo                         serverPort: 3366 configInfo: master branch,springcloud-config/config-dev.yml version=888
        5.修改github：config-spring-cloud20201130下的配置文件，version改为999
        6.访问3344：localhost:3344/main/config-dev.yml               info: master branch,springcloud-config/config-dev.yml version=999
        7.访问3355：localhost:3355/configInfo                         master branch,springcloud-config/config-dev.yml version=888
        8.访问3366：localhost:3366/configInfo                         serverPort: 3366 configInfo: master branch,springcloud-config/config-dev.yml version=888
        9.一次修改广播通知处处生效：修改ConfigServer通知到Client
            curl -X POST "http://localhost:3344/actuator/bus-refresh"
    
### 14.5   （82） BUS动态刷新定点通知 - 只想通知一个，定点通知，只想通知3355不想通知3366
    
    1.curl -X POST "http://localhost:3344/actuator/bus-refresh/{destinalion}"
        /bus/refresh请求不在发送到具体的服务实例上，而是发给ConfigServer通过destinalion参数类指定需要更新配置的服务或实例
    2.例如只想通知3355，不想通知3366则执行：
        curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355"
        config-client指的是yml中的应用名称
    
## 15.spring-cloud Stream 消息驱动
### 15.1   （83） Stream为什么被引入
        
    1.MQ消息中间件：
        ·ActiveMQ
        ·RabbitMQ
        ·RocketMQ
        ·Kafka
    2.一个系统可能会用到多种MQ，而Stream就不需要去关注到底使用的是哪种MQ，可以适配任何一种mq，自动在各种mq来回切换
    3.Stream：屏蔽底层消息中间件的差异，降低切换成本，统一消息的编程模型
    4.官网：
        https://spring.io/projects/spring-cloud-stream
        https://cloud.spring.io/spring-cloud-static/spring-cloud-stream/3.0.1.RELEASE/reference/html/
        Stream中文手册：http://m.wang1314.com/doc/webapp/topic/20971999.thml
    
### 15.2   （84） Stream是什么及Binder介绍

    1.主要关注 Binder Implementations
    2.什么是cloud stream？
        是一个构建消息驱动微服务的框架
        应用程序通过inputs或者outputs来与Cloud Stream中的binder对象交互
        通过配置binding（绑定），Cloud Stream的binder对象负责与消息中间件进行交互
        所以，只要弄清楚程序如何与Cloud Stream交互就能够很好的使用消息中间件
        通过使用Spring Integration来连接消息代理中间件以实现消息事件驱动，SpringCloudStream为一些供应商的消息中间件产品提供了个性化的自动化配置实现，引用了发布-订阅，消费组，分区的三个核心概念  
    3.目前SpringCLoud Stream仅支持Rabbitmq，kafka 【来源于官网】
         
### 15.3   （85） Stream的设计思想 - 类似于工厂模式【自己理解】
    
    1.标准mq，没有引入Stream时：
        1.生产者，消费者之间靠消息媒介传递信息内容 - Message
        2.消息必须走特定的通道 - MessageChannel
        3.消息通道里的消息如何被消费呢，谁负责收发处理 - 消息通道子接口SubscribableChannel，有MessageHandler消息处理器所订阅
    2.为什么用Stream？
        例如，同时用到rabbitmq和kafka，由于这两个消息中间件架构上的不同，像Rabbitmq有exchange，kafka有topic和Partition分区
        在没有绑定器的概念的时候，springboot应用要直接和消息中间件进行交互，由于各个mq的架构不同，实现细节不同，所以
        通过定义绑定器作为中间层，来将中间件和应用程序解耦合
        通过向应用程序暴露统一的channel通道，使得应用程序不用在考虑中间件的选择与实现
        通过定义绑定器binder作为中间层，实现了应用程序和消息中间件细节之间的隔离
    3.Binder：
        input       消费者
        output      生产者
    4.Stream中的消息通信方式遵循了发布-订阅模式
        topic主题进行广播：
            ·在rabbitmq就是exchange
            ·在kafka中就是topic
    
### 15.4   （86） Stream编码常用注解简介

    1.Stream标准流程套路：
        Binder          方便的连接中间件，屏蔽差异
        Channel         通道，是队列Queue的一种抽象，在消息通讯系统中就是实现存储和转发的媒介，通过channel对队列进行配置
        Source和Sink    简单理解为参照对象是cloud Stream，从stream发布消息就是输出，接收消息就是输入
    2.编码中常用的注解： 
        @Input              标识输入通道，发布的消息通过该通道进入引用程序
        @Output             标识输出通道，发布的消息通过该通道离开引用程序
        @StreamListener     监听队列，用于消费者的队列的消息接收
        @EnableBinding      指信道channel和exchange绑定在一起
    3.准备：
        1.Rabbitmq
        2.新建三个子模块
            stream-rabbitmq-cloud-provider8801  生产者
            stream-rabbitmq-cloud-consumer8802  消费者
            stream-rabbitmq-cloud-consumer8803  消费者
    
### 15.5   （87） Stream消息驱动及生产者

    1.新建 stream-rabbitmq-cloud-provider8801
    2.pom:spring-cloud-starter-stream-rabbit
    3.yml: 
        output: # 这个名字是一个通道的名称
    4.主启动类8801：
    5.业务类：controller调用的不再是service，而是消息中间件注解
    6.测试：
        1.启动7001-eureka
        2.启动rabbitmq-http://122.51.144.140:15672
        3.启动8801：会报连接错误，但是没有测试影响
        4.访问：
            localhost:8801/sendMessage   登录rabbitmq可以看见波峰
        
### 15.6   （88） Stream消息驱动及消费者

    1.新建 stream-rabbitmq-cloud-consumer8802
    2.pom：spring-cloud-starter-stream-rabbit
    3.yml: 
           input: # 这个名字是一个通道的名称
    4.主启动
    5.业务类
        1.由于是消费者队列，没有controller只有监听队列
            controller：
                @Component
                @EnableBinding(Sink.class)
                public class ReceiveMessageListenerController
                {
                    @Value("${server.port}")
                    private String serverPort;
                    @StreamListener(Sink.INPUT)
                    public void input(Message<String> message)
                    {
                        System.out.println("消费者1号,----->接受到的消息: "+message.getPayload()+"\t  port: "+serverPort);
                    }
                }      
    6.测试：
        0.启动7001，rabbitmq，8801（会报连接错误，但是没有测试影响）,8802（会报连接错误，但是没有测试影响）
        1.访问：localhost:8801/sendMessage
        2.结果，发送成功，接收成功
       
### 15.7   （89） Stream之消息重复消费
    
    1.依照8802，clone出8803： stream-rabbitmq-cloud-consumer8803
    2.启动：
        1.rabbitmq
        2.7001 - eureka
        3.8801 - provider
        4.8802 - consumer
        5.8803 - consumer
    3.运行后出现的两个问题：
        1.重复消费
        2.消息持久化
    4.消费：
        1.目前是8802,8003同时都收到了，存在重复消费问题
            http://localhost:8801/sendMessage
            解决：分组和持久化属性group
            生产实际案例：
                例如在如下场景，订单系统集群部署，都会从rabbitmq获取订单信息，那如果一个订单被两个服务获取到，那么就会造成数据错误，要避免这种情况就要用到
                Stream的消息分组来解决
                注意：同一个group中的消费者是竞争关系，能够保证消息只会被其中一个应用消费一次，不同组是可以全面消费的（重复消费）
            在rabbitmq中寻找组名group：见图
    
### 15.8   （90） Stream之group解决消息重复消费
    
    1.重复消费
        ·故障现象：重复消费
        ·导致原因：groupid不同
    2.解决：
        自定义配置分为同一组，解决重复消费问题
    3.原理：
        微服务应用放置于同一个group中，就能够保证消息只会被其中一个应用消费一次。不同的组是可以消费的，同一个组是竞争关系，且一条数据只能被一个消费
    4.测试：
        1.8802,8803变成不同组，group两个不同
            group：atguiguA atguiguB
            8802修改yml:group atguiguA
            8803修改yml:group atguiguB
            测试：访问：http://localhost:8801/sendMessage   不同组，会被重复消费
        2.8802,8803实现轮询分组，每次只有一个消费者
            group：atguiguA
            8802修改yml:group atguiguA
            8803修改yml:group atguiguA
            测试：访问：http://localhost:8801/sendMessage   同组，不会被重复消费
            
### 15.9   （91） Stream之消息持久化
    
    1.通过group解决重复消费问题
    2.停止8802和8803并去除掉8802的分组group：atguiguA，不要去掉8803的分组group：atguiguA（此时启动的服务只有7001,8801）
    3.8801先发送4条数据到rabbitmq（提供者一直发送消息，却没有消费者消费）
    4.先启动8802，无分组属性配置，后台没打出来消息，说明重启后，会造成消息丢失
    4.再启动8803，有分组属性配置，后台打出来消息（所有消息），说明group属性对持久化有重大作用，不会造成数据丢失
    
## 16.spring-cloud Sleuth 分布式请求链路跟踪
### 16.1   （92） Sleuth是什么
    
    1.前言：
        在微服务框架中，一个由客户端发起的请求在后端系统中会经过多个不同的服务节点调用来协同产生最后的请求结果，每个前端请求都会形成一条复杂的分布式服务调用链路
        链路中的任何一环出现高延时或者错误都会引起整个请求最后的失败。例如订单调用：积分，物流，仓储....
    2.是什么？
        1.https://github.com/spring-cloud/spring-cloud-sleuth
        2.提供了一套完整的服务跟踪的解决方案
        3.在分布式系统中提供追踪解决方案并且兼容支持了zipkin dashboard （仪表盘-图形化展示）
    
### 16.2   （93） Sleuth之zipkin搭建安装
    
    1.zipkin：
        1.下载
            ·Cloud从F版起已经不需要自己构建Zipkin Server了，只需调用jar包即可
            ·https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/
            ·zipkin-server-2.12.9-exec.jar
        2.运行jar
            java -jar zipkin-server-2.12.9-exec.jar
        3.运行控制台
            localhost:9411/zipkin/
            术语：
                ·完整的调用链路：表示一请求链路，一条链路通过Trace Id唯一标识，Span标识发起的请求信息，各span通过parentid关联起来【见图】
                ·Trace：类似于树结构的Span集合，表示一条调用链路，存在唯一标识
                ·span：表示调用链路来源，通俗的理解span就是一次请求信息
    2.服务提供者
    3.服务消费者
    4.依次启动7001,8001，80
    5.访问：localhost:9411
    
### 16.3   （94） Sleuth链路监控展现

    1.修改：eureka-cloud-provider-payment8001，eureka-cloud-consumer-order80
        1.pom
            spring-cloud-starter-zipkin
        2.yml
            设置zipkin
        3.controller
            /zipkin    
    2.测试
        0.启动 zipkin：java -jar zipkin-server-2.12.9-exec.jar
        1.启动7001
        2.启动8001
        3.启动80
        4.80调用8001几次测试下：
            localhost/consumer/payment/zipkin
        5.访问localhost:9411,可在服务列表中看到注册刚才启动的服务
            搜索，查看依赖等

## 17.spring-cloud Alibaba 入门简介
### 17.1   （95） cloud alibaba简介
    
    1.为什么会出现springcloud alibaba？
        1.主要因为Cloud Netflix项目进入了维护模式
            https://spring.io/blog/2018/12/12/spring-cloud-greenwich-rc1-available-now
                Spring Cloud Netflix Projects Entering Maintenance Mode 【springcloud进入了维护模式】，
                维护模式：不会向模块添加新功能，将修复block级别的bug和安全问题，也会考虑并审查社区小型的pull request
                打算支持这些模块，直到greenwich版本被普遍采用至少一年
        2.cloud alibaba已经整合进springcloud
    2.带来了什么？
        1.官网：https://github.com/alibaba/spring-cloud-alibaba/blob/master/README-zh.md
        2.诞生：2018.10.31 SpringCloud Alibaba正式入驻了SpringCloud官方孵化器，并在maven中央仓库发布了第一个版本
        3.作用：
            1.服务限流降级：默认支持servlet，Feign，RestTemplate，Dubbo和RocketMQ限流降级功能的接入，可以在运行时通过控制台实时修改限流降级规则，还支持查看限流降级Metrics监控
            2.服务注册与发现：适配springcloud服务注册与发现标准，默认集成了ribbon的支持
            3.分布式配置管理：支持分布式配置中的外部化配置，配置更改时自动刷新
            4.消息驱动能力：基于 Spring Cloud Stream为微服务应用构建消息驱动能力
            5.阿里云对象存储：阿里云提供的海量安全，低成本，高可靠的云储存服务。支持在任何应用任何时间任何地点存储和访问任意类型的数据
            6.分布式任务调度：提供秒级，精准，高可靠，高可用的定时任务调度服务（基于cron表达式）。同时提供分布式的任务执行模型，如网格任务。网格任务支持海量子任务均匀分配到所有worker
                （schedulerx-client）上执行
            7.几乎可以替换掉 Spring Cloud netfilx
        4.主要内容：
            1.Sentinel：阿里巴巴开源产品，把流量作为切入点，从流量控制，熔断降级，系统负载保护等多个维度保护服务的稳定性
            2.Nacos：一个更易于构建云原生应用的动态服务发现，配置管理和服务管理平台
            3.RocketMQ：基于java的高性能，高吞吐量的分布式消息和流计算平台
            4.Dubbo：高性能的java RPC框架
            5.Seata：一个易于使用的高性能微服务分布式事务解决方案
            6.alibaba Cloud OSS：阿里云对象存储服务（Object Storage Service,简称OSS），是阿里云提供的海量安全，低成本高可用的云存储服务，您可以在任何应用任何时间，任何地点存储和访问任意类型的数据
            7.alibaba Cloud SchedulerX：阿里中间件团队开发的一款分布式任务调度产品，支持周期性任务与固定时间点触发任务
    3.cloud 阿里巴巴学习资料获取？
        
## 18.spring-cloud Alibaba Nacos 服务注册和配置中心
### 18.1   （96）  Nacos简介和下载

    1.Nacos由来：前四个字母分别来自于Naming 和 Configuration的前两个字母，最后一个来自于Service 的 s
    2.是什么？
        ·一个更易于构建云原生应用的动态服务发现，配置管理和服务管理平台
        ·Nacos：Dynamic Naming and Configuration Service
        ·Nacos就是注册中心 + 配置中心的组合
            Nacos =  Eureka + Config + Bus
    3.作用：
        替代eureka做注册中心
        替代Config做配置中心
    4.官网：
        https://github.com/alibaba/nacos
        https://nacos.io/zh-cn/
    5.本次选用版本 1.1.4
    6.各注册中心比较
        注册中心    CAP模型 控制台管理 社区活跃度
        eureka      AP      支持      低（2.X版本闭源）
        zookeeper   CP      不支持    中
        consul      CP      支持      高
        nacos       AP      支持      高
        据说nacos在阿里巴巴内部有超过10w的实例运行，已经过了类似于双11等各种大型流量的考研
        
### 18.2   （97）  Nacos安装
    
    1.预环境：java8+maven
    2.下载nacos：去github-release-tag：
        https://github.com/alibaba/nacos/releases/download/1.1.4/nacos-server-1.1.4.zip 【windows版本】
    3.解压安装包，运行bin目录下 startup.cmd
    4.运行成功后访问：localhost:8848/nacos
        默认账号密码：nacos nacos
    
### 18.3   （98）  Nacos之服务提供者注册
    
    1.官网：https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/en-us/index.html
        1. Introduction
        2. Dependency Management
        3. Spring Cloud Alibaba Nacos Discovery
        4. Spring Cloud Alibaba Nacos Config
        5. Spring Cloud Alibaba Sentinel
        6. Spring Cloud Alibaba Dubbo
        7. Spring Cloud Alibaba RocketMQ Binder
        8. Spring Cloud Alibaba Cloud ANS
        9. Spring Cloud Alibaba Cloud ACM
        10. Spring Cloud Alibaba Cloud OSS
        11. Spring Cloud Alibaba Cloud SchedulerX
        12. Spring Cloud Alibaba Cloud SMS
    2.新建Module：nacos-alibaba-provider-payment9001
        1.父pom：
            spring-cloud-alibaba-dependencies 2.1.0.RELASE
        2.子pom：
            spring-cloud-starter-alibaba-nacos-discovery
        3.yml
        4.主启动：@EnableDiscoveryClient
        5.controller
    3.测试：
        1.启动nacos
        2.启动9001
        3.访问：localhost:9001/payment/nacos/1
        4.登录nacos：localhost:8848/nacos
            在服务列表中可以查看注册进去的微服务
    4.参考9001新建9002
        实际情况下，端口配置需要灵活，不需要再新建module，需要指定外部参数 -Dserver.port=9011 来多次启动同一个项目【idea调试见图】
    
### 18.4   （99）  Nacos之服务消费者注册和负载

    1.新建module：nacos-alibaba-consumer-order83  -> 自带负载均衡
        可从依赖中看到，nacos集成了ribbon
    2.测试：
        启动nacos，9001,9002,83
        访问：
            http://localhost:83/consumer/payment/nacos/1   
            9001和9002交替出现，说明已经做了负载均衡
    
### 18.5   （100） Nacos服务注册中心对比提升
    
    1.Nacos的CAP理论：
        虽然不能同时支持CAP，但是支持Cp或者AP，即可以切换【见图】
    2.AP与CP切换
        C是数据强一致性：所有节点在同一时间看到的数据是一致的，而A（能用）的定义是所有的请求都会收到响应
    3.AP与CP的选择
        一般而言
        不需要存储服务级别的信息，且服务实例是通过nacos-client注册的，并能保持心跳上报，那么就可以选择AP模式，当前主流的服务如，SpringCLoud和Dubbo服务，都适用于AP模式
        AP模式为了服务的可用性而减弱了一致性，因此AP 模式下只支持注册临时实例
        如果需要在服务级别编辑或者存储配置信息，那么cp是必须的，K8s服务和dns服务只适用于CP模式
        CP模式下则支持注册持久化实例，此时则以Raft协议为集群运行模式，该模式下注册实例之前必须先注册服务，如果服务不存在，则会返回错误
        切换命令：curl -X PUT '$Nacos_server:8848/nacos/v1/ns/operator/switches?entry=serverMode&value=CP'
        
### 18.6   （101） Nacos之服务配置中心

    1.nacos作为配置中心的基础配置：
        1.新建 nacos-alibaba-config-client3377
            1.pom: spring-cloud-starter-alibaba-nacos-config
            2.yml: 两个
                Nacos同Cloud Config一样，在项目初始化时，要保证先从配置中心进行配置拉取，拉去配置后才能保证项目的正常启动
                SpringBoot中配置文件的加载是有优先级的，bootstrap高于application
            3.主启动
            4.controller：@RefreshScope //支持Nacos的动态刷新功能。    
        2.在nacos中添加配置信息：nacos中的匹配规则
            1.理论：nacos中的dataid的组成格式及与springboot配置文件中的匹配规则
            2.官网：https://nacos.io/zh-cn/docs/quick-start-spring-cloud.html
                在 Nacos Spring Cloud 中，dataId 的完整格式如下：
                ${prefix}-${spring.profiles.active}.${file-extension}
                prefix 默认为 spring.application.name 的值，也可以通过配置项 spring.cloud.nacos.config.prefix来配置。
                spring.profiles.active 即为当前环境对应的 profile，详情可以参考 Spring Boot文档。 注意：当 spring.profiles.active 为空时，对应的连接符 - 也将不存在，dataId 的拼接格式变成 ${prefix}.${file-extension}
                file-exetension 为配置内容的数据格式，可以通过配置项 spring.cloud.nacos.config.file-extension 来配置。目前只支持 properties 和 yaml 类型。
                通过 Spring Cloud 原生注解 @RefreshScope 实现配置自动更新： 
            3.访问localhost:8848,在配置列表中新增文件（最右边的加号）：
                dataid:nacos-config-client-dev.yaml 【后缀必须是yaml】
                group: - [后面讲解]
                配置格式：YAML
                内容：
                    config: 
                        info: "config info for dev,from nacos config center"
        3.测试：
            1.nacos客户端新建配置信息
            2.运行3377
            3.访问查看配置信息：localhost:3377/config/info
                config info for dev,from nacos config center
            4.自带动态刷新：
                修改下nacos中yaml中的配置信息，再次调用查看配置的接口，就会发现配置已刷新
                    config:
                        info: "config info for dev,from nacos config center version=1"
                访问查看配置信息：localhost:3377/config/info
                    config info for dev,from nacos config center version=1     
                           
### 18.7   （102） Nacos之命名空间分组和DataID三者关系
    
    1.nacos作为配置中心的分类配置：高级部分
        问题1：
            实际开发中会区分，dev,test,prod多种环境
            如何保证指定环境启动时能正确读到nacos上相应环境的配置文件
        问题2：
            一个大型分布式微服务系统会有很多微服务子项目，每个微服务项目又都会有相应的开发环境，测试环境，预发环境，正式环境...
            怎么对这些微服务配置进行管理？
    2.命名空间分组和DataID三者关系?namspace + group + dataid
        1.是什么？
            类似java里面的package+类名
            最外层的namespace是可以用于区分部署环境的，Group和DataId逻辑上区分两个目标对象
        2.三者情况？【见图】
        3.默认情况：
            namespace = public
            group = default_group
            默认cluster是default
        4.nacos默认的命名空间是public，namespace主要用来实现隔离
            例如，现在有三个环境，开发，测试，生产，就创建三个namespace，不同的namespace之间是相互隔离的
        5.group：把不同的微服务划分到同一个分组里
        6.service：就是微服务，一个service包含多个cluster集群，nacos默认cluster是default，cluster是对指定微服务的一个虚拟划分，比方说为了容灾，将service微服务分别部署在了杭州机房和
            广州机房，这时就可以给杭州机房的service微服务起一个集群名称（HZ），给广州机房的service微服务起一个集群名称GZ，还可以尽量让同一个机房的微服务互相调用，以提升性能
    
### 18.8   （103） Nacos之DataID配置
    
    三种方案加载配置
        1.DataID方案
            1.指定spring.profile.active和配置文件的DataID来使不同环境下读取不同的配置
            2.默认空间+默认分组+新建dev和test两个DataID
                1.新建dev的dataID  nacos-config-client-dev.yaml
                    config:
                        info: "config info for dev,from nacos config center nacos-config-client-dev.yaml version=1"
                2.新建test的dataID nacos-config-client-test.yaml
                    config:
                        info: "config info for dev,from nacos config center nacos-config-client-test.yaml version=2"
            3.通过spring.profile.active属性就能进行多环境下配置文件的读取
            4.测试: http://localhost:3377/config/info
        2.group方案
        3.namespace方案
    
### 18.9   （104） Nacos之Group分组方案
    
    1.nacos客户端新建 dev:info
        DataId: nacos-config-client-info.yaml
        Group:  DEV_GROUP
        配置格式：yaml
        内容：
            config:
                info: "nacos-config-client-info.yaml;DEV_GROUP"
    2.nacos客户端新建 test:info
        DataId: nacos-config-client-info.yaml
        Group:  TSET_GROUP
        配置格式：yaml
        内容：
            config:
                info: "nacos-config-client-info.yaml;TEST_GROUP"
    3.bootstrap+application:
        在config下增加一条group的配置即可，可配置为TEST_GROUP或者DEV_GROUP
        http://localhost:3377/config/info
        
### 18.10  （105） Nacos之Namespace空间方案 - 实际使用中需要掌握
    
    1.新建 dev test 的Namespace：nacos客户端点击命名空间新建，会产生流水号id 【见图】
    2.回到配置管理-配置列表查看，点击上方tab，切换到dev
        1.新建配置: namespaceID:default:dev  空间下，哪个组，哪个文件
            DataId: nacos-config-client-dev.yaml
            Group:  DEFAULT_GROUP
            配置格式：yaml
            内容：
                config:
                    info: "namespace:dev;;;;default:::dev"
        2.将1中namespace的id配置在bootstrap中
        3.修改appliacation中active为dev
    3.按照域名配置填写
    4.yml
    5.测试：http://localhost:3377/config/info
    
### 18.11  （106） Nacos之集群架构说明

    1.nacod集群和持久化配置（重要）- 一定要搭建Nacos集群
        ·官网说明：https://nacos.io/zh-cn/docs/cluster-mode-quick-start.html 
            部署生产使用的集群模式
            集群部署架构图【官网见图】【真实生产配图】
        ·Nacos持久化配置解释
        ·Linux版nacos+mysql生产环境配置
    2.说明：
        nginx集群：代表vip，避免淡定故障
        nacos集群：避免单点故障
        mysql集群：nacos中数据存储的统一位置
        默认的nacos使用的内置数据库进行存储，所以如果启动多个默认配置下的Nacos节点，数据存储是存在一致性问题的。为了解决这个问题，Nacos采用了集中存储的方式
        以支持集群化部署，目前只支持mysql的存储
    3.nacos支持三种部署模式：
        1.单机模式 - 用于测试和单机使用
        2.集群模式 - 用于生产环境，确保高可用
        3.多集群模式 - 用于多数据中心场景
    4.windows
        双击 startup.cmd
    5.单机模式支持mysql【均来自官网】
        在0.7版本之前，在单机模式时nacos使用嵌入式数据库实现数据的存储，不方便观察数据存储的基本情况。0.7版本增加了支持mysql数据源能力，具体的操作步骤：
        1.安装数据库，版本要求：5.6.5+
        2.初始化mysql数据库，数据库初始化文件：nacos-mysql.sql
        3.修改conf/application.properties文件，增加支持mysql数据源配置（目前只支持mysql），添加mysql数据源的url、用户名和密码。
              spring.datasource.platform=mysql
              db.num=1
              db.url.0=jdbc:mysql://11.162.196.16:3306/nacos_devtest?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
              db.user=nacos_devtest
              db.password=youdontknow
        4.再以单机模式启动nacos，nacos所有写嵌入式数据库的数据都写到了mysql
        
### 18.12  （107） Nacos之持久化切换配置

    1.Nacos持久化配置解释：
        1.Nacos默认自带的是嵌入式数据库derby：https://github.com/alibaba/nacos/blob/develop/config/pom.xml
             <dependency>
                 <groupId>org.apache.derby</groupId>
                 <artifactId>derby</artifactId>
             </dependency>
        2.derby到mysql切换配置步骤
            ·nacos-server-1.1.4/nacos/conf 目录下找到sql脚本
                nacos-mysql.sql
                找到要使用的mysql去执行以上脚本
            ·nacos-server-1.1.4/nacos/conf 目录下找到 application.properties
                spring.datasource.platform=mysql
                db.num=1
                db.url.0=jdbc:mysql://localhost:3306/nacos_devtest?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
                db.user=root
                db.password=root
            ·重启nacos，可以看到记录被清空了，以前的数据是被存储在了derby中
    
### 18.13  （108） Nacos之linux版本安装
    
    1.linux版Nacos+mysql生产环境配置
        1.预计需要，1个nginx+3个nacos注册中心+1个mysql 【至少3个nacos才能做集群-见官网】
        2.nacos下载linux版本：
            https://github.com/alibaba/nacos/releases/download/1.1.4/nacos-server-1.1.4.tar.gz
            解压即用
    
### 18.14  （109） Nacos之集群配置上

    1.集群配置步骤（重点）
        1.Linux服务器上mysql数据库配置
             ·nacos-server-1.1.4/nacos/conf 目录下找到sql脚本
                 nacos-mysql.sql
                 找到要使用的mysql去执行以上脚本
        2.application.properties配置
             ·nacos-server-1.1.4/nacos/conf 目录下找到 application.properties 【先备份，在修改】
                 spring.datasource.platform=mysql
                 db.num=1
                 db.url.0=jdbc:mysql://localhost:3306/nacos_devtest?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
                 db.user=root
                 db.password=root
        3.linux服务器上nacos集群配置cluster.conf
            1.梳理出3台nacos集群的不同服务端口号
            2.复制出cluster.conf 
                cp cluster.conf.example cluster.conf
            3.内容 
                vim cluster.conf  【ip不能为127.0.0.1，必须为linux命令 hostname -i  能够识别的ip，centos中使用hostname -i 命令可以查询出ip】
                    192.168.0.191:3333
                    192.168.0.191:4444
                    192.168.0.191:5555
        4.编辑nacos的启动脚本startup.sh，使他能够接收不同的启动端口
            1./nacos/bin 目录下 startup.sh
            2.怎么修改startup.sh
            3.要求命令： ./startup.sh -p 3333   表示启动端口号为3333的nacos服务器实例
            4.修改 startup.sh
                修改前：
                    while getopts ": m: f: s:" opt
                    do 
                        case $opt in
                            m) 
                                MODE=$OPTARG;;
                            f)
                                FUNCTION_MODE=$OPTARG;;
                            s)
                                SERVER=$OPTARG;;
                            ?)
                            echo "Unknown parameter"
                            exit 1;;
                        esac
                    done
                    ...
                    nohup $JAVA ${JAVA_OPT} nacos.nacos >>${BASE_DIR}/logs/start.out 2>&1 &
                修改后：
                    while getopts ": m: f: s: p:" opt
                    do 
                        case $opt in
                            m) 
                                MODE=$OPTARG;;
                            f)
                                FUNCTION_MODE=$OPTARG;;
                            s)
                                SERVER=$OPTARG;;
                            p)
                                PORT=$OPTARG;;
                            ?)
                            echo "Unknown parameter"
                            exit 1;;
                        esac
                    done
                    ...
                    nohup $JAVA -Dserver.port=${PORT} ${JAVA_OPT} nacos.nacos >>${BASE_DIR}/logs/start.out 2>&1 &
            5.执行命令：
                ./startup.sh -p 3333 
                ./startup.sh -p 4444 
                ./startup.sh -p 5555 
        5.nginx的配置，由他作为负载均衡器
            1.修改nginx的配置文件
            2.nginx.conf
                upstream cluster{
                    server 127.0.0.1:3333;
                    server 127.0.0.1:4444;
                    server 127.0.0.1:5555;
                }
                server {
                    listen 1111
                    server_name localhost;
                    location / {
                        proxy_pass http://cluster
                    }
                }
            3.按照指定启动
                ./nginx -c /usr/local/nginx/conf/nginx.conf
        6.截止到此处：1个nginx+3个nacos+1个mysql
            1.测试通过nginx访问nacos ： 127.0.0.1:1111/nacos/#/login
            2.登录nacos后新建一个配置测试，mysql中加入了相应的记录
    4.测试
        微服务nacos-alibaba-provider-payment9002 注册进nacos集群：
            修改yml中的 nacos地址为 127.0.0.1:1111
    5.总结【见图】

### 18.15  （110） Nacos之集群配置下

    总结【见图】

## 19.spring-cloud Alibaba Sentinel实现熔断与限流
### 19.1   （111） Sentinel是什么

    1.中文官网：https://github.com/alibaba/Sentinel/wiki/%E4%BB%8B%E7%BB%8D
    2.Hystrix与Sentinel比较
        Hystrix：
            1.需要自己手动搭建平台
            2.没有一套web界面可以给我们进行更细粒度化的配置
                流量控制，速率控制，服务熔断，服务降级
        Sentinel：-哨兵
            1.单独一个可独立的组件
            2.直接界面化的细粒度统一配置
    
### 19.2   （112） Sentinel下载安装运行
    
    1.下载地址：https://github.com/alibaba/Sentinel/releases/download/1.7.0/sentinel-dashboard-1.7.0.jar
    2.springcloud集成sentinel文档：https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/en-us/index.html#_spring_cloud_alibaba_sentinel
    3.安装sentinel控制台：
        1.sentinel组件由两部分构成
            1.后台
            2.前台8080
        2.安装步骤 
            1.下载地址：https://github.com/alibaba/Sentinel/releases/download/1.7.0/sentinel-dashboard-1.7.0.jar
            2.前提：java8环境且8080端口不能被占用
                java -jar sentinel-dashboard-1.7.0.jar
            3.访问web：localhost:8080
                username：sentinel
                password：sentinel
    4.sentinel分为两部分
        1.核心库（java客户端），不依赖任何框架/库，能够运行于所有java运行时环境，同时对dubbo，springcloud等框架也有很好的支持
        2.控制台（Dashboard），基于springboot开发，打包后可以直接运行，不需要额外的tomcat等应用
    
### 19.3   （113） Sentinel初始化监控
    
    1.初始化演示工程
        1.启动nacos 8848
        2.新建module8401：sentinel-alibaba-service8401
            pom
        3.启动sentinel客户端 8080
        4.启动微服务8401
        5.启动8401后查看sentinel控制台
            1.内容为空
            2.sentinel采用懒加载说明：
                执行一次访问即可：localhost:8401/testA
                执行一次访问即可：localhost:8401/testB
            3.刷新8080可见
    
### 19.4   （114） Sentinel流控规则简介
    
    1.新增流控规则 - 基本介绍
        资源名：唯一名称，默认请求路径
        针对来源：Sentinel可以针对调用者进行限流，填写微服务名，默认default，不区分来源
        阈值类型
            ·QPS     :每秒钟的请求数量,当调用该api的qps达到阈值的时候，进行限流    
            ·线程数  :当调用该api的线程数达到阈值的时候，进行限流
            ·单机阈值：
        是否集群：不需要集群
        流控模式
            ·直接：api达到限流条件时，直接限流    
            ·关联：当关联的资源达到阈值时，就限流自己
            ·链路：只记录指定链路上的流量，指定资源从入口资源进来的流量，如果达到阈值，就会进行限流【api级别的针对来源】
        ·流控效果
            ·快速失败：直接失败，抛异常
            ·Warm Up ：根据codeFactor（冷加载因子，默认3）的值，从阈值/codeFactor,经过预热时长才达到设置的qps阈值
            ·排队等待：均匀排队，让请求以匀速的速度通过，阈值类型必须设置为QPS，否则无效
    
### 19.5   （115） Sentinel流控-QPS直接失败
    
    1.直接-qps-快速失败【见图】
        测试：
            0.表示1秒查询一次ok，多于1次限流报错
            1.快速访问：localhost:8401/testA
            2.结果：Blocked by Sentinel（flow limiting）
            3.问题：直接调用的默认报错信息【Blocked by Sentinel（flow limiting）】，是否应该有自己的后续处理，是不是应该有fallback的方法
            
### 19.6   （116） Sentinel流控-线程数直接失败

    1.直接-线程数-快速失败【见图】
        在/testA 接口中添加Sleep1秒，
        测试
            0.表示1秒中只允许一个线程处理，多于一次限流报错
            1.连续点击：localhost:8401/testA，因为这个接口里面sleep1秒，所以连续点击，就会造成多个线程进入，那么将只有第一次访问正常，其余报错
            2.结果：Blocked by Sentinel（flow limiting）
    
### 19.7   （117） Sentinel流控-关联
    
    1.关联：
        1.是什么
            1.当关联的资源达到阈值的时候，限流自己
            2.当与A关联的资源B达到阈值后，就限流A自己
            3.B惹事A挂了
        2.配置A
            当关联资源/testB的qps阀值超过1时，就限流testA的rest访问地址
            例如：【支付接口要不行了，那么就将订单接口限流下】
        3.postman模拟并发密集访问testB 【见图】
        4.运行后发现testA挂了
    
### 19.8   （118） Sentinel流控-预热
    
    1.链路：多个请求调用同一个微服务
    2.流控效果
        1.直接-快速失败
            1.直接失败，抛出异常
            2.源码：com.alibaba.csp.sentinel.slots.block.flow.controller.DefaultController
        2.warm up预热
            1.说明：公式-阈值除以codeFactor（默认为3），经过预热时长后才会达到阈值
            2.官网：https://github.com/alibaba/Sentinel/wiki/%E6%B5%81%E9%87%8F%E6%8E%A7%E5%88%B6#%E5%9F%BA%E4%BA%8E%E8%B0%83%E7%94%A8%E5%85%B3%E7%B3%BB%E7%9A%84%E9%99%90%E6%B5%81
                Warm Up（RuleConstant.CONTROL_BEHAVIOR_WARM_UP）方式，即预热/冷启动方式。当系统长期处于低水位的情况下，当流量突然增加时，直接把系统拉升到高水位可能瞬间把系统压垮。
                通过"冷启动"，让通过的流量缓慢增加，在一定时间内逐渐增加到阈值上限，给冷系统一个预热的时间，避免冷系统被压垮
                默认codeFactor为3，即请求QPS从threshold/3开始，经预热时长逐渐升至设定的QPS阈值】
            3.应用场景：秒杀系统在开启的瞬间，会有很多流量上来，很可能会把系统打死，预热方式就是为了保护系统，将流量慢慢放进来，慢慢的将阀值增加到设置的阀值
        3.排队等待
    
### 19.9   （119） Sentinel流控-排队等待
    
    1.官网：https://github.com/alibaba/Sentinel/wiki/%E6%B5%81%E9%87%8F%E6%8E%A7%E5%88%B6
        匀速排队（RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER）方式会严格控制请求通过的间隔时间，也即是让请求以均匀的速度通过，对应的是漏桶算法【大厂面试第三季有过讲解】
        。详细文档可以参考 流量控制 - 匀速器模式
    2.源码：com.alibaba.csp.sentinel.slots.block.flow.controller.RateLimiterController
        一秒一个排队进入
    
### 19.10  （120） Sentinel降级简介

    1.官网：https://github.com/alibaba/Sentinel/wiki/%E7%86%94%E6%96%AD%E9%99%8D%E7%BA%A7
    2.基本介绍：
        新增降级规则：
            资源名
            降级策略 
                ·RT
                ·异常比例
                ·异常数
            RT：平均响应时间，秒级，超出阈值且在时间窗口内通过的请求>=5,两个条件同时满足后触发降级，窗口期过后，关闭断路器，RT最大为4900（更大的需要通过-Dcsp.sentinel.statistic.max.rt=XXX才能生效）
            时间窗口：-
        1.RT：平均响应时间，秒级，超出阈值且在时间窗口内通过的请求>=5,两个条件同时满足后触发降级，窗口期过后，关闭断路器，RT最大为4900（更大的需要通过-Dcsp.sentinel.statistic.max.rt=XXX才能生效）
        2.异常比例：秒级，QPS>=5且异常比例（秒级统计）超过阈值时，触发降级；时间窗口结束后，关闭降级
        3.异常数：分钟级，异常数（分钟统计）超过阈值时，触发降级，时间窗口结束后，关闭降级
    3.进一步说明：
        1.Sentinel熔断降级会在调用链路中某个资源出现不稳定状态时（例如调用超时，或异常比例升高），对这个资源的调用进行限制，让请求快速失败，避免影响到其他资源而导致级联错误
            当资源被降级后，在接下来的降级时间窗口之内，对该资源的调用都自动熔断，（默认行为是抛出DegradeException）    
        2.Sentinel的断路器没有半开状态，要么熔断，要么正常，没有监测
            半开的状态-系统自动去检测是否请求有异常，没有异常就关闭断路器恢复使用，有异常，则继续打开断路器不可用，具体参考Hystrix
        3.最新的sentinel是有半开状态的【重要重要重要重要重要重要重要重要重要重要重要重要】
            Sentinel 提供以下几种熔断策略：
            慢调用比例 (SLOW_REQUEST_RATIO)：选择以慢调用比例作为阈值，需要设置允许的慢调用 RT（即最大的响应时间），请求的响应时间大于该值则统计为慢调用。当单位统计时长（statIntervalMs）
                内请求数目大于设置的最小请求数目，并且慢调用的比例大于阈值，则接下来的熔断时长内请求会自动被熔断。经过熔断时长后熔断器会进入探测恢复状态（HALF-OPEN 状态），若接下来的一个请求响应时间小于设置的慢调用 RT 则结束熔断，若大于设置的慢调用 RT 则会再次被熔断。
            异常比例 (ERROR_RATIO)：当单位统计时长（statIntervalMs）内请求数目大于设置的最小请求数目，并且异常的比例大于阈值，则接下来的熔断时长内请求会自动被熔断。
                经过熔断时长后熔断器会进入探测恢复状态（HALF-OPEN 状态），若接下来的一个请求成功完成（没有错误）则结束熔断，否则会再次被熔断。异常比率的阈值范围是 [0.0, 1.0]，代表 0% - 100%。
            异常数 (ERROR_COUNT)：当单位统计时长内的异常数目超过阈值之后会自动进行熔断。经过熔断时长后熔断器会进入探测恢复状态（HALF-OPEN 状态），若接下来的一个请求成功完成（没有错误）
                则结束熔断，否则会再次被熔断。
            
### 19.11  （121） Sentinel降级-RT
    
    1.RT：平均响应时间，秒级，超出阈值且在时间窗口内通过的请求>=5,两个条件同时满足后触发降级，窗口期过后，关闭断路器，RT最大为4900（更大的需要通过-Dcsp.sentinel.statistic.max.rt=XXX才能生效）
        1.1秒钟持续进入5个请求，平均响应时间大于阈值
        2.触发降级-断路器打开
        3.时间窗口结束
        4.关闭降级，继续使用
    2.测试：
        1.代码：    @GetMapping("/testD")
        2.配置降级： 
            资源名：/testD
            降级策略：RT
            RT：200
            时间窗口：1
            表示：200ms内需要返回响应，若是超过两秒，那么在之后的1秒钟里，就会开启断路由，以保护系统，在1秒后恢复系统
        3.jmeter压测：见图
    
### 19.12  （122） Sentinel降级-异常比例
    
    1.  旧的：异常比例 (ERROR_RATIO)：当单位统计时长（statIntervalMs）内请求数目大于设置的最小请求数目，并且异常的比例大于阈值，则接下来的熔断时长内请求会自动被熔断。
            时间窗口后，恢复访问
        新的：异常比例 (ERROR_RATIO)：当单位统计时长（statIntervalMs）内请求数目大于设置的最小请求数目，并且异常的比例大于阈值，则接下来的熔断时长内请求会自动被熔断。
            经过熔断时长后熔断器会进入探测恢复状态（HALF-OPEN 状态），若接下来的一个请求成功完成（没有错误）则结束熔断，否则会再次被熔断。异常比率的阈值范围是 [0.0, 1.0]，代表 0% - 100%。
        以下是以旧的解释：
            1.QPS>5 && 异常比例（秒级统计）超过阈值
            2.触发降级-断路器打开
            3.时间窗口结束
            4.关闭降级
    2.测试：
        1.代码：    @GetMapping("/testD")
        2.配置降级： 
            资源名：/testD
            降级策略：异常比例
            异常比例：0.2  【即要求80%是正确的】
            时间窗口：1 【1秒以内直接返回错误】
            表示：     
        3.jmeter压测：见图        
    
### 19.13  （123） Sentinel降级-异常数
    
    1.最新的：异常数 (ERROR_COUNT)：当单位统计时长内的异常数目超过阈值之后会自动进行熔断。经过熔断时长后熔断器会进入探测恢复状态（HALF-OPEN 状态）
        ，若接下来的一个请求成功完成（没有错误）则结束熔断，否则会再次被熔断。
      旧的：
        当资源近1分钟的异常数目超过阈值之后会进行熔断。注意由于统计时间窗口是分钟级别的，若timeWindow小于60s，则结束熔断状态后仍可能再进入熔断状态
        所以时间窗口一定要大于等于60s
    2.测试：
        
### 19.14  （124） Sentinel热点key 上
    
    1.热点参数限流会统计传入参数中的热点参数，并根据配置的限流阈值与模式，对包含热点参数的资源调用进行限流。热点参数限流可以看做是一种特殊的流量控制，仅对包含热点参数的资源调用生效。
    2.从HystrixCommand到@SentinelResource
        默认兜底方法，自定义兜底方法
    3.代码：    @GetMapping("/testHotKey")
        com.alibaba.csp.sentinel.slots.block.BlockException
    
### 19.15  （125） Sentinel热点key 下    
    
    1.参数例外项
        上述案例演示了第一个参数p1，当QPS超过1秒一次点击后马上被限流
    2.特例情况
        普通：超过1秒钟1个后马上限流
        特殊：期望p1参数是某个特殊值的时候，他的限流值和平时要不一样
        特例：例如当p1的值等于5的时候，他的阈值可以达到200，等同于对p1参数的过滤，更加特殊化 ，这就是某个参数-具体值的例外项
    3.配置：
        头部：
            参数索引 0
            单机阈值 1
            统计窗口时长 1
        参数例外项：
            参数类型：java.leng.String
            参数值 5
            限流阈值 200
    4.测试
        localhost:8401/testHotKey?p1=5  ps=5时作为参数例外项，阈值变为200
        localhost:8401/testHotKey?p1=3  ps!=5时公有配置，阈值变为1
    5.前提条件
        热点参数的注意点：参数类型必须是8种基本类型或者String
     //sentinel只管的是流控的错误，而非代码的错误，因此此处报错并不会进入方法deal_testHotKey
     
### 19.16  （126） Sentinel系统规则 - 不建议使用，总入口
    
    1.【系统自适应限流】官网：https://github.com/alibaba/Sentinel/wiki/%E7%B3%BB%E7%BB%9F%E8%87%AA%E9%80%82%E5%BA%94%E9%99%90%E6%B5%81
        Sentinel 系统自适应限流从整体维度对应用入口流量进行控制，结合应用的 Load、CPU 使用率、总体平均 RT、入口 QPS 和并发线程数等几个维度的监控指标，通过自适应的流控策略，
        让系统的入口流量和系统的负载达到一个平衡，让系统尽可能跑在最大吞吐量的同时保证系统整体的稳定性。
    2.五个模式-系统规则支持以下的模式：
        1.Load 自适应（仅对 Linux/Unix-like 机器生效）：系统的 load1 作为启发指标，进行自适应系统保护。当系统 load1 超过设定的启发值，
            且系统当前的并发线程数超过估算的系统容量时才会触发系统保护（BBR 阶段）。系统容量由系统的 maxQps * minRt 估算得出。设定参考值一般是 CPU cores * 2.5。
        2.CPU usage（1.5.0+ 版本）：当系统 CPU 使用率超过阈值即触发系统保护（取值范围 0.0-1.0），比较灵敏。
        3.平均 RT：当单台机器上所有入口流量的平均 RT 达到阈值即触发系统保护，单位是毫秒。
        4.并发线程数：当单台机器上所有入口流量的并发线程数达到阈值即触发系统保护。
        5.入口 QPS：当单台机器上所有入口流量的 QPS 达到阈值即触发系统保护。
    3.使用比较危险
        
### 19.17  （127） SentinelResource配置上
    
    1.按资源名称限流+后续处理
        1.启动nacos成功
        2.启动sentinel成功
        3.module
            1.修改8401
            2.pom：cloud-api-commons
            3.新加业务类：RateLimitController
        4.配置流控规则
            1.新增流控规则：
                资源名 byResource 【这个名称对应controller中的 @SentinelResource(value = "byResource",blockHandler = "handleException")的value的值】
                阈值类型 QPS 
                单机阈值 1
        5.测试
            先访问下 localhost:8401/byResource  将此资源加载到sentinel中
            登录sentinel添加流控规则
            一秒钟点击一下localhost:8401/byResource ok
            频繁点击localhost:8401/byResource 则返回自定义的限流处理信息 
                {"code":"444","message":"com.alibaba.csp.sentinel.slots.block.flow.FlowException\t 服务不可用","data":null}
        6.额外问题
            1.此时关闭服务8401，在访问sentinel会发现，流控规则丢失，说明基于服务配置的流控规则是不会持久化的，服务停止则丢失
    2.按照url地址限流+后续处理
        1.通过访问的url来限流，会返回Sentinel自带默认的限流处理信息
        2.业务类RateLimitController
        3.访问一次
        4.Sentinel控制台配置
            新增流控规则
                资源名 /rateLimit/byUrl
                阈值类型 QPS 
                单机阈值 1
        5.测试
            频繁点击 localhost:8401/rateLimit/byUrl
            返回自带的处理信息：Blocked by Sentinel （Flow Limiting）
        6.结论：
            Sentinel中流控配置中的资源名可以是
                    @GetMapping("/rateLimit/byUrl")
                    @SentinelResource(value = "byUrl")
            中的@GetMapping的值，也可以是@SentinelResource(value的值，都可行，且若
                @SentinelResource(value = "byResource",blockHandler = "handleException")
            blockHandler未申明时，取默认、、sentinel默认返回值 Blocked by Sentinel （Flow Limiting）
    3.上面兜底方案面临的问题 - blockHandler = "handleException"
        1.同Hystrix的问题相同：
            1.系统默认的没有体现出自己的要求
            2.使用blockHandler = "handleException"会和controller代码耦合在一起，不直观
            3.每个业务方法都添加一个兜底的，导致代码膨胀加剧
            4.全局统一的处理方法没有体现
    4.客户自定义限流处理逻辑
    5.更多注解属性说明
    
### 19.18  （128） SentinelResource配置中-客户自定义限流处理逻辑

    1.客户自定义限流处理逻辑
        1.创建CustomerBlockHandler类用于自定义限流处理逻辑
        2.修改RateLimitController
        3.启动微服务后先调用一次
            localhost:8401/rateLimit/customerBlockHandler
        4.Sentinel控制台配置
        5.测试后自定义的出来了
        6.进一步说明【见图】

### 19.19  （129） SentinelResource配置下
    
    1.代码级别配置-不建议
    2.Sentinel的三个核心API
        SphU-定义资源
        Tracer-定义统计
        ContextUtil-定义了上下文
    
### 19.20  （130） Sentinel服务熔断Ribbon环境预说
    
    1.服务熔断功能：
        1.sentinel整合ribbon+openFeign+fallback
        2.Ribbon系列
            1.启动nacos和Sentinel
            2.提供者9003/9004：
                1.对照9001新建9003,9004
                2.测试：
                    1.启动sentinel 8080 【单独的jar包】
                    2.启动nacos 8848 【单独的jar包】
                    3.启动9003 和 9004
                    4.访问：正常使用
                        localhost:9003/paymentSQL/1 
                        localhost:9003/paymentSQL/4
                        localhost:9004/paymentSQL/1
                        localhost:9004/paymentSQL/4
            3.消费者84：
                1.对照83新建84
            4.84业务类：
                CircleBreakerController：
                1.目的：
                    fallback只负责业务异常
                    blockHandler只负责sentinel控制台配置违规
        3.Feign系列
        4.熔断框架比较
    
### 19.21  （131） Sentinel服务熔断无配置

    1.启动sentinel 8080 【单独的jar包】
    2.启动nacos 8848 【单独的jar包】
    3.启动9003 和 9004
    4.启动84
    5.首先验证：通过84 是否会通过ribbon负载均衡，以轮询的方式 访问9003,9004
        多次访问：localhost:84/consumer/fallback/1  交替出现9003,9004，即有负载均衡的效果
        访问：localhost:84/consumer/fallback/4 会出现异常页面，对客户不友好，
        所以需要对SentinelResource配置其他参数
    
### 19.22  （132） Sentinel服务熔断只配置fallback

    1.修改84：
        @SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
    2.测试：
        访问：localhost:84/consumer/fallback/4 出现兜底方法
        {"code":444,"message":"兜底异常handlerFallback,exception内容  IllegalArgumentException,非法参数异常....","data":{"id":4,"serial":"null"}}
        等同于Hystrix的服务降级
        
### 19.23  （133） Sentinel服务熔断只配置blockHandler
    
    1.修改84：
        @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
    2.配置sentinel：
        簇点链路配置 流控降级规则后测试
        配置降级 - 异常数 - 2 - 时间窗口2s
        访问：  localhost:84/consumer/fallback/4 出现错误页面 【因为没有配置fallback，而fallback管java运行时异常】
        快速访问以上地址后，由于配置了降级规则，异常两个，所以会走进降级方法 blockHandler，出现限流降级结果
    
### 19.24  （134） Sentinel服务熔断配置fallback和blockHandler

    1.修改84：
        @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler") 
    2.配置sentinel：
        簇点链路配置 流控降级规则后测试
        配置流控 - QPS - 单机阈值1
        访问：  localhost:84/consumer/fallback/1 
        一秒一次点击正常访问，快速点击返回限流结果 【sentinel的限流方法blockHandler】
        访问：  localhost:84/consumer/fallback/4 
        一秒一次，由于是异常页面，返回【java错误：fallback = "handlerFallback"】
        快速点击返回限流结果 【sentinel的限流方法blockHandler = "blockHandler"】,此时不再返回fallback内容，因为已达到限流条件

### 19.25  （135） Sentinel服务熔断exceptionsToIgnore

    1.修改84：
        @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
                    exceptionsToIgnore = {IllegalArgumentException.class})
    2.异常忽略：假如报该异常，不再有fallback方法兜底，没有降级效果了
        localhost:84/consumer/fallback/1    正常   
        localhost:84/consumer/fallback/4    报错
        localhost:84/consumer/fallback/5    走fallback
        
### 19.26  （136） Sentinel服务熔断OpenFeign
    
    1.修改84模块
        pom:spring-cloud-starter-openfeign
        yml:激活
        启动类：@EnableFeignClients
        service：@FeignClient(value = "nacos-payment-provider")
        controller:...
    2.启动9003,84
    3.访问：
        localhost:84/consumer/paymentSQL/1
        测试84调用9003，此时故意关闭9003，看84消费侧是否自动降级，不会被耗死
    4.sentinel，hystrix，resillience4j的区别
                            sentinel                                hystrix                 resilience4j
      隔离策略       信号量隔离（并发线程数限流）                线程池隔离/信号量隔离   信号量隔离  
      熔断降级策略   基于响应时间，异常比率，异常数              基于异常比率            基于异常比率，响应时间
      实时统计实现   滑动窗口（LeapArray）                       滑动窗口（基于Rxjava）  Ring bit buffer   
      动态规则配置   支持多种数据源                              基于多种数据源          有限支持
      拓展性         多个拓展点                                  插件的形式              接口的形式
      基于注解的支持 支持                                        支持                    支持
      限流           基于QPS，支持基于调用关系的限流             有限的支持              Rate Limiter
      流量整形       支持预热模式，匀速器模式，预热排队模式      不支持                  简单的Rate Limiter模式 
      系统自适应保护 支持                                        不支持                  不支持
      控制台         提供开箱即用的控制台，可配置规则，          简单的监控查看          不提供控制台，可对接其他监控系统
                     查看秒级监控，机器发现等
        
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

