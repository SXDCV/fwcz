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
@TableName("job")
@EqualsAndHashCode(callSuper = true)
public class RegisterEntity extends MyPageVO implements Serializable {
    @TableId(type= IdType.AUTO)
    private int rid;
    @TableField("rdate")
    private String rdate;
    @TableField("eid")
    private int eid;
    @TableField("cid")
    private int cid;
    @TableField("hid")
    private int hid;
    @TableField("timg")
    private String timg;
    @TableField("rdeposit")
    private int rdeposit;
    @TableField("rrent")
    private int rrent;
    @TableField("rflag")
    private int rflag;
    @TableField("rnexttime")
    private String rnexttime;

    @TableField(exist = false)
    private String ename;
    @TableField(exist = false)
    private String cname;
    @TableField(exist = false)
    private String hname;



}
