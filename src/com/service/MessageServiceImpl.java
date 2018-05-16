package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BaseDao;
import com.entity.Message;
import com.util.PageBean;
@Service("messageService")
public class MessageServiceImpl implements MessageService{
	
	@Resource
	BaseDao<Message> baseDao;
	

	public void setBaseDao(BaseDao<Message> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void insertMessage(Message message) {
		baseDao.save(message);
		
	}

	@Override
	public void deleteMessage(Message message) {
		baseDao.delete(message);
		
	}

	@Override
	public List<Message> findAllMessage(PageBean page) {
//		String sql="SET @rowNO=0; " + 
//				"SELECT  (@rowNO := @rowNo+1) num ,id,content,sendTime,nickname FROM t_message ORDER BY sendTime DESC";
		String hql="from Message order by sendTime desc";
		return baseDao.find(hql, new Object[] {}, page.getNowPage(), page.getPageSize());
	}

	@Override
	public Long countMessage() {
		String hql="select count(*) from Message";		
		return baseDao.count(hql);
	}

}
