package com.dentist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dentist.entity.Role;
import com.dentist.entity.UserRole;
import com.dentist.entity.UserRoleExample;
import com.dentist.mapper.UserRoleMapper;
import com.dentist.service.UserRoleService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public int add(UserRole model)  {
		// TODO Auto-generated method stub
		return userRoleMapper.insert(model);
	}

	@Override
	public int delete(UserRole model)  {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserRole model)  {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserRole detail(UserRole model)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRole> getList(UserRole model)  {
		
	     List<UserRole> list = null;
		try {
			UserRoleExample example = new UserRoleExample();
			UserRoleExample.Criteria c = example.createCriteria();
			if(model.getUserid() != null){
				c.andUseridEqualTo(model.getUserid());
			}
			list = userRoleMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public LayuiPage<UserRole> page(UserRole model, LayuiPageParam param)
			 {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> queryRolesByUserId(String userId) {
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(userId)){
			List<Role> list = userRoleMapper.queryRolesByUserId(Integer.valueOf(userId));
			return list;
		}
		 return null;
		
	}

	@Override
	public int deleteMoreByUserId(Integer userId) {
		
		UserRoleExample example = new UserRoleExample();
		UserRoleExample.Criteria c = example.createCriteria();
		c.andUseridEqualTo(userId);
		return userRoleMapper.deleteByExample(example);
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
