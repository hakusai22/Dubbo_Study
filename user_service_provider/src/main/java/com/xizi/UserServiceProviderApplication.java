package com.xizi;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//@ImportResource(locations ="classpath:provider.xml") //第二种方式 使用dubbo xml配置文件
@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.xizi") //开启基于注解的dubbo
@EnableHystrix //开启服务容错
public class UserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderApplication.class, args);
    }

}
