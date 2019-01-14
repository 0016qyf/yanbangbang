package com.dyb.yanbangbang.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
public class ResourceDetail extends Model<ResourceDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 资源详情表id，主键，自增
     */
    @TableId(value = "resource_detail_id", type = IdType.AUTO)
    private Integer resourceDetailId;
    /**
     * 关联的资源主表id
     */
    private Integer resourceId;
    /**
     * 存储的文件名称
     */
    private String fileName;
    /**
     * 存储的键
     */
    private String key;
    /**
     * 资源的url
     */
    private String url;
    /**
     * 资源类型:1----图片    2----视频     3----文档     4----其他
     */
    private Integer type;


    public Integer getResourceDetailId() {
        return resourceDetailId;
    }

    public void setResourceDetailId(Integer resourceDetailId) {
        this.resourceDetailId = resourceDetailId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    protected Serializable pkVal() {
        return this.resourceDetailId;
    }

    @Override
    public String toString() {
        return "ResourceDetail{" +
        ", resourceDetailId=" + resourceDetailId +
        ", resourceId=" + resourceId +
        ", fileName=" + fileName +
        ", key=" + key +
        ", url=" + url +
        ", type=" + type +
        "}";
    }
}
