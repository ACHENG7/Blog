package com.util;

public class PageBean {
	private int nowPage;
	private int pageSize;
	private int totalSize;
	
	
	
	public PageBean() {
		super();
	}

	public PageBean(int nowPage, int pageSize) {
		super();
		this.nowPage = nowPage;
		this.pageSize = pageSize;
	}

	public PageBean(int nowPage, int pageSize, int totalSize) {
		super();
		this.nowPage = nowPage;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
	}
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	
	

}
