package com.hu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hu.dao.RegisterDAO;
import com.hu.entity.RegisterEntity;
import com.hu.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class registerImpl extends ServiceImpl<RegisterDAO,RegisterEntity> implements RegisterService {

    @Resource
    private RegisterDAO dao;

    @Override
    public List<RegisterEntity> getAll(RegisterEntity register) {
        return this.dao.getAll(register);
    }

    @Override
    public void registerAdd(RegisterEntity register) {
        this.dao.registerAdd(register);
    }

    @Override
    public RegisterEntity registerOne(int rid) {
        return this.dao.registerOne(rid);
    }

    @Override
    public void registerUpd(RegisterEntity register) {
        this.dao.registerUpd(register);
    }

    @Override
    public void registerDel(int rid) {
        this.dao.registerDel(rid);
    }

    @Override
    public int registerCkName(String name) {
        return this.dao.registerCkName(name);
    }
}
