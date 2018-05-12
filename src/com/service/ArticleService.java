package com.service;

import java.util.List;

import com.entity.Article;

public interface ArticleService {

	 void insertArticle(Article a);
	 
	 void deleteArticle(Article a);
	 
	 void updateArticle(Article a);
	 
	 List<Article> findAll();
	 
	 List<Article> findNewArticle();
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
