package com.test.entity.major;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author cyf
 * @since 2019-05-28
 */
@TableName("TB_LABEL_RELATION")
public class TbLabelRelation extends Model<TbLabelRelation> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.UUID)
//    @TableField("ID")
    private String id;

    /**
     * 标签id，关联tb_label
     */
    @TableField("LABEL_ID")
    private String labelId;

    @TableField("HIS_ID")
    private String hisId;

    /**
     * 关联当前表的id
     */
    @TableField("RELATION_ID")
    private String relationId;

//    @TableField("CREATE_TIME")
//    private LocalDateTime createTime;
//
//    @TableField("UPDATE_TIME")
//    private LocalDateTime updateTime;

    @TableField("DB_ID")
    private String dbId;

    /**
     * 身份证号
     */
    @TableField("IDENTITY_NO")
    private String identityNo;

    /**
     * 标签生效范围  0-所有就诊 1- 本次就诊
     */
    @TableField("VALID_RANGE")
    private String validRange;

    /**
     * 0-标签管理标记为标签 1-选择供受体时被自动标记为供受体，如果关系解除，则删除此记录。
     */
    @TableField("STATUS")
    private String status;

    @TableField("CUSTOM1")
    private String custom1;

    @TableField("CUSTOM2")
    private String custom2;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getHisId() {
        return hisId;
    }

    public void setHisId(String hisId) {
        this.hisId = hisId;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

//    public LocalDateTime getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(LocalDateTime createTime) {
//        this.createTime = createTime;
//    }
//
//    public LocalDateTime getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(LocalDateTime updateTime) {
//        this.updateTime = updateTime;
//    }

    public String getDbId() {
        return dbId;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getValidRange() {
        return validRange;
    }

    public void setValidRange(String validRange) {
        this.validRange = validRange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "TbLabelRelation{" +
                "id=" + id +
                ", labelId=" + labelId +
                ", hisId=" + hisId +
                ", relationId=" + relationId +
//        ", createTime=" + createTime +
//        ", updateTime=" + updateTime +
                ", dbId=" + dbId +
                ", identityNo=" + identityNo +
                ", validRange=" + validRange +
                ", status=" + status +
                ", custom1=" + custom1 +
                ", custom2=" + custom2 +
                "}";
    }
}
