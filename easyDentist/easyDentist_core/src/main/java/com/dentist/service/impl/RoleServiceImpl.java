package com.dentist.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentist.entity.Role;
import com.dentist.exception.FormException;
import com.dentist.service.RoleService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Override
	public int add(Role model) throws FormException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Role model) throws FormException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Role model) throws FormException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Role detail(Role model) throws FormException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getList(Role model) throws FormException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LayuiPage<Role> page(Role model, LayuiPageParam param)
			throws FormException {
		// TODO Auto-generated method stub
		return null;
	}

}
