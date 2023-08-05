package com.hu.controller;

import com.google.gson.Gson;
import com.hu.entity.AreaEntity;
import com.hu.entity.DeptEntity;
import com.hu.entity.JobEntity;
import com.hu.entity.MyDeptEntity;
import com.hu.service.DeptService;
import com.hu.service.JobService;
import com.hu.util.Myroute;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("dept.do")
@Scope("prototype")
public class DeptController {

    @Resource
    private DeptService deptservice;

    /* Vue前端片区全查询*/
    @RequestMapping(params = "method=getAll")
    @ResponseBody

    public void getAll(HttpServletResponse response){
        try {
            // 注意跨域问题解决
            Myroute.route(response);


            int count = deptservice.count();// 共有多少条
            List<DeptEntity> ar = deptservice.getAll();// 分页的结果集


            PrintWriter out = response.getWriter();
            Gson gson = new Gson();

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", 20000);
            map.put("data", ar);
            String json = gson.toJson(map);
            out.println(json);
            out.flush();
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // ***********************************形成多级联动结构***********************************//*
    @RequestMapping(params = "method=getAlla")
    @ResponseBody
    public void getAlla(HttpServletResponse response)
    {
        try
        {
            // 注意跨域问题解决
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "*");


            List<MyDeptEntity> ar = deptservice.DeptAll();
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Map<String, Object> map = new HashedMap();
            map.put("code", 20000);
            map.put("data", ar);

            String json = gson.toJson(map);
            out.println(json);
            out.flush();
            out.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
