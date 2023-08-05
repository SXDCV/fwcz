package com.hu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hu.entity.JobEntity;

import java.util.List;

public interface JobService extends IService<JobEntity> {

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
