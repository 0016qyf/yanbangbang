package com.dyb.yanbangbang.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author Tang
 * @since 2019-01-10
 */
public class Post extends Model<Post> {

    private static final long serialVersionUID = 1L;

    /**
     * 帖子ID，主键，自增
     */
    @TableId(value = "post_id", type = IdType.AUTO)
    private Integer postId;
    /**
     * 帖子标题
     */
    private String name;
    /**
     * 帖子内容摘要
     */
    private String summary;
    /**
     * 帖子内容
     */
    private String content;
    /**
     * 帖子存储url(路径)
     */
    private String contentUrl;
    /**
     * 首页图片url
     */
    private String indexImgUrl;
    /**
     * 帖子图片，对应资源主表id
     */
    private Integer resourceId;
    /**
     * 帖子状态：0---未上架    1---已上架
     */
    private Integer state;
    /**
     * 帖子排序字段，数字越小，排名越靠前
     */
    private Integer sort;
    /**
     * 发布（上架）时间
     */
    private LocalDate publishTime;
    /**
     * 创建时间
     */
    private LocalDate createTime;
    /**
     * 下架时间
     */
    private LocalDate shelfTime;
    /**
     * 浏览人数
     */
    private Integer skim;
    private String imgKey;


    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getIndexImgUrl() {
        return indexImgUrl;
    }

    public void setIndexImgUrl(String indexImgUrl) {
        this.indexImgUrl = indexImgUrl;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public LocalDate getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDate publishTime) {
        this.publishTime = publishTime;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(LocalDate shelfTime) {
        this.shelfTime = shelfTime;
    }

    public Integer getSkim() {
        return skim;
    }

    public void setSkim(Integer skim) {
        this.skim = skim;
    }

    public String getImgKey() {
        return imgKey;
    }

    public void setImgKey(String imgKey) {
        this.imgKey = imgKey;
    }

    @Override
    protected Serializable pkVal() {
        return this.postId;
    }

    @Override
    public String toString() {
        return "Post{" +
        ", postId=" + postId +
        ", name=" + name +
        ", summary=" + summary +
        ", content=" + content +
        ", contentUrl=" + contentUrl +
        ", indexImgUrl=" + indexImgUrl +
        ", resourceId=" + resourceId +
        ", state=" + state +
        ", sort=" + sort +
        ", publishTime=" + publishTime +
        ", createTime=" + createTime +
        ", shelfTime=" + shelfTime +
        ", skim=" + skim +
        ", imgKey=" + imgKey +
        "}";
    }
}
