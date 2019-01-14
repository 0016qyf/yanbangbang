package com.dyb.yanbangbang.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Tang
 * @since 2019-01-09
 */
public class Material extends Model<Material> {

    private static final long serialVersionUID = 1L;

    /**
     * 资料主键id，非空，自增
     */
    @TableId(value = "material_id", type = IdType.AUTO)
    private Integer materialId;
    /**
     * 资料名称
     */
    private String materialName;
    /**
     * 资料所属领域(范围)
     */
    private String materialField;
    /**
     * 资料所属科目名称
     */
    private String materialSubject;
    /**
     * 资料总页数
     */
    private Integer materialPageCount;
    /**
     * 资料描述
     */
    private String describe;
    /**
     * 资料来源类型: 1---原创   2---整合资料    3---网络下载
     */
    private Integer fromType;
    /**
     * 资料类型：1----笔记    2----真题     3----视频    4----其他
     */
    private Integer materialType;
    /**
     * 上传该资料的用户的id
     */
    private Integer hostId;
    /**
     * 资源主表ID
     */
    private Integer resourceId;
    /**
     * 资料零售价（单位：元），即原价
     */
    private BigDecimal retailPrice;
    /**
     * 优惠价格
     */
    private BigDecimal salePrice;
    /**
     * 砍价初始价格
     */
    private BigDecimal bargainPrice;
    /**
     * 拼团价格（单位: 元）
     */
    private BigDecimal groupPrice;
    /**
     * 资料的状态：1---待审核   2---审核通过    3---审核未通过    4---售卖中   5---已下架
     */
    private Integer state;
    /**
     * 所属省份（填写省份id或者代号）
     */
    private Integer province;
    /**
     * 所属学校名称
     */
    private String school;
    /**
     * 专业名称
     */
    private String major;
    /**
     * 资料价值分
     */
    private Double goodsValueScore;
    /**
     * 答疑速度分
     */
    private Double answerSpeedScore;
    /**
     * 老师服务分
     */
    private Double teacherServiceScore;
    /**
     * 描述相符度分
     */
    private Double introduceMatchScore;
    /**
     * 快递费用
     */
    private BigDecimal expPrice;
    /**
     * 上传日期
     */
    private Date uploadDate;
    /**
     * 审核通过日期
     */
    private Date checkDate;
    /**
     * 拒绝原因
     */
    private String reason;


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

    public String getMaterialField() {
        return materialField;
    }

    public void setMaterialField(String materialField) {
        this.materialField = materialField;
    }

    public String getMaterialSubject() {
        return materialSubject;
    }

    public void setMaterialSubject(String materialSubject) {
        this.materialSubject = materialSubject;
    }

    public Integer getMaterialPageCount() {
        return materialPageCount;
    }

    public void setMaterialPageCount(Integer materialPageCount) {
        this.materialPageCount = materialPageCount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getFromType() {
        return fromType;
    }

    public void setFromType(Integer fromType) {
        this.fromType = fromType;
    }

    public Integer getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Integer materialType) {
        this.materialType = materialType;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(BigDecimal bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public BigDecimal getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(BigDecimal groupPrice) {
        this.groupPrice = groupPrice;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getGoodsValueScore() {
        return goodsValueScore;
    }

    public void setGoodsValueScore(Double goodsValueScore) {
        this.goodsValueScore = goodsValueScore;
    }

    public Double getAnswerSpeedScore() {
        return answerSpeedScore;
    }

    public void setAnswerSpeedScore(Double answerSpeedScore) {
        this.answerSpeedScore = answerSpeedScore;
    }

    public Double getTeacherServiceScore() {
        return teacherServiceScore;
    }

    public void setTeacherServiceScore(Double teacherServiceScore) {
        this.teacherServiceScore = teacherServiceScore;
    }

    public Double getIntroduceMatchScore() {
        return introduceMatchScore;
    }

    public void setIntroduceMatchScore(Double introduceMatchScore) {
        this.introduceMatchScore = introduceMatchScore;
    }

    public BigDecimal getExpPrice() {
        return expPrice;
    }

    public void setExpPrice(BigDecimal expPrice) {
        this.expPrice = expPrice;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    protected Serializable pkVal() {
        return this.materialId;
    }

    @Override
    public String toString() {
        return "Material{" +
        ", materialId=" + materialId +
        ", materialName=" + materialName +
        ", materialField=" + materialField +
        ", materialSubject=" + materialSubject +
        ", materialPageCount=" + materialPageCount +
        ", describe=" + describe +
        ", fromType=" + fromType +
        ", materialType=" + materialType +
        ", hostId=" + hostId +
        ", resourceId=" + resourceId +
        ", retailPrice=" + retailPrice +
        ", salePrice=" + salePrice +
        ", bargainPrice=" + bargainPrice +
        ", groupPrice=" + groupPrice +
        ", state=" + state +
        ", province=" + province +
        ", school=" + school +
        ", major=" + major +
        ", goodsValueScore=" + goodsValueScore +
        ", answerSpeedScore=" + answerSpeedScore +
        ", teacherServiceScore=" + teacherServiceScore +
        ", introduceMatchScore=" + introduceMatchScore +
        ", expPrice=" + expPrice +
        ", uploadDate=" + uploadDate +
        ", checkDate=" + checkDate +
        ", reason=" + reason +
        "}";
    }
}
