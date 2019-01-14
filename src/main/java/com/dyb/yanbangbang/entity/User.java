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
 * @since 2019-01-03
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一标识，主键，自增
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    /**
     * 用户名，用于登录
     */
    private String userName;
    /**
     * 用户密码，用于登录
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 性别：1---男       2----女
     */
    private Integer gender;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    private String avatarurl;
    /**
     * 地址
     */
    private String address;
    /**
     * 用户昵称
     */
    private String nikeName;
    /**
     * 本科学校名称
     */
    private String uSchool;
    /**
     * 用户的上级id（邀请者的id）
     */
    private Integer pid;
    /**
     * 目前所在学校名称
     */
    private String school;
    /**
     * 本科专业
     */
    private String uMajor;
    /**
     * 现在所学专业
     */
    private String major;
    /**
     * 专业课成绩
     */
    private Double majorScore;
    /**
     * 用户在小程序端的唯一标识
     */
    private String openid;
    /**
     * 用户在微信开放平台的唯一标识
     */
    private String unionid;
    /**
     * 账号状态：1---待审核    2---可用（老师和校代审核通过变为可用状态，学生创建时直接为可用状态）    3---禁用
     */
    private Integer state;
    /**
     * 用户类型：0----超级管理员    1----学生     2----老师     3----校园代理
     */
    private Integer type;
    /**
     * 邀请码，代理身份该字段有值
     */
    private String inviteCode;
    /**
     * 个人简介
     */
    private String introduction;
    /**
     * 身份证正反面的照片（外键资源主表的id）
     */
    private Integer idcardImg;
    /**
     * 专业课成绩证明图片（外键资源主表id）
     */
    private Integer majorScoreImg;
    /**
     * 学生证或录取通知书图片（外键资源主表id）
     */
    private Integer stuCardOrOfferImg;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getuSchool() {
        return uSchool;
    }

    public void setuSchool(String uSchool) {
        this.uSchool = uSchool;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getuMajor() {
        return uMajor;
    }

    public void setuMajor(String uMajor) {
        this.uMajor = uMajor;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getMajorScore() {
        return majorScore;
    }

    public void setMajorScore(Double majorScore) {
        this.majorScore = majorScore;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getIdcardImg() {
        return idcardImg;
    }

    public void setIdcardImg(Integer idcardImg) {
        this.idcardImg = idcardImg;
    }

    public Integer getMajorScoreImg() {
        return majorScoreImg;
    }

    public void setMajorScoreImg(Integer majorScoreImg) {
        this.majorScoreImg = majorScoreImg;
    }

    public Integer getStuCardOrOfferImg() {
        return stuCardOrOfferImg;
    }

    public void setStuCardOrOfferImg(Integer stuCardOrOfferImg) {
        this.stuCardOrOfferImg = stuCardOrOfferImg;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "User{" +
        ", userId=" + userId +
        ", userName=" + userName +
        ", password=" + password +
        ", phone=" + phone +
        ", gender=" + gender +
        ", name=" + name +
        ", age=" + age +
        ", avatarurl=" + avatarurl +
        ", address=" + address +
        ", nikeName=" + nikeName +
        ", uSchool=" + uSchool +
        ", pid=" + pid +
        ", school=" + school +
        ", uMajor=" + uMajor +
        ", major=" + major +
        ", majorScore=" + majorScore +
        ", openid=" + openid +
        ", unionid=" + unionid +
        ", state=" + state +
        ", type=" + type +
        ", inviteCode=" + inviteCode +
        ", introduction=" + introduction +
        ", idcardImg=" + idcardImg +
        ", majorScoreImg=" + majorScoreImg +
        ", stuCardOrOfferImg=" + stuCardOrOfferImg +
        "}";
    }
}
