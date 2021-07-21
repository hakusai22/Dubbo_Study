package com.xizi.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xizi.pojo.UserAddress;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
//@DubboService(timeout = 100,weight = 100,group = "xizi",version ="1.0.0")  //暴露服务
@DubboService(loadbalance = "roundrobin",weight = 300,cluster ="failsafe")
public class UserServiceImpl implements UserService {


    @HystrixCommand
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("userService1.....");
        UserAddress userAddress1 = new UserAddress(1, "江西南昌", "00000", "xizizzz", "15652211111", "1");
        UserAddress userAddress2 = new UserAddress(2, "浙江杭州", "00001", "xizzz", "17911111111", "1");

        if(Math.random()>0.5) {
            throw new RuntimeException();
        }
        return Arrays.asList(userAddress1, userAddress2);
    }
}
