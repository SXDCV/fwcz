package com.hu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hu.entity.RegisterEntity;

import java.util.List;

public interface RegisterService extends IService<RegisterEntity> {
    
    //查询全部
    public List<RegisterEntity> getAll(RegisterEntity register);

    //新增登记入住信息
    public void registerAdd(RegisterEntity register);

    //查询单个登记入住信息
    public RegisterEntity registerOne(int rid);

    //修改登记入住信息
    public void registerUpd(RegisterEntity register);

    //删除登记入住信息
    public void registerDel(int rid);

    //查询重复项
    public int registerCkName(String name);
}
