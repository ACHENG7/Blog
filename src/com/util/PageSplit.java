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

}
