package com.cn.wx.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Keywords;
import com.cn.wx.service.IKeywordService;
import com.cn.wx.service.INewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	@Resource
	private INewsService newsService;
	@Resource
	private IKeywordService keywordService;
	
	@RequestMapping(value={"/showNews"},method=RequestMethod.POST)
	@ResponseBody
	public Object showNews(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONArray arry = new JSONArray();
		return arry;
	}
	

    @RequestMapping(value={"/addNews"},method=RequestMethod.POST)
    @ResponseBody
    public boolean addNews(HttpServletRequest request,HttpServletResponse response,@RequestParam("file")MultipartFile[] files)
			 throws ServletException, IOException{
    	JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
    	String stu_id = json1.getString("id");
    	String keyword = json1.getString("keyword");
    	Keywords kw = keywordService.getKeywordByKeyword(keyword);
    	int kw_id = kw.getKwId();
        String news_cont = json1.getString("news_cont"); 
        Timestamp datetime = new Timestamp(System.currentTimeMillis());
        String news_img = null;
        System.out.println(stu_id);
        if(files!=null && files.length>=1){
        	BufferedOutputStream bw = null;
        	String fileName = files[0].getOriginalFilename();
        	

    	//MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
       //MultipartFile multipartFile =  req.getFile("file");
        //if(multipartFile!=null){
        
        String realPath = "Q:\\Users\\Aqzh\\git\\storm\\src\\main\\webapp\\Image\\news_image";
        String serverPath1 = "http://10.101.112.47:8080/storm/Image/news_image/";
        String n_imgName = UUID.randomUUID().toString();
        File file  =  new File(realPath,n_imgName);
       // multipartFile.transferTo(file);
        news_img = serverPath1+n_imgName;
        }
        
        
        int tag = newsService.putNews(stu_id, kw_id, news_img, news_cont, datetime);
        if(tag==1)
    	  return true;
        else
          return false;
    }

	
}
