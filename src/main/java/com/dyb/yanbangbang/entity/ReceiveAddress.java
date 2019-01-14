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
 * @since 2019-01-04
 */
public class ReceiveAddress extends Model<ReceiveAddress> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "detail_address_id", type = IdType.AUTO)
    private Integer detailAddressId;
    /**
     * 关联用户id
     */
    private Integer userId;
    /**
     * 收货人姓名
     */
    private String receiver;
    /**
     * 收货人手机号
     */
    private String phone;
    /**
     * 省名称
     */
    private String province;
    /**
     * 城市名称
     */
    private String city;
    /**
     * 区名称
     */
    private String area;
    /**
     * 详细的收货地址
     */
    private String detailAddress;
    /**
     * 地址标签：1---家     2----公司     3----学校
     */
    private Integer addressSign;
    /**
     * 是否默认：1---默认地址      0----非默认地址
     */
    private Integer isDefault;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;


    public Integer getDetailAddressId() {
        return detailAddressId;
    }

    public void setDetailAddressId(Integer detailAddressId) {
        this.detailAddressId = detailAddressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Integer getAddressSign() {
        return addressSign;
    }

    public void setAddressSign(Integer addressSign) {
        this.addressSign = addressSign;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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
        return this.detailAddressId;
    }

    @Override
    public String toString() {
        return "ReceiveAddress{" +
        ", detailAddressId=" + detailAddressId +
        ", userId=" + userId +
        ", receiver=" + receiver +
        ", phone=" + phone +
        ", province=" + province +
        ", city=" + city +
        ", area=" + area +
        ", detailAddress=" + detailAddress +
        ", addressSign=" + addressSign +
        ", isDefault=" + isDefault +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
