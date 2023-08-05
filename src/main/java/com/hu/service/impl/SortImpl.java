package com.hu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hu.dao.SortDAO;
import com.hu.entity.SortEntity;
import com.hu.service.SortService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SortImpl extends ServiceImpl<SortDAO, SortEntity> implements SortService {

    @Resource
    private SortDAO dao;


    @Override
    public List<SortEntity> SortAll() {
        return this.dao.SortAll();
    }

    @Override
    public List<SortEntity> getAll(SortEntity sort) {

        return this.dao.getAll(sort);
    }

    @Override
    public void sortAdd(SortEntity sort) {
        this.dao.sortAdd(sort);
    }

    @Override
    public SortEntity sortOne(int sid) {
        return this.dao.sortOne(sid);
    }

    @Override
    public void sortUpd(SortEntity sort) {
        this.dao.sortUpd(sort);
    }

    @Override
    public void sortDel(int sid) {
        this.dao.sortDel(sid);
    }

    @Override
    public int sortCkName(String sname) {
        return this.dao.sortCkName(sname);
    }
}
