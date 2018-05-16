package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.Message;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MessageService;
import com.util.PageBean;
import com.util.PageSplit;

@Controller("messageAction")
public class MessageAction  extends ActionSupport{
	
	Integer page;//分页
	String nickname;//昵称
	String content;//内容
	
	
	@Resource
	MessageService messageService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	
	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
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


	public String findAll() {
		if(page==null) {
			page=1;
		}
		int count = messageService.countMessage().intValue();
		PageBean pageBean = new PageBean(page,8,count);
		List<Message> list = messageService.findAllMessage(pageBean);
		String  pageSplit=new PageSplit().pageSplit2("message_findAll?page=", pageBean);
		HttpServletRequest request  = ServletActionContext.getRequest();
		request.setAttribute("messageList", list);
		request.setAttribute("messageCount", count);
		request.setAttribute("pageSplit", pageSplit);
		return SUCCESS;
	}

	 public String insert() throws IOException {
		 HttpServletResponse response = ServletActionContext.getResponse();
		 response.setCharacterEncoding("utf-8");
		 Message message = new Message();
		 message.setNickName(nickname);
		 message.setContent(content);
		 message.setSendTime(new Date());
		 messageService.insertMessage(message);
		 JSONObject str = new JSONObject();
		 str.put("msg", "发送成功了哦⁽⁽ଘ( ˊᵕˋ )ଓ⁾⁾");
		 PrintWriter out  = response.getWriter();
		 out.print(str);
		 out.flush();
		 out.close();
		 return null;
	 }
}
