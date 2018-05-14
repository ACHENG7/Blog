package com.service;

import java.util.List;

import com.entity.Reply;

public interface ReplyService {

  void insertReply(Reply reply);
  Long countReply(int id);
 // void deleteReply(Reply reply);
  List<Reply> findAll(int id);
	
}
