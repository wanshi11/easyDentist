package com.dentist.pojo;

import java.util.List;

import com.dentist.entity.Menu;

/**
 * 菜单权限视图 
 */
public class MenuPermitView {
	
	private String menuName;
	
	private String menuDescribe;
	
	private String url;
	
	private List<Menu> childrens;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Menu> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Menu> childrens) {
		this.childrens = childrens;
	}

	public String getMenuDescribe() {
		return menuDescribe;
	}

	public void setMenuDescribe(String menuDescribe) {
		this.menuDescribe = menuDescribe;
	}
	
	


}
