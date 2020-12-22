package com.atguigu.springcloud.snowflake;

import java.util.Date;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2020/12/22 11:01
 * @Description :
 */
public class IdDemo {

    public static void main(String[] args) {
        //41位数的时间戳
        System.err.println("11111111111111111111111111111111111111111".length());
        //使用进展转换工具，将41位1转换为十进制为(百度搜索)
        long data = 2199023255551L;
        //查看以上值，可以用到哪一年
        Date date = new Date(data);
        //2039-9-7 23:47:35 ,所以该算法可使用到2039年
        System.err.println(date.toLocaleString());
        //69年
        System.err.println(2039-1970);
    }
}
