package com.hu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hu.entity.RegisterEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RegisterDAO extends BaseMapper<RegisterEntity> {
    
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
