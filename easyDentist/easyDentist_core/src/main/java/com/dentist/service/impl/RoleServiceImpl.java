package com.dentist.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentist.entity.Role;
import com.dentist.service.RoleService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Override
	public int add(Role model)  {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Role model)  {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Role model)  {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Role detail(Role model)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getList(Role model)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LayuiPage<Role> page(Role model, LayuiPageParam param)
			 {
		// TODO Auto-generated method stub
		return null;
	}

}
