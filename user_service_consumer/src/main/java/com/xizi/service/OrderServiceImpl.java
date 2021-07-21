package com.xizi.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xizi.pojo.UserAddress;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author xizizzz
 * @description: TODO
 * @date 2021-7-21上午 09:50
 */

@Service
//@DubboService(timeout = 100,weight = 100,group = "xizi",version ="1.0.0")
@DubboService
public class OrderServiceImpl  implements OrderService{

    @DubboReference(loadbalance="random",timeout=1000,check = false)
//    @Autowired
    UserService userService;

    @HystrixCommand(fallbackMethod="hello")
    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id："+userId);
        //1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress : addressList) {
            System.out.println(userAddress.toString());
        }
        return addressList;
    }

    // 服务报错后置方法
    public List<UserAddress> hello(String userId) {
        return Arrays.asList(new UserAddress(10, "测试地址", "1", "测试", "测试", "Y"));
    }
}
