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
 * @since 2019-01-02
 */
public class Resource extends Model<Resource> {

    private static final long serialVersionUID = 1L;

    /**
     * 资源主表id，主键，自增
     */
    @TableId(value = "resource_id", type = IdType.AUTO)
    private Integer resourceId;
    /**
     * 上传者的id
     */
    private Integer uploaderId;
    /**
     * 资源分类：1---用户相关资源    2---第一次评论图片资源     3----追加评论图片资源        4----商品图片资源            5---资料资源        6---店铺图片资源       7----意见反馈图片资源
     */
    private Integer type;
    /**
     * 资源名称
     */
    private String resourceName;
    /**
     * 资源简述
     */
    private String resourceSummary;
    /**
     * 创建时间
     */
    private Date createTime;
    private Date updateTime;


    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(Integer uploaderId) {
        this.uploaderId = uploaderId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceSummary() {
        return resourceSummary;
    }

    public void setResourceSummary(String resourceSummary) {
        this.resourceSummary = resourceSummary;
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
        return this.resourceId;
    }

    @Override
    public String toString() {
        return "Resource{" +
        ", resourceId=" + resourceId +
        ", uploaderId=" + uploaderId +
        ", type=" + type +
        ", resourceName=" + resourceName +
        ", resourceSummary=" + resourceSummary +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
