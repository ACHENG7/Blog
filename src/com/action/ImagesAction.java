package com.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.query.criteria.internal.expression.function.SubstringFunction;
import org.springframework.stereotype.Controller;

import com.entity.Images;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ImagesService;
import com.util.PageBean;

@Controller("imagesAction")
public class ImagesAction extends ActionSupport{
	Integer page;
	String title;
	String content;
	private File uploadImages;  //上传文件
	private String uploadImagesFileName;//上传的文件名
	private String uploadImagesContentType;//上传的文件类型
	
	@Resource
	ImagesService imagesService;

	public void setImagesService(ImagesService imagesService) {
		this.imagesService = imagesService;
	}
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
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

	public File getUploadImages() {
		return uploadImages;
	}

	public void setUploadImages(File uploadImages) {
		this.uploadImages = uploadImages;
	}

	public String getUploadImagesFileName() {
		return uploadImagesFileName;
	}

	public void setUploadImagesFileName(String uploadImagesFileName) {
		this.uploadImagesFileName = uploadImagesFileName;
	}

	public String getUploadImagesContentType() {
		return uploadImagesContentType;
	}

	public void setUploadImagesContentType(String uploadImagesContentType) {
		this.uploadImagesContentType = uploadImagesContentType;
	}

	public String findAll() {
		if(page==null) {
			page=1;
		}
		int count = imagesService.countImages().intValue();
		PageBean pageBean = new PageBean(page,6,count);
		List<Images> list = imagesService.findAllImages(pageBean);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("imagesList", list);
		return SUCCESS;
	}

	public String insert() throws IOException {
		//图片存储
		//System.out.println("文件名 "+uploadImagesFileName);
		//System.out.println("文件类型 "+uploadImagesContentType);
		String filePath = "G:/workspace/Blog/WebContent/blog/assets/images/upload/"+uploadImagesFileName;
		File saveFile = new File(filePath);
		FileUtils.copyFile(uploadImages, saveFile);
		
		Images images =new Images();
		images.setTitle(title);
		images.setContent(content);
		
		String imagesPath ="assets/images/upload/"+uploadImagesFileName;
		images.setImagePath(imagesPath);
		imagesService.insertImages(images);
		
		return "insert";
	}
}
