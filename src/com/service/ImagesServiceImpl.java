package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BaseDao;
import com.entity.Images;
import com.util.PageBean;

@Service("imagesService")
public class ImagesServiceImpl implements ImagesService{
	
	@Resource
	BaseDao<Images> baseDao;
	
   public void setBaseDao(BaseDao<Images> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void insertImages(Images images) {
		baseDao.save(images);
		
	}

	@Override
	public void deleteImages(Images images) {
		baseDao.delete(images);
		
	}

	@Override
	public Images getImages(int id) {
		
		return baseDao.get(Images.class, id);
	}

	@Override
	public List<Images> findAllImages(PageBean page) {
		String hql="from Images ";
		return baseDao.find(hql, new Object[] {}, page.getNowPage(), page.getPageSize());
	}

	@Override
	public Long countImages() {
		String hql="select count(*) from Images";
		return baseDao.count(hql);
	}

	@Override
	public List<Images> findNewImages() {
		String hql="from Images order by id desc ";
		//int count = baseDao.count("select count(*) from Images").intValue();
		
		return baseDao.find(hql, new Object[] {}, 1, 6);
	}

}
