package com.cn.wx.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Keywords;
import com.cn.wx.pojo.News;
import com.cn.wx.service.IKeywordService;
import com.cn.wx.service.INewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	static String news_imgurl=null;
	
	
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
	

	@RequestMapping(value={"/showNewsDesc"},method=RequestMethod.POST)
	@ResponseBody
	public Object showNewsDesc(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONObject json = new JSONObject();
    	News nw = newsService.getNewsDesc();
    	json.put("news_id", nw.getNewsId());
    	json.put("keyword",nw.getKeyword());
    	json.put("stu_id",nw.getStuId());
    	json.put("news_cont",nw.getNewsCont());
    	json.put("news_image", nw.getNewsImg());
    	json.put("comment_num", nw.getCommentNum());
    	json.put("praise_num", nw.getPraiseNum());
    	json.put("browse_num", nw.getBrowseNum());
    	Date d = nw.getCreateTime();
    	String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
    	json.put("create_time", sdf);
		return json;
	}
	
	
	@RequestMapping(value={"/upload"})
    @ResponseBody
    public void upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) 
			 throws IOException {
	   
       System.out.println("执行upload");
       request.setCharacterEncoding("UTF-8");
       String id = request.getParameter("id");
       if(!file.isEmpty()) {
        
           String fileName = file.getOriginalFilename();
           //System.out.println(fileName); wx4e7f9e9721288267.o6zAJsxcKurhZtmz7TBYVXJCUG4I.BF1ydRZlvzQt2b04df3ecc1d94afddff082d139c6f15.jpg
           
           String path = null;
           String type = null;
           type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
        
           if (type != null) {
               if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                   // 项目在容器中实际发布运行的根路径
            	   String realPath = request.getSession().getServletContext().getRealPath("")+"Image\\news_image\\";
                   //String realPath = "Q:\\Users\\Aqzh\\git\\storm\\src\\main\\webapp\\Image\\news_image\\";
                   // 自定义的文件名称
                   String trueFileName = id +"_"+ UUID.randomUUID().toString()+"."+type.toLowerCase();
                   System.out.println(trueFileName);
                   //System.out.println(trueFileName);
                   // 设置存放图片文件的路径
                   path = realPath + trueFileName; 
                   file.transferTo(new File(path));
                   String serverPath1 = "http://10.101.112.105:8080/storm/Image/news_image/";
                   news_imgurl = serverPath1 + trueFileName;
                   
               }
           }
         }
      }
	
	
    @RequestMapping(value={"/addNews"})
    @ResponseBody
    public boolean addNews(HttpServletRequest request)
			 throws ServletException, IOException{
    	
    	request.setCharacterEncoding("UTF-8");
    	JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);   	
    	String id = json1.getString("id");
    	System.out.println(id);
    	String keyword = json1.getString("keyword");
    	System.out.println(keyword);
        String news_cont = json1.getString("news_cont");
        System.out.println(news_cont);
        Timestamp datetime = new Timestamp(System.currentTimeMillis());
        
        int tag = newsService.putNews(id, keyword, news_imgurl, news_cont, datetime);
    
        if(tag==1)
    	  return true;
        else
          return false;
    
   }
    
    @RequestMapping(value={"/showNewsPage"})
    @ResponseBody
    public Object showNewsPage(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
    	JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
    	int start = (json1.getIntValue("pageNo")*10);
    	List<News> nws= newsService.getNewsByPage(start);
    	JSONArray arry = new JSONArray();
    	arry.add(nws);
		return arry;
    }
    
}
