package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.Article;
import com.entity.Reply;
import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.fabric.xmlrpc.base.ResponseParser;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ArticleService;
import com.service.ReplyService;
@Controller("replyAction")
public class ReplyAction extends ActionSupport{
	int id;//文章id
	String nickname;
	String content;//评价内容
	
	@Resource
	ReplyService replyService;
	
	@Resource
	ArticleService articleService;
	
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * ajax插入一条评论实现局部刷新页面
	 * @return
	 * @throws IOException
	 */
	public String insert() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		JSONObject str = new JSONObject();
		//Reply(String content, Article articleId, Date replyTime, String nickname)
		System.out.println("content="+content+"  nickname="+nickname);
		Reply reply = new Reply(content,articleService.getArticle(id),new Date(),nickname);
		replyService.insertReply(reply);
		str.put("msg","发表成功了哦~");
		PrintWriter out = response.getWriter();
		out.print(str);
		out.flush();
		out.close();	
		return null;
	}
	
	public String findAllReply() {		
		replyService.findAll(id);
		return SUCCESS;
	}

}
