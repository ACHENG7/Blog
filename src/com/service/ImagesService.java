package com.service;

import java.util.List;

import com.entity.Images;
import com.util.PageBean;

public interface ImagesService {
	void insertImages(Images images);
	void deleteImages(Images images);
	
	Images getImages(int id);
	Long countImages();
	//分页
	List<Images> findAllImages(PageBean page);
	//首页展示
	List<Images> findNewImages();

}
