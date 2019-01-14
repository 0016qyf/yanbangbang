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
 * @since 2018-12-28
 */
public class Group extends Model<Group> {

    private static final long serialVersionUID = 1L;

    /**
     * 团id,主键，自增
     */
    @TableId(value = "group_id", type = IdType.AUTO)
    private Integer groupId;
    /**
     * 拼团人数
     */
    private Integer groupCount;
    /**
     * 拼团商品的id
     */
    private Integer materialId;
    /**
     * 拼团价格
     */
    private BigDecimal groupPrice;
    /**
     * 拼团发起者的id
     */
    private Integer creatorId;
    /**
     * 发起时间
     */
    private Date createTime;
    /**
     * 拼团时长（单位：小时）
     */
    private Integer duration;
    /**
     * 拼团状态：0---拼团中   1---成功     2---失败   
     */
    private Integer state;


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(Integer groupCount) {
        this.groupCount = groupCount;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public BigDecimal getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(BigDecimal groupPrice) {
        this.groupPrice = groupPrice;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    protected Serializable pkVal() {
        return this.groupId;
    }

    @Override
    public String toString() {
        return "Group{" +
        ", groupId=" + groupId +
        ", groupCount=" + groupCount +
        ", materialId=" + materialId +
        ", groupPrice=" + groupPrice +
        ", creatorId=" + creatorId +
        ", createTime=" + createTime +
        ", duration=" + duration +
        ", state=" + state +
        "}";
    }
}
