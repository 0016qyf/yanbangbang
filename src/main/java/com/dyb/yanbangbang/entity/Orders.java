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
public class Orders extends Model<Orders> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id,主键，自增
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;
    private String orderCode;
    /**
     * 店铺id
     */
    private Integer shopId;
    /**
     * 买家id
     */
    private Integer buyerId;
    /**
     * 资料id
     */
    private Integer materialId;
    /**
     * 订单状态：1---待付款    2---待发货   3---已发货   4---待评价   5---待分享   6---已评价   7---已退款 
8---交易取消   9---交易超时    10---交易成功    11---交易进行中
     */
    private Integer state;
    /**
     * 订单类型：1---普通订单     2---拼团订单    3---砍价订单    4---众筹订单
     */
    private Integer orderType;
    /**
     * 下单时间(订单创建时间)
     */
    private Date createTime;
    /**
     * 付款时间
     */
    private Date payTime;
    /**
     * 订单完成时间
     */
    private Date endTime;
    /**
     * 发货时间
     */
    private Date deliveryTime;
    /**
     * 申请退款时间
     */
    private Date refundApplyTime;
    /**
     * 完成退款时间
     */
    private Date refundTime;
    /**
     * 快递单号
     */
    private String expNum;
    /**
     * 快递公司名称
     */
    private String expName;
    /**
     * 商品规格
     */
    private String specification;
    /**
     * 商品单价
     */
    private BigDecimal price;
    /**
     * 下单数量
     */
    private Integer count;
    /**
     * 总金额
     */
    private BigDecimal totalMoney;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 使用的优惠券id
     */
    private Integer useCouponId;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getRefundApplyTime() {
        return refundApplyTime;
    }

    public void setRefundApplyTime(Date refundApplyTime) {
        this.refundApplyTime = refundApplyTime;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public String getExpNum() {
        return expNum;
    }

    public void setExpNum(String expNum) {
        this.expNum = expNum;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUseCouponId() {
        return useCouponId;
    }

    public void setUseCouponId(Integer useCouponId) {
        this.useCouponId = useCouponId;
    }

    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

    @Override
    public String toString() {
        return "Orders{" +
        ", orderId=" + orderId +
        ", orderCode=" + orderCode +
        ", shopId=" + shopId +
        ", buyerId=" + buyerId +
        ", materialId=" + materialId +
        ", state=" + state +
        ", orderType=" + orderType +
        ", createTime=" + createTime +
        ", payTime=" + payTime +
        ", endTime=" + endTime +
        ", deliveryTime=" + deliveryTime +
        ", refundApplyTime=" + refundApplyTime +
        ", refundTime=" + refundTime +
        ", expNum=" + expNum +
        ", expName=" + expName +
        ", specification=" + specification +
        ", price=" + price +
        ", count=" + count +
        ", totalMoney=" + totalMoney +
        ", address=" + address +
        ", useCouponId=" + useCouponId +
        "}";
    }
}
