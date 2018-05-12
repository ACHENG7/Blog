package com.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BaseDao;
import com.entity.ArticleType;
@Service("articleTypeService")
public class ArticleTypeServiceImpl implements ArticleTypeService{
 
	@Resource
	BaseDao<ArticleType> baseDao;
	
	public void setBaseDao(BaseDao<ArticleType> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public ArticleType getArticleType(Serializable id) {		
		return baseDao.get(ArticleType.class, id);
	}

}
