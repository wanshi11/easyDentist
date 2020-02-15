package com.dentist.service;

import java.util.List;

import com.dentist.entity.Menu;
import com.dentist.utils.LayuiPageParam;

public interface MenuService extends IBaseService<Menu> {

	List<Menu> getAllMenus();
	
    List<Menu> selectWithPageByExample(Menu menu,LayuiPageParam param);
	
	int selectCountByExample(Menu menu);

	List<Menu> getAllParentMenus();

	Menu checkMenuName(String menuname);

	Menu checkUrl(String url);

	Menu queryMenuById(Integer id);

	Menu queryMenuNotRepeatByMenuName(String menuname, Integer id);

	Menu queryMenuNotRepeatByMenuUrl(String url, Integer id);

}
