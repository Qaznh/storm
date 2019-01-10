package com.cn.wx.service;

import java.sql.Timestamp;

import com.cn.wx.pojo.Comment;

public interface ICommentService {

	public Comment getCommentById(int commentId);
	
	public int putComment(int newsId,String stuId,String commentCont,Timestamp datetime);
	
}
