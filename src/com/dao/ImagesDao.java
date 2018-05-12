package com.dao;

import java.util.List;

import com.entity.Images;

public interface ImagesDao {
	
	List<Images> searchAllImages();
	Images searchImages();
	
	boolean insertImages();
	boolean deleteImages();
	boolean updateImages();

}
