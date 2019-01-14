package com.dyb.yanbangbang.service;

import com.baomidou.mybatisplus.service.IService;
import com.dyb.yanbangbang.entity.UserCoupon;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tang
 * @since 2018-12-18
 */
public interface IUserCouponService extends IService<UserCoupon> {

    List<UserCoupon> selectAll(Integer userid);

}
