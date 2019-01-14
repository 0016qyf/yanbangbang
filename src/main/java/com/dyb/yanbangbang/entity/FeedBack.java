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
 * @since 2018-12-29
 */
public class FeedBack extends Model<FeedBack> {

    private static final long serialVersionUID = 1L;

    /**
     * 意见反馈表，主键，自增
     */
    @TableId(value = "feed_back_id", type = IdType.AUTO)
    private Integer feedBackId;
    /**
     * 意见反馈者的id
     */
    private Integer userId;
    /**
     * 意见反馈者的手机号
     */
    private String phone;
    /**
     * 反馈内容
     */
    private String content;
    /**
     * 意见反馈附带的图片地址
     */
    private Integer resourceId;
    /**
     * 反馈时间
     */
    private Date createTime;


    public Integer getFeedBackId() {
        return feedBackId;
    }

    public void setFeedBackId(Integer feedBackId) {
        this.feedBackId = feedBackId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.feedBackId;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
        ", feedBackId=" + feedBackId +
        ", userId=" + userId +
        ", phone=" + phone +
        ", content=" + content +
        ", resourceId=" + resourceId +
        ", createTime=" + createTime +
        "}";
    }
}
