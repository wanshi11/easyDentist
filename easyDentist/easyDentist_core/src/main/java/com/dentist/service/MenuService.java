package com.dentist.service;

import java.util.List;

import com.dentist.entity.Menu;

public interface MenuService extends IBaseService<Menu> {

	List<Menu> getAllMenus();

}
