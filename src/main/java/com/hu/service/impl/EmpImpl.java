package com.hu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hu.dao.EmpDAO;
import com.hu.entity.EmpEntity;
import com.hu.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpImpl extends ServiceImpl<EmpDAO, EmpEntity> implements EmpService {

    @Resource
    private EmpDAO dao;

    @Override
    public int getLogin(EmpEntity emp) {
        return this.dao.getLogin(emp);
    }

    @Override
    public EmpEntity getOneInfo(EmpEntity emp) {
        return this.dao.getOneInfo(emp);
    }

    @Override
    public List<EmpEntity> getAll(EmpEntity emp) {

        return this.dao.getAll(emp);
    }

    @Override
    public void empAdd(EmpEntity emp) {
        this.dao.empAdd(emp);
    }

    @Override
    public EmpEntity empOne(int eid) {
        return this.dao.empOne(eid);
    }

    @Override
    public void empUpd(EmpEntity emp) {
        this.dao.empUpd(emp);
    }

    @Override
    public void empDel(int eid) {
        this.dao.empDel(eid);
    }

    @Override
    public int empCkName(EmpEntity emp) {

        return this.dao.empCkName(emp);
    }
}
