package com.hu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hu.util.MyPageVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;


@Data
@TableName("dept")
@EqualsAndHashCode(callSuper = true)
public class DeptEntity extends MyPageVO implements Serializable {

    @TableId(type= IdType.AUTO)
    private int id;
    @TableField("pname")
    private String pname;
    @TableField("pflag")
    private int pflag;
    @TableField("premark")
    private String premark;
    @TableField("pid")
    private int pid;
    @TableField(exist = false)
    private String label;
    @TableField(exist = false)
    private String name;
    @TableField(exist = false)
    private List<DeptEntity> children;
}
