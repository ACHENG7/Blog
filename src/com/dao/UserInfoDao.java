package com.dao;

import java.util.List;

import com.entity.UserInfo;

public interface UserInfoDao {
	List<UserInfo> searchAllUserInfo();
	UserInfo searchUserInfo();
	
	boolean insertUserInfo();
	boolean deleteUserInfo();
	boolean updateUserInfo();
}
