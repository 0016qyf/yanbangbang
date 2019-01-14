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
public class Provinces extends Model<Provinces> {

    private static final long serialVersionUID = 1L;

    /**
     * 省份id,主键，自增
     */
    @TableId(value = "province_id", type = IdType.AUTO)
    private Integer provinceId;
    /**
     * 省份编号
     */
    private Integer code;
    /**
     * 省份名称
     */
    private String name;


    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Serializable pkVal() {
        return this.provinceId;
    }

    @Override
    public String toString() {
        return "Provinces{" +
        ", provinceId=" + provinceId +
        ", code=" + code +
        ", name=" + name +
        "}";
    }
}
