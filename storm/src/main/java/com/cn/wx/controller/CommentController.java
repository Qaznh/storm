package com.cn.wx.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.News;
import com.cn.wx.service.ICommentService;
import com.cn.wx.service.INewsService;

@Controller
@RequestMapping("/comt")
public class CommentController {

	@Resource
	private ICommentService commentService;
	
	@Resource
	private INewsService newsService;
	
	
	@RequestMapping(value={"/showComt"},method=RequestMethod.POST)
	@ResponseBody
	public Object showComt(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONArray arry = new JSONArray();
		return arry;
	}
	
	@RequestMapping(value={"/addComt"})
    @ResponseBody
	public boolean addComt(HttpServletRequest request)
			 throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
		String stuId = json1.getString("stuId");
		int newsId = json1.getIntValue("newsId");
		String comcont = json1.getString("comcont");
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		int tag = commentService.putComment(newsId, stuId, comcont, datetime);
		if(tag==1)
		{
			News news=newsService.getNewsById(newsId);
	    	int comment_num = news.getCommentNum();
	    	comment_num++;
	    	news.setCommentNum(comment_num);
	    	int tag2 =newsService.addNewsCmNum(news);
			System.out.println(tag2);
			return true;
			}
		else
			return false;
	}
}
