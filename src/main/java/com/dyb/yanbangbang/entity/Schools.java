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
public class Schools extends Model<Schools> {

    private static final long serialVersionUID = 1L;

    /**
     * 学校id,主键，自增
     */
    @TableId(value = "school_id", type = IdType.AUTO)
    private Integer schoolId;
    /**
     * 学校名称
     */
    private String schoolName;
    /**
     * 学校所属省份的id
     */
    private Integer schoolProId;
    /**
     * 学校类型id
     */
    private Integer schoolTypeId;


    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getSchoolProId() {
        return schoolProId;
    }

    public void setSchoolProId(Integer schoolProId) {
        this.schoolProId = schoolProId;
    }

    public Integer getSchoolTypeId() {
        return schoolTypeId;
    }

    public void setSchoolTypeId(Integer schoolTypeId) {
        this.schoolTypeId = schoolTypeId;
    }

    @Override
    protected Serializable pkVal() {
        return this.schoolId;
    }

    @Override
    public String toString() {
        return "Schools{" +
        ", schoolId=" + schoolId +
        ", schoolName=" + schoolName +
        ", schoolProId=" + schoolProId +
        ", schoolTypeId=" + schoolTypeId +
        "}";
    }
}
