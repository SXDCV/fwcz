package com.hu.controller;


import com.hu.entity.AreaEntity;
import com.hu.service.AreaService;
import com.hu.util.Myroute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("area.do")
public class AreaController {

    @Resource
    private AreaService areaservice;

    /* Vue前端片区全查询*/
    @RequestMapping(params = "method=areaAll")
    @ResponseBody
    public void areaAll(HttpServletResponse response) {


        // 注意跨域问题解决
        Myroute.route(response);

        List<AreaEntity> ar = areaservice.list();

        //返回前端值
        Myroute.PutMap(response, 0, ar);
    }

    /* Vue前端片区全查询*/
    @RequestMapping(params = "method=getAll")
    @ResponseBody
    public void getAll(HttpServletResponse response, AreaEntity area) {

        //分页计算
        Myroute.CPages(area);

        // 注意跨域问题解决
        Myroute.route(response);

        int count = areaservice.count();// 共有多少条
        List<AreaEntity> ar = areaservice.getAll(area);// 分页的结果集

        //返回前端值
        Myroute.PutMap(response, count, ar);
    }

    /* Vue前端片区新增*/
    @RequestMapping(params = "method=areaAdd")
    @ResponseBody
    public void areaAdd(HttpServletResponse response, AreaEntity area) {

        // 注意跨域问题解决
        Myroute.route(response);

        boolean count = areaservice.save(area);

        //返回前端值
        Myroute.PutMap(response, 0, count);
    }

    /* Vue前端片区单查询*/
    @RequestMapping(params = "method=areaOne")
    @ResponseBody
    public void areaOne(HttpServletResponse response, int aid) {

        // 注意跨域问题解决
        Myroute.route(response);

        AreaEntity area = areaservice.areaOne(aid);

        //返回前端值
        Myroute.PutMap(response, 0, area);
    }

    /* Vue前端片区修改*/
    @RequestMapping(params = "method=areaUpd")
    @ResponseBody
    public void areaUpd(HttpServletResponse response, AreaEntity area) {

        // 注意跨域问题解决
        Myroute.route(response);

        boolean count = areaservice.updateById(area);

        //返回前端值
        Myroute.PutMap(response, 0, count);
    }

    /* Vue前端片区删除*/
    @RequestMapping(params = "method=areaDel")
    @ResponseBody
    public void areaDel(HttpServletResponse response, int aid) {

        // 注意跨域问题解决
        Myroute.route(response);

        areaservice.areaDel(aid);

        //返回前端值
        Myroute.PutMap(response, 0, 1);
    }

    /* Vue前端片区查询重复项*/
    @RequestMapping(params = "method=areaCkName")
    @ResponseBody
    public void areaCkName(HttpServletResponse response, String aname) {


        // 注意跨域问题解决
        Myroute.route(response);

        int count = areaservice.areaCkName(aname);

        //返回前端值
        Myroute.PutMap(response, 0, count);

    }

}

