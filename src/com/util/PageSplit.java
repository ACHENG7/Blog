package com.util;

public class PageSplit {
	
	public String pageSplit(String URL,PageBean page) {
		String str="";
		int countpage;
		
		//得出countpage
		if(page.getTotalSize()%page.getPageSize()!=0) {
			countpage=page.getTotalSize()/page.getPageSize()+1;
		}else {
			countpage=page.getTotalSize()/page.getPageSize();
		}
		
		if(page.getNowPage()<0) {
			page.setNowPage(1);
		}
		
		if(page.getNowPage()>countpage) {
			page.setNowPage(countpage);
		}
		
		if(page.getNowPage()<=0) {
			str="<li class='disabled' ><a href="+URL+1+">&laquo;</a></li>";
		}else {
			str="<li ><a href="+URL+(page.getNowPage()-1)+">&laquo;</a></li>";
		}
		
		for(int i=1;i<=countpage;i++) {
			str+="<li ><a href="+URL+i+">"+i+"</a></li>";
		}
		
		if(page.getNowPage()>=countpage) {
			str+="<li class='disabled'><a href='#'>&raquo;</a></li>";
		}else {
			str+="<li><a href="+URL+(page.getNowPage()+1)+">&raquo;</a></li>";
		}
		return str;
	}

	/**
	 * 样式二
	 */
	public String pageSplit2(String URL,PageBean page) {
		String str="";
		int countpage;
		
		//得出countpage
		if(page.getTotalSize()%page.getPageSize()!=0) {
			countpage=page.getTotalSize()/page.getPageSize()+1;
		}else {
			countpage=page.getTotalSize()/page.getPageSize();
		}
		
		if(page.getNowPage()<0) {
			page.setNowPage(1);
		}
		
		if(page.getNowPage()>countpage) {
			page.setNowPage(countpage);
		}
		
		if(page.getNowPage()<=0) {
			str="<div class='disabled nav-previous' ><a href='#'>&larr; 上一页</a></div>";
		}else {
			str="<div class='nav-previous'><a href="+URL+(page.getNowPage()-1)+">&larr; 上一页</a></div>";
		}
		
	
		
		
		if(page.getNowPage()>=countpage) {
			str+="<div class='disabled nav-next' ><a href='#'>下一页 &rarr;</a></div>";
		}else {
			str+="<div class='nav-next'><a href="+URL+(page.getNowPage()+1)+">下一页 &rarr;</a></div>";
		}
		return str;
	}
}
