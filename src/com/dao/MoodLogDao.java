package com.dao;

import java.util.List;

import com.entity.MoodLog;

public interface MoodLogDao {
	List<MoodLog> searchAllMoodLog();
	MoodLog searchMoodLog();
	
	boolean insertMoodLog();
	boolean deleteMoodLog();
	boolean updateMoodLog();


}
