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
public class Notice extends Model<Notice> {

    private static final long serialVersionUID = 1L;

    /**
     * 公告主键，自增
     */
    @TableId(value = "notice_id", type = IdType.AUTO)
    private Integer noticeId;
    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告内容
     */
    private String content;
    /**
     * 公告资源
     */
    private Integer resourceId;
    /**
     * 创建者id
     */
    private Integer creatorId;
    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 公告状态 0---未发布   1---已发布    2---已过期
     */
    private Integer state;


    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    protected Serializable pkVal() {
        return this.noticeId;
    }

    @Override
    public String toString() {
        return "Notice{" +
        ", noticeId=" + noticeId +
        ", title=" + title +
        ", content=" + content +
        ", resourceId=" + resourceId +
        ", creatorId=" + creatorId +
        ", createTime=" + createTime +
        ", state=" + state +
        "}";
    }
}
