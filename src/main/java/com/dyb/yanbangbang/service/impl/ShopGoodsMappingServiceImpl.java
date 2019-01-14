package com.dyb.yanbangbang.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dyb.yanbangbang.entity.ShopGoodsMapping;
import com.dyb.yanbangbang.mapper.ShopGoodsMappingMapper;
import com.dyb.yanbangbang.service.IShopGoodsMappingService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
@Service
public class ShopGoodsMappingServiceImpl extends ServiceImpl<ShopGoodsMappingMapper, ShopGoodsMapping> implements IShopGoodsMappingService {

    @Override
    public List<ShopGoodsMapping> selectByShopId(Integer shopId) {
        if(shopId==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        return selectList(new EntityWrapper<ShopGoodsMapping>().eq("shop_id",shopId));
    }
}
