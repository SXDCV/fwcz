package com.hu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hu.entity.AreaEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaDAO extends BaseMapper<AreaEntity> {

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
