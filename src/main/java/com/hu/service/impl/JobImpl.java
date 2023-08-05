package com.hu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hu.dao.JobDAO;
import com.hu.entity.JobEntity;
import com.hu.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JobImpl extends ServiceImpl<JobDAO, JobEntity> implements JobService {

    @Resource
    private JobDAO dao;

    @Override
    public List<JobEntity> jobAll() {
        return this.dao.jobAll();
    }

    @Override
    public List<JobEntity> getAll(JobEntity job) {

        return this.dao.getAll(job);
    }

    @Override
    public void jobAdd(JobEntity job) {
        this.dao.jobAdd(job);
    }

    @Override
    public JobEntity jobOne(int jid) {
        return this.dao.jobOne(jid);
    }

    @Override
    public void jobUpd(JobEntity job) {
    this.dao.jobUpd(job);
    }

    @Override
    public void jobDel(int jid) {
        this.dao.jobDel(jid);
    }

    @Override
    public int jobCkName(String jname) {
       return this.dao.jobCkName(jname);
    }
}
