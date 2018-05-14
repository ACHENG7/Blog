package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Service;

import com.dao.BaseDao;
import com.entity.Article;
import com.util.PageBean;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService{
  
	@Resource 
	private BaseDao<Article> baseDao;

	
	@Override
	public void insertArticle(Article a) {
		baseDao.save(a);
	
	}

	@Override
	public void deleteArticle(Article a) {
		baseDao.delete(a);
		
	}

	@Override
	public void updateArticle(Article a) {
		baseDao.update(a);
		
	}

	
	
	@Override
	public Article getArticle(int id) {		
		return baseDao.get(Article.class, id);
	}

   //后台的方法
	@Override
	public List<Article> findAll() {
		String hql="from Article order by joinTime desc";
		return baseDao.find(hql);
	}
	
	/***
	 * 按照时间排序的最新前四个博客并用hql只读取两列数据
	 */
	@Override
	public List findNewArticle() {
		//String hql=" FROM Article  ORDER BY joinTime DESC ";
		String sql="SELECT id,title,LEFT(content,80) FROM t_article ORDER BY joinTime DESC LIMIT 0,4";
		//List<Article> list =baseDao.find(hql, new Object[] {}, 1, 4);
		 List<Object[]> list=baseDao.queryBySql(sql);
		 List<Article> artileList = new ArrayList<Article>();
		 for(Object[] obj:list) {
			 Article a = new  Article();
			 a.setId((int)obj[0]);
			 a.setTitle((String)obj[1]);
			 a.setContent((String)obj[2]);
			 artileList.add(a);
		 }
		return artileList;

	}

	//前台blog.jsp的获取博客列表并分页
	/**
	 * 现在增加功能，至读取文章的前255个字节
	 */
//	@Override
//	public List<Article> findAll(PageBean page) {
//		String hql=" FROM Article  ORDER BY joinTime DESC ";	
//		return baseDao.find(hql, new Object[] {}, page.getNowPage(), page.getPageSize());
//	}
	
	
	@Override
	public List<Article> findAll(PageBean page) {
		
		String sql="SELECT id,title,LEFT(content,255),joinTime FROM t_article ORDER BY joinTime DESC LIMIT "+(page.getNowPage()-1)*page.getPageSize()+","+page.getPageSize();
		
		 List<Object[]> list=baseDao.queryBySql(sql);
		 List<Article> artileList = new ArrayList<Article>();
		 for(Object[] obj:list) {
			 Article a = new  Article();
			 a.setId((int)obj[0]);
			 a.setTitle((String)obj[1]);
			 a.setContent((String)obj[2]);
			 a.setJoinTime((java.util.Date)obj[3]);
			 artileList.add(a);
		 }
		return artileList;

	}
	

	@Override
	public Long countArticle() {
		String hql="select count(*) from Article";
		return baseDao.count(hql);
	}


}
