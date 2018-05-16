package com.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Message {
	/**
	 * 留言板
	 */
	private int id;
	private String content;//内容
	@JSONField(format="yyyy/MM/dd HH:ss")
	private Date sendTime;//发布时间
	private String nickName;//昵称
	
	
	
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
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	

	
	

}
