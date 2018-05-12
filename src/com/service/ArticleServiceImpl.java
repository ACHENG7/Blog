package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BaseDao;
import com.entity.Article;

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
	public List<Article> findAll() {
		String hql="from Article order by joinTime desc";
		return baseDao.find(hql);
	}

	/***
	 * 按照时间排序的最新前四个博客并用hql只读取两列数据
	 */
	@Override
	public List<Article> findNewArticle() {
		String hql="select new Article(title,content) FROM Article  ORDER BY joinTime DESC ";
		
		List<Article> list =baseDao.find(hql, new Object[] {}, 1, 4);
		return list;
	}

}
