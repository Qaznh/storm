package com.cn.wx.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.cn.wx.service.INewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	@Resource
	private INewsService newsService;
	
	@RequestMapping(value={"/showNews"},method=RequestMethod.POST)
	@ResponseBody
	public Object showNews(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONArray arry = new JSONArray();
		return arry;
	}
	
}
