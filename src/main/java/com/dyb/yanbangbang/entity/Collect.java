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
 * @since 2018-12-24
 */
public class Collect extends Model<Collect> {

    private static final long serialVersionUID = 1L;

    /**
     * 收藏表id，非空，自增
     */
    @TableId(value = "collect_id", type = IdType.AUTO)
    private Integer collectId;
    /**
     * 收藏者的id
     */
    private Integer userId;
    /**
     * 被收藏对象的id
     */
    private Integer objectId;
    /**
     * 被收藏对象的类型
     */
    private Integer type;
    /**
     * 收藏日期
     */
    private Date collectDate;


    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.collectId;
    }

    @Override
    public String toString() {
        return "Collect{" +
        ", collectId=" + collectId +
        ", userId=" + userId +
        ", objectId=" + objectId +
        ", type=" + type +
        ", collectDate=" + collectDate +
        "}";
    }
}
