package com.service;

import java.util.List;

import com.entity.Message;
import com.util.PageBean;

public interface MessageService {
	
    void insertMessage(Message message);
    
    void deleteMessage(Message message);
    
    List<Message> findAllMessage(PageBean page);
    
    Long countMessage();
}
