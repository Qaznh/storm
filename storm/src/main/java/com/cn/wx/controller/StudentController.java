package com.cn.wx.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Student;
import com.cn.wx.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Resource
	private IStudentService studentService;
	
	@RequestMapping(value={"/getStu"},method=RequestMethod.POST)
	public void getStu(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
		//String str = json1.toJSONString();
	     //System.out.println(str);
		String id = json1.getString("id");
		String password = json1.getString("password");
		//System.out.println(password);
		Student st = studentService.getStudentById(id);
		String st_password = st.getPassword();
		if(st_password.equals(password))
		{
			//System.out.println("ok");
			response.getWriter().print(true);
			response.getWriter().flush();
			response.getWriter().close();
		}
		else{
			response.getWriter().print(false);
			response.getWriter().flush();
			response.getWriter().close();

		}
		
	}

}
