package com.dyb.yanbangbang.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 大学专业表
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
public class Majors extends Model<Majors> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    @TableId(value = "major_id", type = IdType.AUTO)
    private Integer majorId;
    /**
     * 专业代码
     */
    private Integer majorCode;
    /**
     * 专业名称
     */
    private String majorName;
    /**
     * 父级
     */
    private Integer pId;


    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(Integer majorCode) {
        this.majorCode = majorCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Override
    protected Serializable pkVal() {
        return this.majorId;
    }

    @Override
    public String toString() {
        return "Majors{" +
        ", majorId=" + majorId +
        ", majorCode=" + majorCode +
        ", majorName=" + majorName +
        ", pId=" + pId +
        "}";
    }
}
