package com.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.mysql.jdbc.Blob;

public class Article {

	
	 /**
	  * 博客信息类
	  */
	  private int id;
	  private String title; //博客标题
	  private String content;//内容
	  @JSONField(format="yyyy/MM/dd HH:mm:ss")
	  private Date joinTime;//添加时间	

	  //private ArticleType typeId;//博客类型
	  
	  
	  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	
	public Article() {
		super();
	}
	
	public Article(int id) {
		super();
		this.id = id;
	}
	public Article(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	  

	  
}
