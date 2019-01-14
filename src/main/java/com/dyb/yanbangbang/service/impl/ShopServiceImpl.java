package com.dyb.yanbangbang.service.impl;

import com.dyb.yanbangbang.entity.Shop;
import com.dyb.yanbangbang.mapper.ShopMapper;
import com.dyb.yanbangbang.service.IShopService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Override
    public List selectCollect(List list) {
        if(list==null){
            throw new NullPointerException(""
                    + "输入的参数为空");
        }
        List<Shop> shops= selectBatchIds(list);
        List ins=new ArrayList<>();
        for (Shop shop:shops){
           ins.add(shop.getHostId());
        }
        return ins;
    }

    @Override
    public Shop selectByShopId(Integer shopId) {
        if(shopId==null){
            throw new NullPointerException(""
                    + "输入的参数为空");
        }
        return selectById(shopId);
    }
}
