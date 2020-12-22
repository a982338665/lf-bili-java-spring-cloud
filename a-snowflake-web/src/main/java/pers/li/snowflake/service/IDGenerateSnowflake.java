package pers.li.snowflake.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2020/12/22 11:46
 * @Description :
 */
@Slf4j
@Component
public class IDGenerateSnowflake {

    /**
     * 两个属性的范围都是0到31
     */
    private long workId = 0;
    private long dataCenterId = 0;
    private Snowflake snowflake = IdUtil.createSnowflake(workId, dataCenterId);


    @PostConstruct //构造完成后初始化方法
    public void init() {
        try {
            //获取本主机的workid
            workId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workId：{}", workId);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("当前机器的workId获取失败", e);
            workId = NetUtil.getLocalhostStr().hashCode();
        } finally {

        }
    }


    public synchronized long snowFlakeId() {
        return snowflake.nextId();
    }

    public synchronized long snowFlakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }

    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        System.err.println(new IDGenerateSnowflake().snowFlakeId());
    }
}
