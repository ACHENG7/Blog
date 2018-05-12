package com.dao;

import java.util.List;

import com.entity.Article;

public interface ArticleDao {
	
	List<Article> searchAllArticle();
	Article searchArticle();
	
	boolean insertArticle();
	boolean deleteArticle();
	boolean updateArticle();
	

}
