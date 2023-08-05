package com.hu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.hu.entity.EmpEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpDAO extends BaseMapper<EmpEntity> {


    // 用户登陆
    public int getLogin(EmpEntity emp);

    public EmpEntity getOneInfo(EmpEntity emp);

    public List<EmpEntity> getAll(EmpEntity emp);

    //新增员工信息
    public void empAdd(EmpEntity emp);

    //查询单个员工信息
    public EmpEntity empOne(int eid);

    //修改员工信息
    public void empUpd(EmpEntity emp);

    //删除员工信息
    public void empDel(int eid);

    //查询重复项
    public int empCkName(EmpEntity emp);

}
