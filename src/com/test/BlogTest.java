package com.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.dao.ArticleDao;
import com.dao.BaseDao;
import com.entity.Article;
import com.entity.MoodLog;
import com.entity.Reply;
import com.mysql.fabric.xmlrpc.base.Data;
import com.service.ArticleService;
import com.service.ArticleServiceImpl;
import com.service.MoodLogService;
import com.service.MoodLogServiceImpl;
import com.service.ReplyService;
import com.util.PageBean;

public class BlogTest {
	
	ApplicationContext ac;
	private BaseDao<Article> dao;
	private ArticleService service;
	private MoodLogService moodService;
	@Before
	public void setUp() throws Exception {
		 ac = new ClassPathXmlApplicationContext("beans.xml");
		
		dao=(BaseDao<Article>)ac.getBean("baseDao");
		service = (ArticleServiceImpl)ac.getBean("articleService");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		 
		List<Article> list =dao.find("from Article");
		for(Article a : list) {
			System.out.println(a.getContent());
		}
	}
	
	@Test
  public void testBase() {
//	  List<Article> list =service.findAll();
//	  for(Article a : list) {
//			System.out.println(a.getContent());
//		}
	
		List<Object[]> list2 =service.findNewArticle();
	  System.out.println("============");
	  for(Object[] obj : list2) {
			System.out.println(obj[0]+" -- "+ obj[1]+" -- "+obj[2]);
		}
	 
	 
  }
	@Test
	  public void testDate() {
		  Date date = new Date();
		  System.out.println(date);
	  }
	
	@Test
	public void testMoodSer() {
		moodService =(MoodLogServiceImpl)ac.getBean("moodLogService");
		MoodLog mood = new MoodLog();
		mood.setContent("这是我第一条说说");
		mood.setPublicDate(new Date());
		moodService.insertMoodLog(mood);
	}
	/***
	 * 测试问题
	 */
//	@Test
//	public void testMoodList() {
//		List<MoodLog> list = moodService.findAllMoodLog();
//		for(MoodLog m :list) {
//			System.out.println(m.getContent());
//		}
//		
//	}
	@Test
	public void testMoodDelete() {
		moodService =(MoodLogServiceImpl)ac.getBean("moodLogService");
		MoodLog mood = new MoodLog();
		mood.setId(5);
		moodService.deleteMoodLog(mood);
	}
	
	@Test
  public void testArticleCount() {
		System.out.println("count="+service.countArticle());
		PageBean pageBean = new PageBean(2,6,13);
		List<Article> list = service.findAll(pageBean);
		for(Article a:list) {
			System.out.println("id="+a.getId()+"  title= "+a.getTitle());
		}
	}
	
	@Test
	public void testReply() {
		ReplyService replyService = (ReplyService) ac.getBean("replyService");
		List<Reply> list=replyService.findAll(35);
		System.out.println(replyService.countReply(35));
		for(Reply r:list) {
			System.out.println(r.getReplyTime());
		}
	}
	
}
