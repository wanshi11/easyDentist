package com.dentist.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentist.entity.RoleMenu;
import com.dentist.exception.FormException;
import com.dentist.service.RoleMenuService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("roleMenuService")
public class RoleMenuServiceImpl implements RoleMenuService {

	@Override
	public int add(RoleMenu model) throws FormException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(RoleMenu model) throws FormException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(RoleMenu model) throws FormException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RoleMenu detail(RoleMenu model) throws FormException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleMenu> getList(RoleMenu model) throws FormException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LayuiPage<RoleMenu> page(RoleMenu model, LayuiPageParam param)
			throws FormException {
		// TODO Auto-generated method stub
		return null;
	}

}
