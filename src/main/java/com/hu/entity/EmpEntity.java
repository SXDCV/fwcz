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
@TableName("emp")
@EqualsAndHashCode(callSuper = true)
public class EmpEntity extends MyPageVO implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer eid;
    @TableField("id")
    private Integer id;
    @TableField("jid")
    private Integer jid;
    @TableField("ename")
    private String ename;
    @TableField("epwd")
    private String epwd;
    @TableField("erealname")
    private String erealname;
    @TableField("etel")
    private String etel;
    @TableField("eaddress")
    private String eaddress;
    @TableField("eflag")
    private Integer eflag;
    @TableField("eremark")
    private String eremark;
    @TableField(exist = false)
    private String pname;
    @TableField(exist = false)
    private String jname;
    @TableField(exist = false)
    private String flagname;
    @TableField(exist = false)
    private String avatar;


}
