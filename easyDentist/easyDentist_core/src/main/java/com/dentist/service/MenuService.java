package com.dentist.service;

import java.util.List;

import com.dentist.entity.Menu;
import com.dentist.utils.LayuiPageParam;

public interface MenuService extends IBaseService<Menu> {

	List<Menu> getAllMenus();
	
	//根据条件查询分页数据
    List<Menu> selectWithPageByExample(Menu menu,LayuiPageParam param);
	
	//根据条件查询总数据条数
	int selectCountByExample(Menu menu);

	List<Menu> getAllParentMenus();

	Menu checkMenuName(String menuname);

	Menu checkUrl(String url);

	Menu queryMenuById(Integer id);

}
