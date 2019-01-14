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
public class SchoolType extends Model<SchoolType> {

    private static final long serialVersionUID = 1L;

    /**
     * 学校类型id,主键，自增
     */
    @TableId(value = "school_type_id", type = IdType.AUTO)
    private Integer schoolTypeId;
    /**
     * 类型名称
     */
    private String typeName;


    public Integer getSchoolTypeId() {
        return schoolTypeId;
    }

    public void setSchoolTypeId(Integer schoolTypeId) {
        this.schoolTypeId = schoolTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    protected Serializable pkVal() {
        return this.schoolTypeId;
    }

    @Override
    public String toString() {
        return "SchoolType{" +
        ", schoolTypeId=" + schoolTypeId +
        ", typeName=" + typeName +
        "}";
    }
}
