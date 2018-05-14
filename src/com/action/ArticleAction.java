package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.Article;
import com.entity.Reply;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ArticleService;
import com.service.ReplyService;
import com.util.PageBean;
import com.util.PageSplit;

import net.sf.morph.context.contexts.HttpServletContext;

@Controller("articleAction")
public class ArticleAction extends ActionSupport {

	String title;
	String content;
	int id; //博客id
	Integer page;//当前页

	@Resource
	ArticleService articleService;
	@Resource
	ReplyService replyService;

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * ==============================遍历所有博客===================================
	 * @return
	 * @throws IOException
	 */
	public String findAll() throws IOException {
	
		
		HttpServletRequest request = ServletActionContext.getRequest();
		if(page==null) {
			page=1;
		}
		int totalsize = articleService.countArticle().intValue();
		PageBean pageBean = new PageBean(page,5,totalsize);
		List<Article> list = articleService.findAll(pageBean);
		String pageSplit = new PageSplit().pageSplit("Article_findAll?page=", pageBean);
		if (list != null) {
			
			request.setAttribute("allArticleList", list);
			request.setAttribute("pageSplit", pageSplit);
		}
		return SUCCESS;

	}
	
	/**
	 * =============================查看详情博客并加载评论=====================================
	 */
	public String getArticle() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Article article =articleService.getArticle(getId());
		List<Reply> replyList = replyService.findAll(id);
		Long countReply = replyService.countReply(id);
		request.setAttribute("article", article);
		request.setAttribute("countReply", countReply);
		request.setAttribute("replyList", replyList);
		//request.setAttribute("id", id);
		return "single";
		
	}
	
	//首页只展示最新日期的4条记录
	public String init() {
		HttpServletRequest requset  = ServletActionContext.getRequest();
//		PageBean page=new PageBean(1,4);
//		List<Article> list =articleService.findAll(page);
		List<Object[]> list =articleService.findNewArticle();
		requset.setAttribute("newArticleList", list);
	
		return SUCCESS;
	}
	/**
	 * =====================   博客后台管理 start===================================
	 * 首页初始化
	 */
	
	/**
	 * 博客插入
	 * 
	 * @return
	 */
	public String insert() {
		Article article = new Article();
		article.setTitle(title);
		article.setContent(content);
		Date date = new Date();
		// System.out.println(date);
		article.setJoinTime(date);

		articleService.insertArticle(article);
		return SUCCESS;
	}

	/**
	 * 博客删除
	 * 
	 * @return
	 * @throws IOException
	 */
	public String delete() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Article article = new Article();
		article.setId(id);
		JSONObject str = new JSONObject();
		try {
			articleService.deleteArticle(article);
			str.put("msg","删除成功~");
		}catch (Exception e) {
		   e.printStackTrace();
		   str.put("msg","删除失败了稍后重试哦~");
		}finally {
			out.print(str);
			out.flush();
			out.close();
			//System.out.println(str);
		}		
		return null;
	}

	/**
	 * 博客查看
	 * 
	 * @return
	 * @throws IOException
	 */
	public String findAllArticle() throws IOException {
	
		List<Article> list = articleService.findAll();
		
		// 获取一个response
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		if (list != null) {
			String jsonString = JSONArray.toJSONString(list);
			// 获取print对象
			PrintWriter out = response.getWriter();
			System.out.println("json：" + jsonString);

			out.print(jsonString);
			out.flush();
			out.close();
		}
		return null;

	}
	
	/**
	 *  =====================   博客后台管理 end===================================
	 */

	
	
}
