package com.xizi;

import com.xizi.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author xizizzz
 * @description: TODO
 * @date 2021-7-21下午 02:28
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = ioc.getBean(OrderService.class);
        orderService.initOrder("123");
        System.out.println("调用完成。。。。。。。。。。");
        System.in.read();
    }
}
