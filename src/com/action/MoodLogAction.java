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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.MoodLog;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MoodLogService;

import net.sf.morph.context.contexts.HttpServletContext;

@Controller("moodLogAction")
public class MoodLogAction extends ActionSupport {
	String moodLogContent;
	int moodLogId;
	@Resource
	MoodLogService moodLogService;
	
	public void setMoodLogService(MoodLogService moodLogService) {
		this.moodLogService = moodLogService;
	}
	public String getMoodLogContent() {
		return moodLogContent;
	}
	public void setMoodLogContent(String moodLogContent) {
		this.moodLogContent = moodLogContent;
	}	
	public int getMoodLogId() {
		return moodLogId;
	}
	public void setMoodLogId(int moodLogId) {
		this.moodLogId = moodLogId;
	}
	
  /*================心情日志后台操作action  start  ===============================*/
	public String insert() {
		MoodLog mood = new MoodLog();
		mood.setContent(moodLogContent);
		mood.setPublicDate(new Date());
		moodLogService.insertMoodLog(mood);
		return SUCCESS;
	}
	
	public String delete() throws IOException {
		MoodLog mood = new MoodLog();
		mood.setId(moodLogId);
		
		HttpServletResponse response =ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		JSONObject str = new JSONObject();

		PrintWriter out = response.getWriter();
		try {
			moodLogService.deleteMoodLog(mood);
			str.put("msg", "说说删除成功啦~");
		}catch (Exception e) {
			e.printStackTrace();
			str.put("msg", "说说删除失败了，稍后重试哦~");
		}finally {
			out.print(str);
			out.flush();
			out.close();
		}
		return null;
	}
	
	public String findAll() throws IOException {
		//获取response对象
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");		
		//获取print对象
		PrintWriter out = response.getWriter();
		List<MoodLog> list = moodLogService.findAllMoodLog();	
		if(list!=null) {			
			String jsonStr = JSONArray.toJSONString(list);
			 out.print(jsonStr);
		     out.flush();
		     out.close();
		     System.out.println(jsonStr);
		}
		
		
		return null;
	}
/*================心情日志后台操作action  end  ===============================*/
	/**
	 * mood.jsp页面的说说展示
	 * @return
	 * @throws IOException
	 */
	public String findAllMoodLog() throws IOException {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		List<MoodLog> list = moodLogService.findAllMoodLogByTime();	
		Long count = moodLogService.countAllMoodLog();
		if(list!=null) {
			request.setAttribute("allMoodLogList", list);
			request.setAttribute("countMoodLog", count);
//			for(MoodLog m:list) {
//				System.out.println(m.getPublicDate());
//			}
		}
		return SUCCESS;
	}
}
