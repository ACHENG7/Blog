package com.service;

import java.util.List;

import com.entity.Article;
import com.util.PageBean;

public interface ArticleService {

	 void insertArticle(Article a);
	 
	 void deleteArticle(Article a);
	 
	 void updateArticle(Article a);
	 
	 Long countArticle();
	 
	 Article getArticle(int id);
	 //后台再用（不分页）
	 List<Article> findAll();
	 //首页获取的最新4篇文章
	 List findNewArticle();
	 
	 //分页列表
	 //List<Article> findAll(PageBean page);
	 
	 List<Article> findAll(PageBean page);
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
