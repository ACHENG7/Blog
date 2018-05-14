package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BaseDao;
import com.entity.MoodLog;
import com.util.PageBean;
@Service("moodLogService")
public class MoodLogServiceImpl implements  MoodLogService{
 
	@Resource
	BaseDao<MoodLog> baseDao;
	
	public void setBaseDao(BaseDao<MoodLog> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void insertMoodLog(MoodLog mood) {
		baseDao.save(mood);
		
	}

	@Override
	public void deleteMoodLog(MoodLog mood) {
		baseDao.delete(mood);
		
	}

	@Override
	public void updateMoodLog(MoodLog mood) {
		baseDao.update(mood);
		
	}

	@Override
	public List<MoodLog> findAllMoodLogByTime() {
		String hql="from MoodLog order by publicDate desc";
		return baseDao.find(hql);
	}

	@Override
	public Long countAllMoodLog() {		
		String hql="select count(*) from MoodLog";
		return baseDao.count(hql);
						
	}

	@Override
	public List<MoodLog> findAllMoodLogByTime(PageBean page) {
		String hql="from MoodLog order by publicDate desc";
		
		return baseDao.find(hql, new Object[] {}, page.getNowPage(), page.getPageSize());
	}

	@Override
	public List<MoodLog> findAllTest(PageBean page) {
       String hql="from MoodLog order by publicDate desc";	
		return baseDao.find(hql,  new ArrayList<Object>(), page.getNowPage(), page.getPageSize());
	}
	

}
