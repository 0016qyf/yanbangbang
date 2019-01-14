package com.dyb.yanbangbang.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
public class ShopGoodsMapping extends Model<ShopGoodsMapping> {

    private static final long serialVersionUID = 1L;

    /**
     * 店铺与商品（资料）映射id，主键，自增
     */
    @TableId(value = "shop_goods_mapping_id", type = IdType.AUTO)
    private Integer shopGoodsMappingId;
    /**
     * 店铺id
     */
    private Integer shopId;
    /**
     * 商品id
     */
    private Integer materialId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;


    public Integer getShopGoodsMappingId() {
        return shopGoodsMappingId;
    }

    public void setShopGoodsMappingId(Integer shopGoodsMappingId) {
        this.shopGoodsMappingId = shopGoodsMappingId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
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
        return this.shopGoodsMappingId;
    }

    @Override
    public String toString() {
        return "ShopGoodsMapping{" +
        ", shopGoodsMappingId=" + shopGoodsMappingId +
        ", shopId=" + shopId +
        ", materialId=" + materialId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
