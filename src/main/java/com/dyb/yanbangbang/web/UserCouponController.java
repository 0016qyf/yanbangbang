package com.dyb.yanbangbang.web;


import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.UserCoupon;
import com.dyb.yanbangbang.service.IShopCouponService;
import com.dyb.yanbangbang.service.IUserCouponService;
import com.dyb.yanbangbang.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  用户与优惠券关联表
 * </p>
 *
 * @author Tang
 * @since 2018-12-18
 */
@RestController
@RequestMapping("/userCoupon/")
public class UserCouponController {

    private static final Logger log = LoggerFactory.getLogger(UserCouponController.class);

    @Autowired
    private IUserCouponService iUserCouponService;

    @Autowired
    private IShopCouponService iShopCouponService;

    /**
     * 此方法为查找该用户拥有的优惠券
     * @param userId 当前用户的id
     * @param current 当前页,用户分页操作
     * @return
     */
    @PostMapping(value = "selectAll")
    public JsonResult selectAll(Integer userId,Integer current){
        log.info("查找优惠券方法");
        List<UserCoupon> list=iUserCouponService.selectAll(userId);
        return new JsonResult(new PageInfo(current,10,list).getRecords());
    }

}

