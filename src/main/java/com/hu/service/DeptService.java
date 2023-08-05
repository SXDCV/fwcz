package com.hu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hu.entity.DeptEntity;
import com.hu.entity.MyDeptEntity;

import java.util.List;

public interface DeptService extends IService<DeptEntity> {

    //查询全部
    public List<DeptEntity> getAll();

   /* public List<DeptEntity> deptAll();*/

    /*******树形*******/
    public List<MyDeptEntity> DeptAll();
}
