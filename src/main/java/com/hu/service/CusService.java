package com.hu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hu.entity.CusEntity;

import java.util.List;

public interface CusService extends IService<CusEntity> {

    //全查询
    public List<CusEntity> getAll(CusEntity cus);

    //新增片区信息
    public void cusAdd(CusEntity cus);

    //查询单个片区信息
    public CusEntity cusOne(int cid);

    //修改片区信息
    public void cusUpd(CusEntity cus);

    //删除片区信息
    public void cusDel(int cid);

    //查询重复项
    public int cusCkName(String name);
}
