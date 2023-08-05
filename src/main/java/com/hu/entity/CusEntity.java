package com.hu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hu.util.MyPageVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@Data
@TableName("cus")
@EqualsAndHashCode(callSuper = true)
public class CusEntity extends MyPageVO implements Serializable {
    @TableId(type = IdType.AUTO)
    private int cid;

    @TableField("eid")
    private int eid;

    @TableField("cname")
    private String cname;

    @TableField("csex")
    private String csex;

    @TableField("ctel")
    private String ctel;

    @TableField("cteltwo")
    private String cteltwo;

    @TableField("ccard")
    private String ccard;

    @TableField(exist = false)
    private String ename;

}
