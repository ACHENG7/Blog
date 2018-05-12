package com.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class MoodLog {
	/**
	 * 心情日志
	 */
	private int id;
	private String content;//内容
	@JSONField(format="yyyy/MM/dd HH:mm:s")
	private Date publicDate;//发布时间
	
	
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
	public Date getPublicDate() {
		return publicDate;
	}
	public void setPublicDate(Date publicDate) {
		this.publicDate = publicDate;
	}
	
	
	

}
