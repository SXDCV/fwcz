package com.hu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hu.entity.SortEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SortDAO extends BaseMapper<SortEntity> {

    //全查询
    public List<SortEntity> SortAll();

    public List<SortEntity> getAll(SortEntity sort);

    //新增房屋类别信息
    public void sortAdd(SortEntity sort);

    //查询单个房屋类别信息
    public SortEntity sortOne(int sid);

    //修改房屋类别信息
    public void sortUpd(SortEntity sort);

    //删除房屋类别信息
    public void sortDel(int sid);

    //查询重复项
    public int sortCkName(String sname);

}
