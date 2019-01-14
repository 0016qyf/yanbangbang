package com.dyb.yanbangbang.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
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
 * @since 2018-12-28
 */
public class GoodEvaluate extends Model<GoodEvaluate> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品评价id,主键，自增
     */
    @TableId(value = "good_evaluate_id", type = IdType.AUTO)
    private Integer goodEvaluateId;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 商品（资料）id
     */
    private Integer materialId;
    /**
     * 买家头像
     */
    @TableField("buyer_head_Img")
    private String buyerHeadImg;
    /**
     * 买家昵称
     */
    private String buyerNikeName;
    /**
     * 买家id
     */
    private Integer buyerId;
    /**
     * 描述相符度分
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
     * 快递服务分
     */
    private Double expServiceScore;
    private String orderCode;
    /**
     * 评价内容
     */
    private String content;
    /**
     * 评价时间
     */
    private Date evaluationTime;
    /**
     * 评价类型：1----首次评价     2----追加评价
     */
    private Integer evaluateType;
    /**
     * 资源主表id
     */
    private Integer resourceId;


    public Integer getGoodEvaluateId() {
        return goodEvaluateId;
    }

    public void setGoodEvaluateId(Integer goodEvaluateId) {
        this.goodEvaluateId = goodEvaluateId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getBuyerHeadImg() {
        return buyerHeadImg;
    }

    public void setBuyerHeadImg(String buyerHeadImg) {
        this.buyerHeadImg = buyerHeadImg;
    }

    public String getBuyerNikeName() {
        return buyerNikeName;
    }

    public void setBuyerNikeName(String buyerNikeName) {
        this.buyerNikeName = buyerNikeName;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
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

    public Double getExpServiceScore() {
        return expServiceScore;
    }

    public void setExpServiceScore(Double expServiceScore) {
        this.expServiceScore = expServiceScore;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Date evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public Integer getEvaluateType() {
        return evaluateType;
    }

    public void setEvaluateType(Integer evaluateType) {
        this.evaluateType = evaluateType;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    protected Serializable pkVal() {
        return this.goodEvaluateId;
    }

    @Override
    public String toString() {
        return "GoodEvaluate{" +
        ", goodEvaluateId=" + goodEvaluateId +
        ", orderId=" + orderId +
        ", materialId=" + materialId +
        ", buyerHeadImg=" + buyerHeadImg +
        ", buyerNikeName=" + buyerNikeName +
        ", buyerId=" + buyerId +
        ", introduceMatchScore=" + introduceMatchScore +
        ", goodsValueScore=" + goodsValueScore +
        ", teacherServiceScore=" + teacherServiceScore +
        ", answerSpeedScore=" + answerSpeedScore +
        ", expServiceScore=" + expServiceScore +
        ", orderCode=" + orderCode +
        ", content=" + content +
        ", evaluationTime=" + evaluationTime +
        ", evaluateType=" + evaluateType +
        ", resourceId=" + resourceId +
        "}";
    }
}
