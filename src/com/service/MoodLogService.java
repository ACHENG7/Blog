package com.service;

import java.util.List;

import com.entity.MoodLog;
import com.util.PageBean;

public interface MoodLogService {
	void insertMoodLog(MoodLog mood);
    void deleteMoodLog(MoodLog mood);
    void updateMoodLog(MoodLog mood);
    Long countAllMoodLog();
    //List<MoodLog> findAllMoodLog();
    List<MoodLog> findAllMoodLogByTime();
    List<MoodLog> findAllMoodLogByTime(PageBean page);
    List<MoodLog> findAllTest(PageBean page);
}
