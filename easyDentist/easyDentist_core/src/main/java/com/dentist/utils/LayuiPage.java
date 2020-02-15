package com.dentist.utils;

import java.util.List;

/**
 * 
 * mysite: http://www.xiudoua.com
 * @desc: 封装用于Layui数据表格的分页实体
 * @author: JustFresh
 * @date: 2018年5月4日 下午8:03:51 
 * @version: beta1.1
 */
public class LayuiPage<T> {

	private int code;
	
	private String msg;
	
	private int count;
	
	private List<T> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
}