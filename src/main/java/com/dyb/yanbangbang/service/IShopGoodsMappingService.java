package com.dyb.yanbangbang.service;

import com.baomidou.mybatisplus.service.IService;
import com.dyb.yanbangbang.entity.ShopGoodsMapping;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
public interface IShopGoodsMappingService extends IService<ShopGoodsMapping> {

    List<ShopGoodsMapping> selectByShopId(Integer shopId);

}
