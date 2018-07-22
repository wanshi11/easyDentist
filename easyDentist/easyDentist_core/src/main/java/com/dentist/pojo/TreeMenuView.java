package com.dentist.pojo;

import java.util.List;

import com.dentist.entity.Menu;

/**
 * 
 * 树形菜单视图
 */
public class TreeMenuView {
	
	private String title;
	
	private String value;
	
	
	private List<TreeMenuView> data;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<TreeMenuView> getData() {
		return data;
	}

	public void setData(List<TreeMenuView> data) {
		this.data = data;
	}

	
	
	
	

}
