package com.hu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hu.dao.DeptDAO;
import com.hu.entity.DeptEntity;
import com.hu.entity.MyDeptEntity;
import com.hu.service.DeptService;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeptImpl extends ServiceImpl<DeptDAO, DeptEntity> implements DeptService {

    @Resource
    private DeptDAO dao;

    @Override
    public List<DeptEntity> getAll() {

        return this.dao.getAll();
    }


    public List<MyDeptEntity> DeptAll() {
        List<DeptEntity> DeptEntityList = this.dao.deptAll();

        List<MyDeptEntity> ar = new ArrayList<MyDeptEntity>();

        for (DeptEntity deptEntity : DeptEntityList) {
            int id = deptEntity.getId();
            int pid = deptEntity.getPid();
            String label = deptEntity.getLabel();

            MyDeptEntity myp = new MyDeptEntity();
            myp.setLabel(label);
            myp.setPid(pid);
            myp.setValue(id);

            ar.add(myp);
        }

        // 将最终地查询结果存放到这个新地集合中
        List<MyDeptEntity> newDeptEntityList = new ArrayList<MyDeptEntity>();
        List<Integer> stringArrayList = new ArrayList<Integer>();

        for (MyDeptEntity DeptEntity : ar)
        {
            // 存放部门编号
            stringArrayList.add(DeptEntity.getValue());
        }

        // 判断查出来的数据是否为空
        for (Iterator<MyDeptEntity> iterator = ar.iterator(); iterator.hasNext();)
        {
            MyDeptEntity DeptEntity = iterator.next();
            // 判断DeptEntityList 不包含部门父级id
            if (!stringArrayList.contains(DeptEntity.getPid()))
            {
                recursionFnD(ar, DeptEntity);
                newDeptEntityList.add(DeptEntity);
            }
        }

        if (newDeptEntityList.isEmpty())
        {
            newDeptEntityList = ar;
        }

        List<MyDeptEntity> finallDeptEntitysList = newDeptEntityList.stream().filter(DeptEntity ->
        {
            Integer pid = 0;
            return DeptEntity.getPid() == pid;
        }).collect(Collectors.toList());

        return finallDeptEntitysList;
    }
    private void recursionFnD(List<MyDeptEntity> DeptEntityList, MyDeptEntity DeptEntity)
    {
        List<MyDeptEntity> childList = getChildListD(DeptEntityList, DeptEntity);
        DeptEntity.setChildren(childList);
        // 在遍历的到子节点的数据，判断子节点下是否还存有子节点
        for (MyDeptEntity depart : childList)
        {
            // 如果子节点中的数据依然拥有子节点,重新调用递归
            if (hasChild(DeptEntityList, depart))
            {
                recursionFnD(DeptEntityList, depart);
            }
        }
    }

    private List<MyDeptEntity> getChildListD(List<MyDeptEntity> list, MyDeptEntity t)
    {
        ArrayList<MyDeptEntity> tlist = new ArrayList<MyDeptEntity>();
        // 遍历集合中的数据
        Iterator<MyDeptEntity> iterator = list.iterator();
        while (iterator.hasNext())
        {
            MyDeptEntity next = iterator.next();
            if (!StringUtils.isEmpty(next.getPid()) && next.getPid() == t.getValue())
            {
                tlist.add(next);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<MyDeptEntity> list, MyDeptEntity t)
    {
        return getChildListD(list, t).size() > 0;
    }
}
