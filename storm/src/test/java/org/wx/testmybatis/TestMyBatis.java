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
    private ICommentService commentService = null;  
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
  
    @Test  
    public void test1() {  
        
    	int newsId = 64;
    	String stu_id = "1614080903221";
    	String comcont = "abc";
    	Timestamp datetime = new Timestamp(System.currentTimeMillis());
    	int tag = commentService.putComment(newsId, stu_id, comcont, datetime);
        logger.info(tag);
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
        logger.info(JSON.toJSONString(tag));
        
    } 
}
