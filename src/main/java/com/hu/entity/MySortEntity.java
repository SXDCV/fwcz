package com.hu.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class MySortEntity implements Serializable {
    private Integer value;
    private String label;
    private Integer id;

    private List<MySortEntity> children;

}
