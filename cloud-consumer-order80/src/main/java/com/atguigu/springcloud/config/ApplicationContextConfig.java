package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther zzyy
 * @create 2020-02-18 17:27
 */
@Configuration
public class ApplicationContextConfig
{
    @Bean
    @LoadBalanced//负载均衡，默认轮询，为了能够识别    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
//applicationContext.xml <bean id="" class="">
