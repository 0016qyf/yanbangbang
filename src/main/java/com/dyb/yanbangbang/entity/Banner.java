package com.dyb.yanbangbang.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Tang
 * @since 2019-01-08
 */
public class Banner extends Model<Banner> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "banner_id", type = IdType.AUTO)
    private Integer bannerId;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片路径
     */
    private String imgUrl;
    /**
     * 图片状态： 0-下架 1-上架
     */
    private Integer state;


    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    protected Serializable pkVal() {
        return this.bannerId;
    }

    @Override
    public String toString() {
        return "Banner{" +
        ", bannerId=" + bannerId +
        ", title=" + title +
        ", imgUrl=" + imgUrl +
        ", state=" + state +
        "}";
    }
}
