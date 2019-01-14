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
 * @since 2019-01-08
 */
public class Checks extends Model<Checks> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "check_id", type = IdType.AUTO)
    private Integer checkId;
    /**
     * 要审核的主体id
     */
    private Integer beCheckedId;
    /**
     * 要审核的主体名称
     */
    private String beCheckedName;
    /**
     * 审核者id
     */
    private Integer checkerId;
    /**
     * 审核者姓名
     */
    private String checkerName;
    /**
     * 审核状态: 0---审核不通过    1----审核通过    2---审核中
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
    /**
     * 要申请的类型：2-教师 3-校代
     */
    private Integer type;


    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getBeCheckedId() {
        return beCheckedId;
    }

    public void setBeCheckedId(Integer beCheckedId) {
        this.beCheckedId = beCheckedId;
    }

    public String getBeCheckedName() {
        return beCheckedName;
    }

    public void setBeCheckedName(String beCheckedName) {
        this.beCheckedName = beCheckedName;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    protected Serializable pkVal() {
        return this.checkId;
    }

    @Override
    public String toString() {
        return "Checks{" +
        ", checkId=" + checkId +
        ", beCheckedId=" + beCheckedId +
        ", beCheckedName=" + beCheckedName +
        ", checkerId=" + checkerId +
        ", checkerName=" + checkerName +
        ", state=" + state +
        ", reason=" + reason +
        ", checkTime=" + checkTime +
        ", passTime=" + passTime +
        ", type=" + type +
        "}";
    }
}
