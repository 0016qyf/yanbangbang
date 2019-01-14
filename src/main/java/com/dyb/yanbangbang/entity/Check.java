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
public class Check extends Model<Check> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "check_id", type = IdType.AUTO)
    private Integer checkId;
    /**
     * 资料id
     */
    private Integer materialId;
    /**
     * 资料名称
     */
    private String materialName;
    /**
     * 审核者id
     */
    private Integer checkerId;
    /**
     * 审核者姓名
     */
    private String checkerName;
    /**
     * 审核状态: 0---审核不通过    1----审核不通过
     */
    private Integer state;
    /**
     * 审核不通过的原因
     */
    private String reason;
    /**
     * 审核日期
     */
    private Date checkTime;
    /**
     * 审核通过日期
     */
    private Date passTime;


    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Integer getCheckerId() {
        return checkerId;
    }

    public void setCheckerId(Integer checkerId) {
        this.checkerId = checkerId;
    }

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Date getPassTime() {
        return passTime;
    }

    public void setPassTime(Date passTime) {
        this.passTime = passTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.checkId;
    }

    @Override
    public String toString() {
        return "Check{" +
        ", checkId=" + checkId +
        ", materialId=" + materialId +
        ", materialName=" + materialName +
        ", checkerId=" + checkerId +
        ", checkerName=" + checkerName +
        ", state=" + state +
        ", reason=" + reason +
        ", checkTime=" + checkTime +
        ", passTime=" + passTime +
        "}";
    }
}
