package com.dao;

import java.util.List;

import com.entity.ArticleType;


public interface ArticleTypeDao {

	List<ArticleType> searchAllArticleType();
	ArticleType searchArticleType();
	
	boolean insertArticleType();
	boolean deleteArticleType();
	boolean updateArticleType();
}
