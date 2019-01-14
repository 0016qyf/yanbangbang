package com.dyb.yanbangbang.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
public class Shop extends Model<Shop> {

    private static final long serialVersionUID = 1L;

    /**
     * 店铺id，主键，自增
     */
    @TableId(value = "shop_id", type = IdType.AUTO)
    private Integer shopId;
    /**
     * 店主id
     */
    private Integer hostId;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 店铺介绍
     */
    private String shopIntroduce;
    /**
     * 商品简介
     */
    private String goodsIntroduce;
    /**
     * 店铺主页的图片资源（对应一个资源表的id）
     */
    private Integer shopImg;
    /**
     * 描述相符度得分
     */
    private Double introduceMatchScore;
    /**
     * 资料价值分
     */
    private Double goodsValueScore;
    /**
     * 老师服务分
     */
    private Double teacherServiceScore;
    /**
     * 答疑速度分
     */
    private Double answerSpeedScore;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;


    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopIntroduce() {
        return shopIntroduce;
    }

    public void setShopIntroduce(String shopIntroduce) {
        this.shopIntroduce = shopIntroduce;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public Integer getShopImg() {
        return shopImg;
    }

    public void setShopImg(Integer shopImg) {
        this.shopImg = shopImg;
    }

    public Double getIntroduceMatchScore() {
        return introduceMatchScore;
    }

    public void setIntroduceMatchScore(Double introduceMatchScore) {
        this.introduceMatchScore = introduceMatchScore;
    }

    public Double getGoodsValueScore() {
        return goodsValueScore;
    }

    public void setGoodsValueScore(Double goodsValueScore) {
        this.goodsValueScore = goodsValueScore;
    }

    public Double getTeacherServiceScore() {
        return teacherServiceScore;
    }

    public void setTeacherServiceScore(Double teacherServiceScore) {
        this.teacherServiceScore = teacherServiceScore;
    }

    public Double getAnswerSpeedScore() {
        return answerSpeedScore;
    }

    public void setAnswerSpeedScore(Double answerSpeedScore) {
        this.answerSpeedScore = answerSpeedScore;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.shopId;
    }

    @Override
    public String toString() {
        return "Shop{" +
        ", shopId=" + shopId +
        ", hostId=" + hostId +
        ", shopName=" + shopName +
        ", shopIntroduce=" + shopIntroduce +
        ", goodsIntroduce=" + goodsIntroduce +
        ", shopImg=" + shopImg +
        ", introduceMatchScore=" + introduceMatchScore +
        ", goodsValueScore=" + goodsValueScore +
        ", teacherServiceScore=" + teacherServiceScore +
        ", answerSpeedScore=" + answerSpeedScore +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
