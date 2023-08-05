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
@TableName("area")
@EqualsAndHashCode(callSuper = true)
public class AreaEntity extends MyPageVO implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer aid;
    @TableField("aname")
    private String aname;


}
