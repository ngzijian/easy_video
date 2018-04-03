package com.softeem.easyvideo.utils;

import java.util.List;

public class PageBean<T> {
	private int page;
	private int pageSize = 10;
	private int totalPage;
	private int totalCounct;
	private List<T> list;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCounct() {
		return totalCounct;
	}
	public void setTotalCounct(int totalCounct) {
		this.totalCounct = totalCounct;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
