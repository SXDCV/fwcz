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


/**
 * <p>
 * 
 * </p>
 *
 * @author hu
 * @since 2023-06-09
 */
@Data
@TableName("sort")
@EqualsAndHashCode(callSuper = true)
public class SortEntity extends MyPageVO implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer sid;
    @TableField("sname")
    private String sname;
    @TableField(exist = false)
    private String label;
    @TableField(exist = false)
    private String name;
    @TableField(exist = false)
    private List<SortEntity> children;


}
