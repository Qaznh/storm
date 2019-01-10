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
        
    	
    	
    	JSONObject json = new JSONObject();
    	News nw = newsService.getNewsDesc();
    	json.put("news_id", nw.getNewsId());
    	json.put("kw_id",nw.getKwId());
    	json.put("stu_id",nw.getStuId());
    	json.put("news_cont",nw.getNewsCont());
    	json.put("news_image", nw.getNewsImg());
    	json.put("comment_num", nw.getCommentNum());
    	json.put("praise_num", nw.getPraiseNum());
    	json.put("browse_num", nw.getBrowseNum());
    	Date d = nw.getCreateTime();
    	String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
    	json.put("create_time", sdf);

        logger.info(json);
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
        logger.info(JSON.toJSONString(json));
        
    } 
}
