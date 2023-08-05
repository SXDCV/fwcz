package com.hu.controller;

import com.hu.entity.EmpEntity;
import com.hu.service.EmpService;
import com.hu.util.GuiguException;
import com.hu.util.JwtHelper;
import com.hu.util.Myroute;
import com.hu.util.Result;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
@RequestMapping("test.do")
public class UserContrtoller
{
	@Resource
	private EmpService empService;

	/**************** 前端登陆 ***************/
	@RequestMapping(params = "method=login")
	@ResponseBody
	public Result login(HttpServletResponse response, EmpEntity emp)
	{
		Myroute.route(response);
		int login = empService.getLogin(emp);
		// System.out.println("12324");
		EmpEntity oneInfo = empService.getOneInfo(emp);
		// System.out.println(oneInfo.getEname()+" "+oneInfo.getEpsw());
		// 登陆成功
		if (login == 0)
		{
			return Result.fail(new GuiguException(201, ""), 201);
		}
		// oneInfo.setEid(1);
		String token = JwtHelper.createToken(Long.parseLong(oneInfo.getEid() + ""), oneInfo.getEname());
		Map map = new HashedMap();
		map.put("data", token);
		return Result.ok(map);

	}

	// 登陆成功后，全查询员工---Vue ----stroe
	@RequestMapping(params = "method=userinfo")
	@ResponseBody
	public void userinfo(HttpServletResponse response, HttpServletRequest request, String mytoken)
	{

			//跨域问题解决
			Myroute.route(response);

			//分离出主键ID
			Long id = JwtHelper.getUserId(mytoken);
			int eid = Integer.parseInt(id.toString());

			EmpEntity emp = empService.empOne(eid);
			emp.setAvatar("http://localhost:8080/images/log.gif");

			Myroute.PutMap(response,0,emp);


	}

}
