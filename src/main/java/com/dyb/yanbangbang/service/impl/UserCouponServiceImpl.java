package com.dyb.yanbangbang.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dyb.yanbangbang.entity.UserCoupon;
import com.dyb.yanbangbang.mapper.UserCouponMapper;
import com.dyb.yanbangbang.service.IUserCouponService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tang
 * @since 2018-12-18
 */
@Service
public class UserCouponServiceImpl extends ServiceImpl<UserCouponMapper, UserCoupon> implements IUserCouponService {

    @Override
    public List<UserCoupon> selectAll(Integer userid) {
        if(userid==null) {
            throw new NullPointerException(""
                    + "当前用户名为空");
        }

        return selectList(new EntityWrapper<UserCoupon>().eq("user_id",userid));
    }
}
