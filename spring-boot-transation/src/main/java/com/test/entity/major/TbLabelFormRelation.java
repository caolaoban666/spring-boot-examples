package com.test.entity.major;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.sql.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zw
 * @since 2019-04-24
 */
@TableName("TB_LABEL_FORM_RELATION")
public class TbLabelFormRelation extends Model<TbLabelFormRelation> {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    @TableField("LABLE_ID")
    private String lableId;

    @TableField("FORM_ID")
    private String formId;

    @TableField("CREATE_TIME")
    private Date createTime;
    // mybatisplus 如果类型是 LocalDateTime 会报错。No typehandler found for property ，需要将日期类型改为 Date

    @TableField("UPDATE_TIME")
    private Date updateTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLableId() {
        return lableId;
    }

    public void setLableId(String lableId) {
        this.lableId = lableId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "TbLabelFormRelation{" +
        "id=" + id +
        ", lableId=" + lableId +
        ", formId=" + formId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
