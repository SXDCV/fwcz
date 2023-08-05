package com.hu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hu.entity.JobEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobDAO extends BaseMapper<JobEntity> {

    //查询全部
    public List<JobEntity> jobAll();

    //分页查询全部
    public List<JobEntity> getAll(JobEntity job);

    //新增岗位信息
    public void jobAdd(JobEntity job);

    //查询单个岗位信息
    public JobEntity jobOne(int jid);

    //修改岗位信息
    public void jobUpd(JobEntity job);

    //删除岗位信息
    public void jobDel(int jid);

    //查询重复项
    public int jobCkName(String jname);
}
