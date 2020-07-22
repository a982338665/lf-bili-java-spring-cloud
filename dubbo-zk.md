# Spring-Boot
# https://github.com/a982338665/lf-study-java-Spring-Boot.git
-----------------------------------
分布式应用系统开发是大数据时代趋势
-----------------------------------
**1.课程技术：**

    maven，jdk7,dubbo2.5.3,structs2,spring3
    mybatis3.2,Druid,activeMQ,tomcat7,mysql5.6
    vmware,CentOS6.5

    -----------------------------------
    使用dubbo对传统项目工程进行服务化改造：
    传统的单工厂项目：：---数据库连接池用的Druid
    
    -----------------------------------

**2.调用关系说明：**

    ·服务容器负责启动，加载运行服务提供者
    ·服务提供者在服务启动时，向注册中心注册自己提供的服务
    ·服务消费者在服务启动时，向注册中心订阅自己提供的服务
    ·注册中心返回服务提供者地址列表给消费者，如有变更，注册中心将基于长连接推送变更数据给消费者
    ·服务消费者从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，如失败，再选另一台
    ·服务消费者和提供者，在内存累计调用次数和调用时间，定时每分钟发送一次统计数据到监控中心

**3.软负载和硬负载F5：**

	·在一台服务器的操作系统上，安装一个附加软件来实现负载均衡，如Nginx负载均衡（我们管理系统平台使用的也是这款均衡器）。
	    它的优点是基于特定环境、配置简单、使用灵活、成本低廉，可以满足大部分的负载均衡需求。
	·直接在服务器和外部网络间安装负载均衡设备，这种设备我们通常称之为负载均衡器。由于专门的设备完成专门的任务，独立于操作系统，
	    整体性能得到大量提高，加上多样化的负载均衡策略，智能化的流量管理，可达到最佳的负载均衡需求。 一般而言，硬件负载均衡在功能、性能上优于软件方式，不过成本昂贵，比如最常见的就是F5负载均衡器。​
    —————————————————— 
**4.注册中心选择：zookeeper/redis**

    1.官网建议使用zookeeper-2.3.3以上版本的注册中心客户端
    2.zookeeper时apache hadoop的子项目，轻度相对较好，建议生产环境使用该注册中心
    3.dubbo未对zookeeper服务器端做任何侵入修改，只需在原生zookeeper服务器即可，
        所有注册中心逻辑适配都在调用zookeeper客户端时候完成
    ——————————————————

**5.安装zookeeper-3.4.6：**
    
    ·注册中心服务器：192.168.6.128
    1.修改操作系统的 /etc/hosts文件中添加：
        su root
        vi  /etc/hosts:
        #zookeeper server
        192.168.6.128 provider-01
        
        esc+:wq
    2.下载：
        cd /home/admin/
        wget http://apache.fayea.com/zookeeper/zookeeper-3.4.10/zookeeper-3.4.10.tar.gz
    3.解压：tar -zxvf zookeeper-3.4.10.tar.gz
    4.cd /home/admin/zookeeper-3.4.10
    5.创建目录
        # mkdir data 
        # mkdir logs
    6.文件拷贝：
        # cd conf
        # cp zoo_sample.cfg  zoo.cfg
    7.修改新增：vim zoo.cfg
    # The number of milliseconds of each tick
    #—————————————
    tickTime=2000 
    # The number of ticks that the initial
    # synchronization phase can take
    #—————————————
    initLimit=10
    #此配置是用来配置zookeeper接受客户端初始化连接时最长能忍受多少个心跳时间间隔数
    #此处的客户端：非用户连接zookeeper服务器的客户端，而是zookeeper服务器集群中连接到leader的follow服务器
    #当已经超过10个的心跳时间(即tickTIme)长度后，zookeeper服务器还没有收到客户端的返回消息
    #那表明这个客户端连接失败，总的时间长度就为5*2000=10秒
    # The number of ticks that can pass between
    # sending a request and getting an acknowledgement
    #——————————————
    #这个配置项标识leader与follower之间发送消息，请求和响应时间长度，最长不能超过多少个tickTime的时间长度
    #总的时间长度就是2*2000=4秒（之所以乘以2是因为请求和响应各一次）
    
    syncLimit=5
    # the directory where the snapshot is stored.
    # do not use /tmp for storage, /tmp here is just
    # example sakes.
    # ---------------------------
    dataDir=/home/admin/zookeeper-3.4.10/data
    dataLogDir=/home/admin/zookeeper-3.4.10/logs
    # ---------------------------
    # the port at which the clients will connect
    # ---------------------------
    # 2181通过此端口进行通讯
    clientPort=2181 
    server.1=provider-01:2888:3888
    # 2888是zookeeper服务之间的通信端口(集群时会用到)，3888是zookeeper与其他应用程序通讯的端口
    # ---------------------------
    # the maximum number of client connections.
    # increase this if you need to handle more clients
    #maxClientCnxns=60
    #
    # Be sure to read the maintenance section of the
    # administrator guide before turning on autopurge.
    #
    # http://zookeeper.apache.org/doc/current/zookeeperAdmin.html#sc_maintenance
    #
    # The number of snapshots to retain in dataDir
    #autopurge.snapRetainCount=3
    # Purge task interval in hours
    # Set to "0" to disable auto purge feature
    #autopurge.purgeInterval=1

