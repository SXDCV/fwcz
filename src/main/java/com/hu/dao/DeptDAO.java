package com.hu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hu.entity.DeptEntity;

import com.hu.entity.MyDeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDAO extends BaseMapper<DeptEntity> {

    //查询全部
    public List<DeptEntity> getAll();

    public List<DeptEntity> deptAll();

   /* *//*******树形*******//*
    List<MyDeptEntity> DeptAll();*/
}
