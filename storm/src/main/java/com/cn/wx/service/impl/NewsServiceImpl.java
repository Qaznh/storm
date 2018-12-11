package com.cn.wx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.wx.dao.NewsMapper;
import com.cn.wx.pojo.News;
import com.cn.wx.service.INewsService;

@Service("newsService")
public class NewsServiceImpl implements INewsService{
	@Resource
	private NewsMapper newsDao;
	public News getNewsById(int newsId){
		return this.newsDao.selectByPrimaryKey(newsId);
	}
}
