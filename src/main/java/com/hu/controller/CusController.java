package com.hu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hu.entity.CusEntity;
import com.hu.service.CusService;
import com.hu.util.Myroute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("cus")
public class CusController {
    
    @Resource
    private CusService cusService;

    /* Vue前端片区全查询*/
    @RequestMapping("getAll")
    @ResponseBody
    public void getAll(HttpServletResponse response, CusEntity cus) {

        //分页计算
        Myroute.CPages(cus);

        // 注意跨域问题解决
        Myroute.route(response);

        int count = cusService.count();// 共有多少条
        List<CusEntity> ar = cusService.getAll(cus);// 分页的结果集

        //返回前端值
        Myroute.PutMap(response, count, ar);
    }

    /* Vue前端片区新增*/
    @RequestMapping("cusAdd")
    @ResponseBody
    public void cusAdd(HttpServletResponse response, CusEntity cus) {

        // 注意跨域问题解决
        Myroute.route(response);

        boolean count = cusService.save(cus);

        //返回前端值
        Myroute.PutMap(response, 0, count);
    }

    /* Vue前端片区单查询*/
    @RequestMapping("cusOne")
    @ResponseBody
    public void cusOne(HttpServletResponse response, int cid) {

        // 注意跨域问题解决
        Myroute.route(response);

        CusEntity cus = cusService.cusOne(cid);

        //返回前端值
        Myroute.PutMap(response, 0, cus);
    }

    /* Vue前端片区修改*/
    @RequestMapping("cusUpd")
    @ResponseBody
    public void cusUpd(HttpServletResponse response, CusEntity cus) {

        // 注意跨域问题解决
        Myroute.route(response);

        boolean count = cusService.updateById(cus);

        //返回前端值
        Myroute.PutMap(response, 0, count);
    }

    /* Vue前端片区删除*/
    @RequestMapping("cusDel")
    @ResponseBody
    public void cusDel(HttpServletResponse response, int cid) {

        // 注意跨域问题解决
        Myroute.route(response);

        cusService.cusDel(cid);

        //返回前端值
        Myroute.PutMap(response, 0, 1);
    }

    /* Vue前端片区查询重复项*/
    @RequestMapping("cusCkName")
    @ResponseBody
    public void cusCkName(HttpServletResponse response, CusEntity cus) {

        // 注意跨域问题解决
        Myroute.route(response);

        QueryWrapper<CusEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("ctel", cus.getCtel());
        int count1 = cusService.count(wrapper);

        QueryWrapper<CusEntity> wrapper1=new QueryWrapper<>();
        wrapper1.eq("cteltwo", cus.getCteltwo());
        int count2 = cusService.count(wrapper1);

        QueryWrapper<CusEntity> wrapper2=new QueryWrapper<>();
        wrapper2.eq("ccard", cus.getCcard());
        int count3 = cusService.count(wrapper2);

        Map<String, Object> map = new HashMap<String, Object>();

        if (count1==1||count2==1||count3==1){
            //返回前端值
            Myroute.PutMap(response, 0, 1);
        }else{
            //返回前端值
            Myroute.PutMap(response, 0, 0);
        }




    }
}
