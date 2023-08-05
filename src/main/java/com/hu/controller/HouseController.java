package com.hu.controller;

import com.google.gson.Gson;
import com.hu.entity.HouseEntity;
import com.hu.service.HouseService;
import com.hu.util.MyUpload;
import com.hu.util.Myroute;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("house")
public class HouseController {

    @Value("${prop.upload-folder}")
    private String myupload;

    @Resource
    private HouseService houseService;
    /* Vue前端片区全查询*/
    @RequestMapping("getAll")
    @ResponseBody
    public void getAll(HttpServletResponse response, HouseEntity house){
        //分页计算
        Myroute.CPages(house);

        // 注意跨域问题解决
        Myroute.route(response);


        int count = houseService.count(house);// 共有多少条
        List<HouseEntity> ar = houseService.getAll(house);// 分页的结果集
        for (HouseEntity h : ar) {
            if (h.getHflag() == 1) {
                h.setFlagname("待出租");
            } else {
                h.setFlagname("已出租");
            }
        }

        Myroute.PutMap(response, count, ar);

    }

    /***********前端上传**************/
    @RequestMapping("add")
    @ResponseBody
    public void add(MultipartFile name, HttpServletRequest request, HttpServletResponse response) {
        String newname = "";
        try {
            // 注意跨域问题解决
            Myroute.route(response);
            // 判断文件是否为空，空则返回失败页面
            // 获取文件存储路径（绝对路径）
            String path = myupload;
            // 获取原文件名
            String fileName = name.getOriginalFilename();
            // 改名
            newname = MyUpload.getNewName(fileName);
            // 创建文件实例
            File filePath = new File(path, newname);
            // 如果文件目录不存在，创建目录
            if (!filePath.getParentFile().exists())
            {
                filePath.getParentFile().mkdirs();
            }
            // 写入文件
            name.transferTo(filePath);
            // 存库
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Map<String, Object> map = new HashedMap();
            map.put("code", 20000);
            map.put("count", new Integer(1));
            map.put("newname",newname);
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

    /**********Vue前端增加(确定提交 )************/
    @RequestMapping("houseAdd")
    @ResponseBody
    public void houseAdd(HouseEntity house, HttpServletResponse response)
    {

        // 注意跨域问题解决
        Myroute.route(response);
        boolean count = houseService.save(house);

        Myroute.PutMap(response, 0, count);

    }

    /**********Vue前端单查询************/
    @RequestMapping("houseOne")
    @ResponseBody
    public void houseOne(int hid, HttpServletResponse response)
    {

        // 注意跨域问题解决
        Myroute.route(response);
        HouseEntity ar = houseService.houseOne(hid);

        Myroute.PutMap(response, 0, ar);

    }

    /**********Vue前端修改(确定提交 )************/
    @RequestMapping("houseUpd")
    @ResponseBody
    public void houseUpd(HouseEntity house, HttpServletResponse response)
    {

        // 注意跨域问题解决
        Myroute.route(response);
        boolean count = houseService.updateById(house);

        Myroute.PutMap(response, 0, count);

    }

    /**********Vue前端删除(确定提交 )************/
    @RequestMapping("houseDel")
    @ResponseBody
    public void houseDel(int hid, HttpServletResponse response)
    {

        // 注意跨域问题解决
        Myroute.route(response);
        houseService.houseDel(hid);

        Myroute.PutMap(response, 0, 1);

    }
}
