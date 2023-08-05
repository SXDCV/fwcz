package com.hu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hu.entity.HouseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HouseDAO extends BaseMapper<HouseEntity> {

    //统计条数
    public int count(HouseEntity house);

    //查询全部
    public List<HouseEntity> getAll(HouseEntity house);

    //新增房屋信息
    public void houseAdd(HouseEntity house);

    //查询单个房屋信息
    public HouseEntity houseOne(int hid);

    //修改房屋信息
    public void houseUpd(HouseEntity house);

    //删除房屋信息
    public void houseDel(int hid);

    //查询重复项
    public int houseCkName(String name);
}