**8.在dataDir=/home/admin/zookeeper-3.4.10/data下创建myid文件并编辑**

	# mkdir myid
	# vi myid    创建并编辑myid文件命令
	在对应的ip的机器上输入对应的编号，
	如在zookeeper上，myid文件内容就是1
	如在单点上进行安装配置，那么只有一个server.1
	此处输入1，即可

**9.admin用户下修改文件增加zookeeper配置(配置环境变量)**

	# vi /home/admin/.bash_profile
	export ZOOKEEPER_HOME=/home/admin/zookeeper-3.4.10
	export Path=$ZOOKEEPER_HOME/bin:$PATH
	# source .bash_profile  使配置文件生效
	
**10.防火墙打开要用到的端口：2181,2888,3888**
	
	# su root
	# chkconfig iptables on 
	# service iptables start
	# vi /etc/sysconfig/iptables
	-A INPUT -m state --state NEW -m tcp -p tcp --dport 2181  -j 	ACCEPT
	-A INPUT -m state --state NEW -m tcp -p tcp --dport 2888  -j 	ACCEPT
	-A INPUT -m state --state NEW -m tcp -p tcp --dport 3888  -j 	ACCEPT
	# service iptables restart
	# service iptables status
**11.启动并测试zookeeper（使用admin用户而不是root）**

	# exit 退出root用户
	# pwd  查看当前路径
	# cd /home/admin/zookeeper-3.4.10/bin
	#/
	# jps --查看进程
		1456 QuorumPeerMain  --zookeeper进程
		1475 Jps
	# zkServer.sh status  --
	# zkServer.sh stop  --停止
	# ps -ef |grep java --查看进程
**12.配置zookeeper开机自启：**

	# vi /etc/rc.local	
	su - admin -c '/home/admin/zookeeper-3.4.10/bin/zkServer.sh start'

**13.安装dubbo-admin：**

    1.下载地址; https://github.com/alibaba/dubbo
    2.直接去下载他们打包好的源代码吧：https://github.com/alibaba/dubbo/releases
    3.wget https://github.com/apache/incubator-dubbo/archive/2.5.x.zip

    3.解压后，根目录里存在dubbo-admin，进入 mvn install -Dmaven.test.skip=true 安装完后，生成target目录，进入这个目录，
      找到dubbo-admin-2.6.0.war，把这个war包copy到tomcat的目录webapps下的ROOT下面（删除tomcat webapps目录下ROOT原有内容），
      然后使用jar xvf dubbo-admin-2.6.0.war解压war包，把解压后的内容全部放到ROOT目录下

    4.启动tomcat，就可以看到dubbo-admin的界面，默认帐号密码root/root
      在目录/home/admin/apache-tomcat-8.5.24/webapps/ROOT/WEB-INF下的配置dubbo.properties，修改帐号密码，以及注册信息




































