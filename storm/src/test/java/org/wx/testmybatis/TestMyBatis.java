package org.wx.testmybatis;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import com.cn.wx.pojo.News;
import com.cn.wx.pojo.Xiaolis;
import com.cn.wx.service.ICommentService;
import com.cn.wx.service.INewsService;
import com.cn.wx.service.IXiaoliService;


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class TestMyBatis {

	private static Logger logger = Logger.getLogger(TestMyBatis.class);  
//  private ApplicationContext ac = null;  
    @Resource  
    private INewsService newsService = null;  
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
    	 String a = "hk";
    	 System.out.println("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\webapps\\storm\\Image\\news_image\\");
        logger.info(a);
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
        logger.info(JSON.toJSONString(a));
        
    } 
}
