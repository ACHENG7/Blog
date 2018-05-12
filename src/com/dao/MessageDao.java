package com.dao;

import java.util.List;

import com.entity.Message;



public interface MessageDao {
	
	List<Message> searchAllMessage();
	Message searchMessage();
	
	boolean insertMessage();
	boolean deleteMessage();
	boolean updateMessage();


}
