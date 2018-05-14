package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BaseDao;
import com.entity.Article;
import com.entity.Reply;
@Service("replyService")
public class ReplyServiceImpl implements ReplyService{

	@Resource
	BaseDao<Reply> baseDao;
	
	public void setBaseDao(BaseDao<Reply> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void insertReply(Reply reply) {
		baseDao.save(reply);
		
	}

	@Override
	public List<Reply> findAll(int id) {
		String hql="from Reply where articleId=?";
		return baseDao.find(hql, new Object[] {new Article(id)});
	}

	@Override
	public Long countReply(int id) {
		String hql="select count(*) from Reply where articleId=?";
		
		return baseDao.count(hql, new Object[]{new Article(id)});
	}

}
