package com.xizi.service;

import com.xizi.pojo.UserAddress;

import java.util.List;

/**
 * @author xizizzz
 * @description: TODO
 * @date 2021-7-21上午 09:49
 */


public interface OrderService {
    List<UserAddress> initOrder(String userId);
}
