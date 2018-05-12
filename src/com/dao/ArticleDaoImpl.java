package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Article;
@Transactional
@Repository("articleDao")
public class ArticleDaoImpl implements ArticleDao{
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Article> searchAllArticle() {
		
		return sessionFactory.getCurrentSession().createQuery("from Article").list();

	}

	@Override
	public Article searchArticle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertArticle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteArticle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateArticle() {
		// TODO Auto-generated method stub
		return false;
	}

}
