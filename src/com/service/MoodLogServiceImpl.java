package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BaseDao;
import com.entity.MoodLog;
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
	public List<MoodLog> findAllMoodLog() {
		String hql="from MoodLog";
		return baseDao.find(hql);
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

}
