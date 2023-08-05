package com.hu.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MyDeptEntity implements Serializable {

    private Integer value;
    private String label;
    private Integer pid;

    private List<MyDeptEntity> children;

}
