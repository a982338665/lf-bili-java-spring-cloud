>参考地址;https://www.jianshu.com/p/3d9b8b7bf586

# 1. maven版本详解

    例: AA.BB.CC-SNAPSHOT
    [主版本号] AA表示大版本号,不与之前的版本号兼容。
    [副版本号] BB表示中版本号，一般代表功能增加。
    [修复版本号] CC表示小版本号，一般代表修复bug。
    [版本状态] 的可选值有：SNAPSHOT、RELEASE
    
# 2. Snapshot和Release版本的区别和作用
## 2.1 为什么需要snapshot版本？

    实际场景：(如果没有snapshot)
    开发中 多个模块项目并行开发，各个模块大量更新,如果模块间存在项目依赖的情况,那么应该如何build?
    方案一：
        把依赖模块代码down下来，每次build时更新一次代码，然后编译，打到本地仓库
    方案二：
        每次build前，清空本地仓库
    方案三：
        两个模块间频繁修改version
    庆幸的是 maven 已经提供了解决方案 snapshot , 通过在版本状态 snapshot ，我们可以每次bulid 模块时，都可以获取服务器同版本最新的代码

## 2.2 snapshot版本自动获取服务器最新代码原理
    
    参考：Maven版本号中隐藏的惊天大秘密

    我们在提交snapshot版本时 mvn deploy,会提交一个带时间搓的版本号！
    maven会根据模块的版本号(pom文件中的version)中是否带有“-SNAPSHOT”(注意这里必须是全部大写)来判断是快照版本还是正式版本。如果是快照版本，
    那么在mvn deploy时会自动发布到私服的快照版本库中;如果是正式发布版本，那么在mvn deploy时会自动发布到正式版本库中。
    我们下载依赖到本地仓库时，也会带上这个带有时间搓的版本号
    每次当我们 mvn compile, 会分析版本状态为snapshot的依赖，自动与远程仓库中的同版本的snapshot进行对比、更新。所以尽管我们没有修改任何东西，maven也会替我们拿到最新的代码！

## 2.3 snapshot 和 release 的使用场景和区别？
    场景：
        snapshot 快照版本对应开发过程中的版本，特点是快速的迭代更新，同样的版本号对应的是项目在一段时间内的开发过程。
        release 释放版本应该是一个稳定的版本，它应该对应项目在某个时刻的状态 —— 它对应唯一的代码版本。
    区别：
        release 并不会检查远程仓库。
        snapshot 会检查远程仓库，同步更新到最新的snapshot版本
        
## 3.在dependency中使用

    参考： maven release版本不更新原因分析
    "RELEASE"、"LASTER"、"SNAPSHOT"

    RELEASE : 使用最大的release版本版本号。
    SNAPSHOT : snapshot版本与release，略微不同，它比较的是lastUpdated，哪个新就下载哪个，所以如果版本号是x.x.x-SNAPSHOT，肯定会更新下来。
    LATEST : 最新版本，则是发布版和快照中
