package com.dyb.yanbangbang.service;

import com.baomidou.mybatisplus.service.IService;
import com.dyb.yanbangbang.entity.ReceiveAddress;
import com.dyb.yanbangbang.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tang
 * @since 2019-01-04
 */
public interface IReceiveAddressService extends IService<ReceiveAddress> {

    ReceiveAddress save(ReceiveAddress receiveAddress);

    List<ReceiveAddress> selectByUser(User user);

    boolean del(Integer receiveAddressId);

    ReceiveAddress selectOne(User user);


}
