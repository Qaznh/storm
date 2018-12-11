package com.cn.wx.service;

import java.sql.Timestamp;

import com.cn.wx.pojo.News;

public interface INewsService {
	
	public News getNewsById(int newsId);

	public int putNews(String stu_id,int kw_id,String news_img,String news_cont,Timestamp datetime);
}
