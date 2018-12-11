package org.wx.testmybatis;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;  

import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
 
import com.alibaba.fastjson.JSON;
import com.cn.wx.pojo.News;
import com.cn.wx.service.INewsService;


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
    	//String keyword = "泽荃明天要去广州";
    	//keywordService.putKeyword(keyword);
    	//keywordService.delKeyword(keyword);
    	//int count = keywordService.getKeywordCount();
    	//String studentId = news.getStuId();
    	//Student st = studentService.getStudentById(studentId);
    	//String b = st.getId();
    	//String dd = dt.toString();
    	//Student st = studentService.getStudentById("1614080903221");
    	//String pw = st.getPassword();
    	//System.out.println(pw);
    	
        Timestamp datetime = new Timestamp(System.currentTimeMillis());
        News news = new News();
        
        String stu_id = "1614080903221";
    	int kw_id = 1;
    	String news_img = null;
        String news_cont = null; 
		news.setStuId(stu_id);
		news.setKwId(kw_id);
		news.setNewsCont(news_cont);
		news.setNewsImg(news_img);
		news.setCreateTime(datetime);
		int a = newsService.putNews(stu_id, kw_id, news_img, news_cont, datetime);
		
        logger.info(a);
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
        logger.info(JSON.toJSONString(a));
        
    } 
}
