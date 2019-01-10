package com.cn.wx.service.impl;

import java.sql.Timestamp;

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
	
	public int putNews(String stu_id,int kw_id,String news_img,String news_cont,Timestamp datetime){
		News news = new News();
		news.setStuId(stu_id);
		news.setKwId(kw_id);
		news.setNewsCont(news_cont);
		news.setNewsImg(news_img);
		news.setCreateTime(datetime);
	    int a = this.newsDao.insertSelective(news);
	    return a;
	}
	
	public News getNewsDesc(){
		return this.newsDao.selectDesc();
	}
	
	public int addNewsCmNum(News news){
		return this.newsDao.updateByPrimaryKeySelective(news);
	}
}
