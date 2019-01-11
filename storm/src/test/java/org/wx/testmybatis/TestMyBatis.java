package org.wx.testmybatis;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;  

import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ClassUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Comment;
import com.cn.wx.pojo.Keywords;
import com.cn.wx.pojo.News;
import com.cn.wx.pojo.Xiaolis;
import com.cn.wx.service.ICommentService;
import com.cn.wx.service.IKeywordService;
import com.cn.wx.service.INewsService;
import com.cn.wx.service.IXiaoliService;


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class TestMyBatis {

	private static Logger logger = Logger.getLogger(TestMyBatis.class);  
//  private ApplicationContext ac = null;  
    @Resource  
    private INewsService newsService = null;  
    
    @Resource  
    private ICommentService commentService = null;
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
  
    @Test  
    public void test1() {  
        
    	/*int newsId = 64;
    	News news=newsService.getNewsById(newsId);
    	int comment_num = news.getCommentNum();
    	comment_num++;
    	news.setCommentNum(comment_num);
    	int tag =newsService.addNewsCmNum(news);
    	*/
    	List<News> news = newsService.getNewsByPage(1);
    	List<JSONObject> ns= new ArrayList<JSONObject>();
    	for(int i=0;i<news.size();i++){
    		News b = news.get(0);
    		JSONObject json = new JSONObject();
    		json.put("news_id", b.getNewsId());
        	json.put("keyword",b.getKeyword());
        	json.put("stu_id",b.getStuId());
        	json.put("news_cont",b.getNewsCont());
        	json.put("news_image", b.getNewsImg());
        	json.put("comment_num", b.getCommentNum());
        	json.put("praise_num", b.getPraiseNum());
        	json.put("browse_num", b.getBrowseNum());
        	Date d = b.getCreateTime();
        	String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
        	json.put("create_time", sdf);
        	ns.add(json);
    	}
    	
    	//Date d = b.getCreateTime();
        logger.info(ns);
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
        logger.info(JSON.toJSONString(ns));
        
    } 
}
