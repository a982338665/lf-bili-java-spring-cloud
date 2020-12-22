package pers.li.snowflake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @auther zzyy
 * @create 2020-02-26 15:15
 */
@SpringBootApplication
public class APP {

    public static void main(String[] args) {
        SpringApplication.run(APP.class, args);
    }
}
