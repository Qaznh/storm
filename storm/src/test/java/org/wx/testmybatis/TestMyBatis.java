package org.wx.testmybatis;

import java.util.Date;

import javax.annotation.Resource;  

import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
 
import com.alibaba.fastjson.JSON;
import com.cn.wx.pojo.News;
import com.cn.wx.pojo.Student;
import com.cn.wx.service.INewsService;
import com.cn.wx.service.IStudentService;


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
    	int a = 1;
    	News news = newsService.getNewsById(a);
    	String stu_id = news.getStuId();
    	Date dt = news.getCreateTime();
    	//String dd = dt.toString();
    	System.out.println(stu_id);
    	//Student st = studentService.getStudentById("1614080903221");
    	//String pw = st.getPassword();
    	//System.out.println(pw);
        logger.info(dt);
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
        logger.info(JSON.toJSONString(stu_id));
        
    } 
}
