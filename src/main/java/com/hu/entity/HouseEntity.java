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
@TableName("house")
@EqualsAndHashCode(callSuper = true)
public class HouseEntity extends MyPageVO implements Serializable {
    @TableId(type= IdType.AUTO)
    private int hid;

    @TableField("sid")
    private int sid;

    @TableField("aid")
    private int aid;

    @TableField("haddress")
    private String haddress;

    @TableField("hnumber")
    private String hnumber;

    @TableField("htype")
    private String htype;

    @TableField("harea")
    private String harea;

    @TableField("direction")
    private String direction;

    @TableField("hmoney")
    private float hmoney;

    @TableField("networkmoney")
    private float networkmoney;

    @TableField("electricmoney")
    private float electricmoney;

    @TableField("watermoney")
    private float watermoney;

    @TableField("gasmoney")
    private float gasmoney;

    @TableField("electricnumber")
    private float electricnumber;

    @TableField("waternumber")
    private float waternumber;

    @TableField("gesnumber")
    private float gesnumber;

    @TableField("hname")
    private String hname;

    @TableField("hremark")
    private String hremark;

    @TableField("himg")
    private String himg;

    @TableField("hflag")
    private int hflag;

    @TableField(exist = false)
    private String sname;
    @TableField(exist = false)
    private String aname;
    @TableField(exist = false)
    private String flagname;
    @TableField(exist = false)
    private String []imgs;

}
