package com.hu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hu.dao.CusDAO;
import com.hu.entity.CusEntity;
import com.hu.service.CusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CusImpl extends ServiceImpl<CusDAO, CusEntity> implements CusService {

    @Resource
    private CusDAO dao;

    @Override
    public List<CusEntity> getAll(CusEntity cus) {
        return this.dao.getAll(cus);
    }

    @Override
    public void cusAdd(CusEntity cus) {
        this.dao.cusAdd(cus);
    }

    @Override
    public CusEntity cusOne(int cid) {
        return this.dao.cusOne(cid);
    }

    @Override
    public void cusUpd(CusEntity cus) {
        this.dao.cusUpd(cus);
    }

    @Override
    public void cusDel(int cid) {
        this.dao.cusDel(cid);
    }

    @Override
    public int cusCkName(String name) {
        return this.dao.cusCkName(name);
    }
}
