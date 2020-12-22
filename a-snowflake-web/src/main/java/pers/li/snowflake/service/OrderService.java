package pers.li.snowflake.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2020/12/22 11:43
 * @Description :
 */
@Service
public class OrderService {

    @Resource
    private IDGenerateSnowflake idGenerateSnowflake;

    public String getId() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <=20 ; i++) {
            executorService.submit(()->{
                System.err.println(idGenerateSnowflake.snowFlakeId());
            });
        }
        executorService.shutdown();
        return null;
    }
}
