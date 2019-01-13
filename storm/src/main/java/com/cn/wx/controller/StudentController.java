package com.cn.wx.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Student;
import com.cn.wx.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	static String news_imgurl=null;
     
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
	
	@RequestMapping(value={"/uploadIcon"})
	 @ResponseBody
	    public void uploadIcon(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) 
				 throws IOException {
		request.setCharacterEncoding("UTF-8");
	    String id = request.getParameter("stu_id");
	    if(!file.isEmpty()) {
	        
	           String fileName = file.getOriginalFilename();
	           String path = null;
	           String type = null;
	           type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
	           
	           if (type != null) {
	               if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
	                   // 项目在容器中实际发布运行的根路径
	            	   String realPath = request.getSession().getServletContext().getRealPath("")+"Image\\icon_image\\";
	                   //String realPath = "Q:\\Users\\Aqzh\\git\\storm\\src\\main\\webapp\\Image\\news_image\\";
	                   // 自定义的文件名称
	                   String trueFileName = id +"_"+ UUID.randomUUID().toString()+"."+type.toLowerCase();
	                  // System.out.println(trueFileName);
	                   //System.out.println(trueFileName);
	                   // 设置存放图片文件的路径
	                   path = realPath + trueFileName; 
	                   file.transferTo(new File(path));
	                   String serverPath1 = "http://10.101.112.105:8080/storm/Image/icon_image/";
	                   news_imgurl = serverPath1 + trueFileName;
	                   
	                   Student stu = studentService.getStudentById(id);
	                   stu.setIconUrl(news_imgurl);
	                   studentService.putIconUrl(stu);
	                  }
	               }
	           }
	        }
	
	
}


	           
