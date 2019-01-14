package com.dyb.yanbangbang.service;

import com.baomidou.mybatisplus.service.IService;
import com.dyb.yanbangbang.entity.Material;
import com.dyb.yanbangbang.entity.ShopGoodsMapping;
import com.dyb.yanbangbang.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tang
 * @since 2018-12-24
 */
public interface IMaterialService extends IService<Material> {

    List<Material> selectByShop(List<ShopGoodsMapping> shopGoodsMappings);

    List<Material> selectByMajor(User user);

    List selectByType(User user,Integer type);

    List<Material> selectByUser(User user);

    List<Material> selectByMaterial(String school,String major,String type);

    Material selectByMaterialId(Integer id);
}
