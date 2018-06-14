package com.dentist.utils;

/**
 * 
 * mysite: http://www.xiudoua.com
 * @desc: 封装分页查询的公用参数实体
 * @author: JustFresh
 * @date: 2018年5月4日 下午8:01:40 
 * @version: beta1.1
 */
public class LayuiPageParam {

	private int page = 1;//默认查询第一页
	
	private int limit = 10;//默认每页查询10条
	
	private String order = "id";//默认排序为主键ID
	
	private String sort = "desc";//默认降序排序

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}