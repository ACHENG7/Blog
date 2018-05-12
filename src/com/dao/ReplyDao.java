package com.dao;

import java.util.List;

import com.entity.Reply;

public interface ReplyDao {
	List<Reply> searchAllReply();
	Reply searchReply();
	
	boolean insertReply();
	boolean deleteReply();
	boolean updateReply();
}
