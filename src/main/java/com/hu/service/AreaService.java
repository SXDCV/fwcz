package com.hu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hu.entity.AreaEntity;
import com.hu.entity.AreaEntity;

import java.util.List;


public interface AreaService extends IService<AreaEntity> {

    public List<AreaEntity> getAll(AreaEntity area);

    //新增片区信息
    public void areaAdd(AreaEntity area);

    //查询单个片区信息
    public AreaEntity areaOne(int aid);

    //修改片区信息
    public void areaUpd(AreaEntity area);

    //删除片区信息
    public void areaDel(int aid);

    //查询重复项
    public int areaCkName(String aname);

}
