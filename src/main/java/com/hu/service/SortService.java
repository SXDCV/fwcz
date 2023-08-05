package com.hu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hu.entity.SortEntity;

import java.util.List;


public interface SortService extends IService<SortEntity> {

    //全查询
    public List<SortEntity> SortAll();

    //分页查询
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
