package com.dyb.yanbangbang.service;

import com.dyb.yanbangbang.entity.Shop;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
public interface IShopService extends IService<Shop> {

    //查找收藏的店铺
    List selectCollect(List list);

    Shop selectByShopId(Integer shopId);

}
