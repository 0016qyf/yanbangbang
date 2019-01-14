package com.dyb.yanbangbang.service;

import com.baomidou.mybatisplus.service.IService;
import com.dyb.yanbangbang.entity.Material;
import com.dyb.yanbangbang.entity.Orders;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tang
 * @since 2018-12-24
 */
public interface IOrdersService extends IService<Orders> {


    boolean updateState(Integer orderId,Integer states);

    List<Orders> selectByUser (Integer userid);

    List<Orders> selectByMater(Integer materialId,Integer userid);

    Integer selectNum(Material material,Integer type);

    List<Orders> selectByMaterIds(List<Material> materials);

    BigDecimal selectMoney(Material material, Integer type);

}
