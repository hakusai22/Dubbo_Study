package com.xizi;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(locations ="classpath:consumer.xml") //第二种方式 使用dubbo xml配置文件
@SpringBootApplication
@EnableDubbo
@EnableHystrix
public class UserServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceConsumerApplication.class, args);
    }

}
