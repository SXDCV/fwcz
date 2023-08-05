package com.hu.controller;


import com.hu.entity.SortEntity;
import com.hu.service.SortService;
import com.hu.util.Myroute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("sort.do")
public class SortController {

    @Resource
    private SortService sortservice;

    /*Vue前端房屋类型全查询*/
    @RequestMapping(params = "method=sortAll")
    @ResponseBody
    public void sortAll(HttpServletResponse response) {
        // 注意跨域问题解决
        Myroute.route(response);

        List<SortEntity> ar = sortservice.SortAll();
        //返回方法
        Myroute.PutMap(response,0,ar);


    }


    /*Vue前端房屋类型全查询*/
    @RequestMapping(params = "method=getAll")
    @ResponseBody
    public void getAll(HttpServletResponse response, SortEntity sort) {
        //分页
        Myroute.CPages(sort);

        // 注意跨域问题解决
        Myroute.route(response);

        int count = sortservice.count();// 共有多少条
        List<SortEntity> ar = sortservice.getAll(sort);// 分页的结果集
        //返回方法
        Myroute.PutMap(response,count,ar);


    }

    /*Vue前端房屋类型新增*/
    @RequestMapping(params = "method=sortAdd")
    @ResponseBody
    public void sortAdd(HttpServletResponse response, SortEntity sort){

            // 注意跨域问题解决
            Myroute.route(response);


            boolean count = sortservice.save(sort);
            //返回方法
            Myroute.PutMap(response,0,count);


    }

    /*Vue前端房屋类型单查询*/
    @RequestMapping(params = "method=sortOne")
    @ResponseBody
    public void sortOne(HttpServletResponse response, int sid){

            // 注意跨域问题解决
            Myroute.route(response);


            SortEntity sort = sortservice.sortOne(sid);
            //返回方法
            Myroute.PutMap(response,0,sort);


    }

    /*Vue前端房屋类型修改*/
    @RequestMapping(params = "method=sortUpd")
    @ResponseBody
    public void sortUpd(HttpServletResponse response, SortEntity sort){

            // 注意跨域问题解决
            Myroute.route(response);


            boolean count = sortservice.updateById(sort);
            //返回方法
            Myroute.PutMap(response,0,count);


    }

    /*Vue前端房屋类型删除*/
    @RequestMapping(params = "method=sortDel")
    @ResponseBody
    public void sortDel(HttpServletResponse response, int sid){
        System.out.println(sid);

            // 注意跨域问题解决
            Myroute.route(response);


            sortservice.sortDel(sid);
            //返回方法
            Myroute.PutMap(response,0,1);

    }


    /*Vue前端房屋类型查询重复项*/
    @RequestMapping(params = "method=sortCkName")
    @ResponseBody
    public void sortCkName(HttpServletResponse response, String sname){

            // 注意跨域问题解决
            Myroute.route(response);

            int count = sortservice.sortCkName(sname);
            //返回方法
            Myroute.PutMap(response,0,count);


    }


}

