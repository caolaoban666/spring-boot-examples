package com.test.entity.scient;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.sql.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zw
 * @since 2019-05-09
 */
@TableName("USER1")
public class User1 extends Model<User1> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId("ID")
    private Integer id;

    /**
     * 登陆名
     */
    @TableField("LOGIN_NAME")
    private String loginName;

    /**
     * 用户名
     */
    @TableField("NAME")
    private String name;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 密码加密盐
     */
    @TableField("SALT")
    private String salt;

    /**
     * 性别
     */
    @TableField("SEX")
    private Double sex;

    /**
     * 年龄
     */
    @TableField("AGE")
    private Double age;

    /**
     * 手机号
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 用户类别,0管理员
     */
    @TableField("USER_TYPE")
    private Double userType;

    /**
     * 用户状态
     */
    @TableField("STATUS")
    private Double status;

    /**
     * 所属机构
     */
    @TableField("ORGANIZATION_ID")
    private Double organizationId;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Double getSex() {
        return sex;
    }

    public void setSex(Double sex) {
        this.sex = sex;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getUserType() {
        return userType;
    }

    public void setUserType(Double userType) {
        this.userType = userType;
    }

    public Double getStatus() {
        return status;
    }

    public void setStatus(Double status) {
        this.status = status;
    }

    public Double getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Double organizationId) {
        this.organizationId = organizationId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User1{" +
        "id=" + id +
        ", loginName=" + loginName +
        ", name=" + name +
        ", password=" + password +
        ", salt=" + salt +
        ", sex=" + sex +
        ", age=" + age +
        ", phone=" + phone +
        ", userType=" + userType +
        ", status=" + status +
        ", organizationId=" + organizationId +
        ", createTime=" + createTime +
        "}";
    }
}
