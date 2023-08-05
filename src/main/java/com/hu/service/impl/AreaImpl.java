package com.hu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hu.dao.AreaDAO;
import com.hu.dao.DeptDAO;
import com.hu.entity.AreaEntity;
import com.hu.entity.DeptEntity;
import com.hu.service.AreaService;
import com.hu.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AreaImpl extends ServiceImpl<AreaDAO, AreaEntity> implements AreaService {

    @Resource
    private AreaDAO dao;

    @Override
    public List<AreaEntity> getAll(AreaEntity area) {
        return this.dao.getAll(area);
    }

    @Override
    public void areaAdd(AreaEntity area) {
        this.dao.areaAdd(area);
    }

    @Override
    public AreaEntity areaOne(int aid) {
        return this.dao.areaOne(aid);
    }

    @Override
    public void areaUpd(AreaEntity area) {
        this.dao.areaUpd(area);
    }

    @Override
    public void areaDel(int aid) {
        this.dao.areaDel(aid);
    }

    @Override
    public int areaCkName(String aname) {
        return this.dao.areaCkName(aname);
    }
}
