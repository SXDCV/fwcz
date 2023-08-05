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
public class JobEntity extends MyPageVO implements Serializable {
    @TableId(type= IdType.AUTO)
    private int jid;
    @TableField("jname")
    private String jname;
}
