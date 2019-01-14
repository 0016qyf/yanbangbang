package com.dyb.yanbangbang.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Tang
 * @since 2019-01-02
 */
public class UserCoupon extends Model<UserCoupon> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户优惠券id，主键，自增
     */
    @TableId(value = "user_coupon_id", type = IdType.AUTO)
    private Integer userCouponId;
    /**
     * 用户id(关联user表主键)
     */
    private Integer userId;
    /**
     * 店铺优惠券id(关联shop_coupon表主键)
     */
    private Integer shopCouponId;
    /**
     * 优惠券类型：0---通用优惠券，不限店铺    1---限真题     2---限笔记    3---限视频    4---其他
     */
    private Integer type;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 店铺id
     */
    private Integer shopId;
    /**
     * 优惠券名称
     */
    private String name;
    /**
     * 优惠券金额
     */
    private BigDecimal amount;
    /**
     * 优惠券使用的最小限额
     */
    private BigDecimal minAmount;
    /**
     * 优惠券领取时间
     */
    private Date getTime;
    /**
     * 优惠券有效期的起始时间
     */
    private Date startTime;
    /**
     * 优惠券到期时间
     */
    private Date endTime;
    /**
     * 优惠券使用时间
     */
    private Date useTime;
    /**
     * 优惠券状态: 1----未使用     2----已使用     3----已过期
     */
    private Integer state;


    public Integer getUserCouponId() {
        return userCouponId;
    }

    public void setUserCouponId(Integer userCouponId) {
        this.userCouponId = userCouponId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShopCouponId() {
        return shopCouponId;
    }

    public void setShopCouponId(Integer shopCouponId) {
        this.shopCouponId = shopCouponId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    protected Serializable pkVal() {
        return this.userCouponId;
    }

    @Override
    public String toString() {
        return "UserCoupon{" +
        ", userCouponId=" + userCouponId +
        ", userId=" + userId +
        ", shopCouponId=" + shopCouponId +
        ", type=" + type +
        ", shopName=" + shopName +
        ", shopId=" + shopId +
        ", name=" + name +
        ", amount=" + amount +
        ", minAmount=" + minAmount +
        ", getTime=" + getTime +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", useTime=" + useTime +
        ", state=" + state +
        "}";
    }
}
