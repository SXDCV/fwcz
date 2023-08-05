package com.hu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hu.entity.EmpEntity;
import com.hu.service.EmpService;
import com.hu.util.Myroute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("emp.do")
public class EmpController {

    @Resource
    private EmpService empservice;

    /*Vue前端员工全查询*/
    @RequestMapping(params = "method=getAll")
    @ResponseBody
    public void getAll(HttpServletResponse response, EmpEntity emp){

            //分页计算
            Myroute.CPages(emp);

            // 注意跨域问题解决
            Myroute.route(response);


            int count = empservice.count();// 共有多少条
            List<EmpEntity> ar = empservice.getAll(emp);// 分页的结果集
            for (EmpEntity a:ar) {
                if (a.getEflag()==1){
                    a.setFlagname("在职");
                }else{
                    a.setFlagname("离职");
                }
            }
            //返回前端的值
            Myroute.PutMap(response,count,ar);


    }

    /*Vue前端员工新增*/
    @RequestMapping(params = "method=empAdd")
    @ResponseBody
    public void empAdd(HttpServletResponse response, EmpEntity emp){

            // 注意跨域问题解决
            Myroute.route(response);

            boolean count = empservice.save(emp);

            //返回前端的值
            Myroute.PutMap(response,0,count);


    }

    /*Vue前端员工单查询*/
    @RequestMapping(params = "method=empOne")
    @ResponseBody
    public void empOne(HttpServletResponse response, int eid){

            // 注意跨域问题解决
            Myroute.route(response);

            EmpEntity emp = empservice.empOne(eid);

            //返回前端的值
            Myroute.PutMap(response,0,emp);


    }

    /*Vue前端员工修改*/
    @RequestMapping(params = "method=empUpd")
    @ResponseBody
    public void empUpd(HttpServletResponse response, EmpEntity emp){
        System.out.println(1111);
            // 注意跨域问题解决
            Myroute.route(response);


            boolean count = empservice.updateById(emp);

            //返回前端的值
            Myroute.PutMap(response,0,count);

    }

    /*Vue前端员工删除*/
    @RequestMapping(params = "method=empDel")
    @ResponseBody
    public void empDel(HttpServletResponse response, int eid){

            // 注意跨域问题解决
            Myroute.route(response);

            //调用删除方法
            empservice.empDel(eid);

            //返回前端的值
            Myroute.PutMap(response,0,1);
    }


    /*Vue前端员工查询重复项*/
    @RequestMapping(params = "method=empCkName")
    @ResponseBody
    public void empCkName(HttpServletResponse response, EmpEntity emp){

            // 注意跨域问题解决
            Myroute.route(response);

            QueryWrapper<EmpEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("ename", emp.getEname());

            int count = empservice.count(wrapper);

            QueryWrapper<EmpEntity> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("etel", emp.getEtel());

            int count1 = empservice.count(wrapper1);

            Map<String, Object> map = new HashMap<String, Object>();
            if (count == 1) {
                //返回前端的值
                Myroute.PutMap(response, 0, 1);
            } else if (count1 == 1) {
                //返回前端的值
                Myroute.PutMap(response, 0, 1);
            } else {
                //返回前端的值
                Myroute.PutMap(response, 0, 0);
            }



    }

}

