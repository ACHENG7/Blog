package com.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Reply {
	/**
	 * 博客评价
	 */
	private int id;
	private String content;
	private Article articleId;
	
	
    @JSONField(format="yyyy/MM/dd HH:mm:ss")
	private Date replyTime;
	
	private String nickname;
	
	
	
	public Reply() {
		super();
	}
	
	public Reply(String content, Article articleId, Date replyTime, String nickname) {
		super();
		this.content = content;
		this.articleId = articleId;
		this.replyTime = replyTime;
		this.nickname = nickname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	public Article getArticleId() {
		return articleId;
	}
	public void setArticleId(Article articleId) {
		this.articleId = articleId;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
	
	

}
