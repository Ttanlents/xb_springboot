package com.yjf.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "user")
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //javascript:void(0);
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * QQ登录标识符
     */
    @Column(name = "qq_openid")
    private String qqOpenid;

    /**
     * 微信登录标识符
     */
    @Column(name = "wx_openid")
    private String wxOpenid;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别 1:男 0:女
     */
    private String gender;

    /**
     * 简介
     */
    private String info;

    /**
     * 注册时间
     */
    @Column(name = "register_time")
    private Date registerTime;

    /**
     * 上次登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 头像
     */
    private String pic;

    /**
     * 查看数
     */
    private Integer look;

    /**
     * 是否私密 0：私密 1：公开
     */
    @Column(name = "is_secret")
    private String isSecret;

    /**
     * 部门名称
     */
    @Column(name = "dept_name")
    private String deptName;

    /**
     * 部门id
     */
    @Column(name = "dept_id")
    private Integer deptId;

    @Transient
    private Integer focusCount; //我关注的人数量


    @Transient
    private Integer beenFocusCount; //我关注的人数量

    public Integer getBeenFocusCount() {
        return beenFocusCount;
    }

    public void setBeenFocusCount(Integer beenFocusCount) {
        this.beenFocusCount = beenFocusCount;
    }

    @Transient
    private List<Integer> focusIds; //我关注的人

    public List<Integer> getFocusIds() {
        return focusIds;
    }

    public void setFocusIds(List<Integer> focusIds) {
        this.focusIds = focusIds;
    }

    public Integer getFocusCount() {
        return focusCount;
    }

    public void setFocusCount(Integer focusCount) {
        this.focusCount = focusCount;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取QQ登录标识符
     *
     * @return qq_openid - QQ登录标识符
     */
    public String getQqOpenid() {
        return qqOpenid;
    }

    /**
     * 设置QQ登录标识符
     *
     * @param qqOpenid QQ登录标识符
     */
    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid;
    }

    /**
     * 获取微信登录标识符
     *
     * @return wx_openid - 微信登录标识符
     */
    public String getWxOpenid() {
        return wxOpenid;
    }

    /**
     * 设置微信登录标识符
     *
     * @param wxOpenid 微信登录标识符
     */
    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取性别 1:男 0:女
     *
     * @return gender - 性别 1:男 0:女
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别 1:男 0:女
     *
     * @param gender 性别 1:男 0:女
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取简介
     *
     * @return info - 简介
     */
    public String getInfo() {
        return info;
    }

    /**
     * 设置简介
     *
     * @param info 简介
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 获取注册时间
     *
     * @return register_time - 注册时间
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置注册时间
     *
     * @param registerTime 注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 获取上次登录时间
     *
     * @return login_time - 上次登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置上次登录时间
     *
     * @param loginTime 上次登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取头像
     *
     * @return pic - 头像
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置头像
     *
     * @param pic 头像
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 获取查看数
     *
     * @return look - 查看数
     */
    public Integer getLook() {
        return look;
    }

    /**
     * 设置查看数
     *
     * @param look 查看数
     */
    public void setLook(Integer look) {
        this.look = look;
    }

    /**
     * 获取是否私密 0：私密 1：公开
     *
     * @return is_secret - 是否私密 0：私密 1：公开
     */
    public String getIsSecret() {
        return isSecret;
    }

    /**
     * 设置是否私密 0：私密 1：公开
     *
     * @param isSecret 是否私密 0：私密 1：公开
     */
    public void setIsSecret(String isSecret) {
        this.isSecret = isSecret;
    }

    /**
     * 获取部门名称
     *
     * @return dept_name - 部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置部门名称
     *
     * @param deptName 部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取部门id
     *
     * @return dept_id - 部门id
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 设置部门id
     *
     * @param deptId 部门id
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", qqOpenid='" + qqOpenid + '\'' +
                ", wxOpenid='" + wxOpenid + '\'' +
                ", realName='" + realName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", info='" + info + '\'' +
                ", registerTime=" + registerTime +
                ", loginTime=" + loginTime +
                ", pic='" + pic + '\'' +
                ", look=" + look +
                ", isSecret='" + isSecret + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptId=" + deptId +
                ", focusCount=" + focusCount +
                ", beenFocusCount=" + beenFocusCount +
                ", focusIds=" + focusIds +
                '}';
    }
}