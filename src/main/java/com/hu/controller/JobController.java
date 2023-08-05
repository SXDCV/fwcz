package com.hu.controller;

import com.hu.entity.JobEntity;
import com.hu.service.JobService;
import com.hu.util.Myroute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("job.do")
public class JobController {

    @Resource
    private JobService jobservice;

    /**********Vue前端查询**********/
    @RequestMapping(params = "method=jobAll")
    @ResponseBody
    public void jobAll(HttpServletResponse response){

            // 注意跨域问题解决
            Myroute.route(response);


            List<JobEntity> ar = jobservice.jobAll();// 分页的结果集

            //返回前端的值
            Myroute.PutMap(response,0,ar);

    }

    /**********Vue前端分页查询**********/
    @RequestMapping(params = "method=getAll")
    @ResponseBody
    public void getAll(HttpServletResponse response, JobEntity job){

        //分页计算
        Myroute.CPages(job);

        // 注意跨域问题解决
        Myroute.route(response);

        int count = jobservice.count();// 共有多少条
        List<JobEntity> ar = jobservice.getAll(job);// 分页的结果集

        //返回前端的值
        Myroute.PutMap(response, count, ar);

    }

    /**********Vue前端新增**********/
    @RequestMapping(params = "method=jobAdd")
    @ResponseBody
    public void jobAdd(HttpServletResponse response, JobEntity job){

        // 注意跨域问题解决
        Myroute.route(response);


        boolean count = jobservice.save(job);
        //返回前端的值
        Myroute.PutMap(response, 0, count);

    }

    /**********Vue前端查询单个**********/
    @RequestMapping(params = "method=jobOne")
    @ResponseBody
    public void jobOne(HttpServletResponse response, int jid){
        System.out.println(jid);

        // 注意跨域问题解决
        Myroute.route(response);


        JobEntity ar = jobservice.jobOne(jid);

        //返回前端的值
        Myroute.PutMap(response, 0, ar);

    }

    /**********Vue前端修改**********/
    @RequestMapping(params = "method=jobUpd")
    @ResponseBody
    public void jobUpd(HttpServletResponse response, JobEntity job){

        // 注意跨域问题解决
        Myroute.route(response);


        boolean count = jobservice.updateById(job);

        //返回前端的值
        Myroute.PutMap(response, 0, count);

    }

    /**********Vue前端删除单个**********/
    @RequestMapping(params = "method=jobDel")
    @ResponseBody
    public void jobDel(HttpServletResponse response, int jid){

        // 注意跨域问题解决
        Myroute.route(response);


        jobservice.jobDel(jid);

        //返回前端的值
        Myroute.PutMap(response, 0, 1);

    }

    /**********Vue前端查询重复项**********/
    @RequestMapping(params = "method=jobCkName")
    @ResponseBody
    public void jobCkName(HttpServletResponse response, String jname){

        // 注意跨域问题解决
        Myroute.route(response);

        int count = jobservice.jobCkName(jname);

        //返回前端的值
        Myroute.PutMap(response, 0, count);

    }
}
