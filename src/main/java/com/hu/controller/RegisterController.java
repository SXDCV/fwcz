package com.hu.controller;

import com.hu.entity.RegisterEntity;
import com.hu.service.RegisterService;
import com.hu.util.Myroute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Resource
    private RegisterService registerService;

    /********* Vue全查询 ************/
    @RequestMapping("getAll")
    @ResponseBody
    public void getAll(HttpServletResponse response, RegisterEntity register){

        //分页计算
        Myroute.CPages(register);

        //跨域问题
        Myroute.route(response);

        //统计条数
        int count = registerService.count();
        List<RegisterEntity> ar = registerService.getAll(register);

        //获取所需变量返回至前端
        Myroute.PutMap(response,count,ar);
    }

    /*Vue前端登记入住新增*/
    @RequestMapping("registerAdd")
    @ResponseBody
    public void registerAdd(HttpServletResponse response,RegisterEntity register){

        //解决跨域问题
        Myroute.route(response);

        boolean count = registerService.save(register);

        //返回前端值
        Myroute.PutMap(response, 0, count);
    }


}
