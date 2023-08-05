package com.hu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hu.entity.CusEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CusDAO extends BaseMapper<CusEntity> {

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
