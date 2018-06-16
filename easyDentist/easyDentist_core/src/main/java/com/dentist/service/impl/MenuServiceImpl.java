package com.dentist.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentist.entity.Menu;
import com.dentist.exception.FormException;
import com.dentist.service.MenuService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Override
	public int add(Menu model) throws FormException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Menu model) throws FormException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Menu model) throws FormException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Menu detail(Menu model) throws FormException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> getList(Menu model) throws FormException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LayuiPage<Menu> page(Menu model, LayuiPageParam param)
			throws FormException {
		// TODO Auto-generated method stub
		return null;
	}

}
