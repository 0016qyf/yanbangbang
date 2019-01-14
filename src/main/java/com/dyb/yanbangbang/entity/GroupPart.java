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
 * @since 2018-12-29
 */
public class GroupPart extends Model<GroupPart> {

    private static final long serialVersionUID = 1L;

    /**
     * 参与拼团id，主键，自增
     */
    @TableId(value = "group_part_id", type = IdType.AUTO)
    private Integer groupPartId;
    /**
     * 拼团id(关联拼团主表group 的主键)
     */
    private Integer groupId;
    /**
     * 参与者的昵称
     */
    private String partNikeName;
    /**
     * 参与者的头像
     */
    @TableField("part_head_Img")
    private String partHeadImg;
    /**
     * 参与者的id
     */
    private Integer partId;
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 参与时间
     */
    private Date partTime;


    public Integer getGroupPartId() {
        return groupPartId;
    }

    public void setGroupPartId(Integer groupPartId) {
        this.groupPartId = groupPartId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getPartNikeName() {
        return partNikeName;
    }

    public void setPartNikeName(String partNikeName) {
        this.partNikeName = partNikeName;
    }

    public String getPartHeadImg() {
        return partHeadImg;
    }

    public void setPartHeadImg(String partHeadImg) {
        this.partHeadImg = partHeadImg;
    }

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Date getPartTime() {
        return partTime;
    }

    public void setPartTime(Date partTime) {
        this.partTime = partTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.groupPartId;
    }

    @Override
    public String toString() {
        return "GroupPart{" +
        ", groupPartId=" + groupPartId +
        ", groupId=" + groupId +
        ", partNikeName=" + partNikeName +
        ", partHeadImg=" + partHeadImg +
        ", partId=" + partId +
        ", orderCode=" + orderCode +
        ", partTime=" + partTime +
        "}";
    }
}
