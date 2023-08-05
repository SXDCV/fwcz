package com.hu.util;

import com.google.gson.Gson;
import org.apache.commons.collections.map.HashedMap;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class Myroute {

    public static void main(HttpServletResponse response) {

    }
    // 跨域问题解决
    public static  void route(HttpServletResponse response){

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "*");

    }

    //返回至前端的值
    public static String PutMap(HttpServletResponse response, int count, Object ar){
        PrintWriter out = null;
        try {
            out = response.getWriter();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashedMap();
        map.put("code",20000);
        map.put("count",count);
        map.put("data",ar);

        String json = gson.toJson(map);
        out.println(json);
        out.flush();
        out.close();
        return json;
    }

    //分页计算
    public static  Object CPages(MyPageVO obj){
        int x=obj.getBegin();
        int y=(x-1)*obj.getPages();
        obj.setBegin(y);
        return obj;
    }



}
