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
 * @since 2019-01-08
 */
public class ShopCoupon extends Model<ShopCoupon> {

    private static final long serialVersionUID = 1L;

    /**
     * 店铺优惠券id,主键，自增
     */
    @TableId(value = "shop_coupon_id", type = IdType.AUTO)
    private Integer shopCouponId;
    /**
     * 优惠券类型：0---通用优惠券，不限店铺   1---限真题   2---限笔记    3---限视频   4---限其他
     */
    private Integer type;
    /**
     * 店铺名称
     */
    private String shopName;
    private Integer shopId;
    /**
     * 优惠券名称
     */
    private String name;
    /**
     * 优惠券总数量
     */
    private Integer totalCount;
    /**
     * 优惠券剩余数量
     */
    private Integer surplusCount;
    /**
     * 优惠券金额
     */
    private BigDecimal amount;
    /**
     * 优惠券最小使用金额
     */
    private BigDecimal minAmount;
    /**
     * 优惠券创建时间
     */
    private Date createTime;
    /**
     * 优惠券创建人id
     */
    private Integer creatorId;
    /**
     * 优惠券有效期起始时间
     */
    private Date startTime;
    /**
     * 优惠券有效期结束时间
     */
    private Date endTime;
    /**
     * 学校
     */
    private String school;
    /**
     * 专业
     */
    private String major;


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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getSurplusCount() {
        return surplusCount;
    }

    public void setSurplusCount(Integer surplusCount) {
        this.surplusCount = surplusCount;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    protected Serializable pkVal() {
        return this.shopCouponId;
    }

    @Override
    public String toString() {
        return "ShopCoupon{" +
        ", shopCouponId=" + shopCouponId +
        ", type=" + type +
        ", shopName=" + shopName +
        ", shopId=" + shopId +
        ", name=" + name +
        ", totalCount=" + totalCount +
        ", surplusCount=" + surplusCount +
        ", amount=" + amount +
        ", minAmount=" + minAmount +
        ", createTime=" + createTime +
        ", creatorId=" + creatorId +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", school=" + school +
        ", major=" + major +
        "}";
    }
}
