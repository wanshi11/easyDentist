package com.dentist.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.dentist.entity.Role;
import com.dentist.entity.RoleExample;
import com.dentist.mapper.RoleMapper;
import com.dentist.service.RoleService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public int add(Role model)  {
		// TODO Auto-generated method stub
		return roleMapper.insert(model);
	}

	@Override
	public int delete(Role model)  {
		// TODO Auto-generated method stub
		return roleMapper.deleteByPrimaryKey(model.getId());
	}

	@Override
	public int update(Role model)  {
		// TODO Auto-generated method stub
		return roleMapper.updateByPrimaryKey(model);
	}

	@Override
	public Role detail(Role model)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getList(Role model)  {
		// TODO Auto-generated method stub
		RoleExample example = new RoleExample();
		return roleMapper.selectByExample(example);
	}

	@Override
	public LayuiPage<Role> page(Role model, LayuiPageParam param)
			 {
		LayuiPage<Role> layui = new LayuiPage<>();
		layui.setCount(selectCountByExample(model));
		layui.setData(selectWithPageByExample(model, param));
		return layui;
	}

	
	@Override
	public List<Role> selectWithPageByExample(Role role, LayuiPageParam param) {
		// TODO Auto-generated method stub
		RoleExample roleExample = new RoleExample();
		RoleExample.Criteria c = roleExample.createCriteria();
		if(null != role && !StringUtils.isEmpty(role.getRolename())){
			c.andRolenameLike('%'+role.getRolename()+'%');
		}
		Map<String, String> params = new HashMap<>();
		params.put("order", param.getOrder());
		params.put("sort", param.getSort());	
		params.put("rowStart", (param.getPage()-1)*param.getLimit()+"");	
		params.put("pageSize", param.getLimit()+"");	
		
		
		
		return roleMapper.selectWithPageByExample(roleExample, params);
	}

	@Override
	public Role queryRoleById(Integer id) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int selectCountByExample(Role role) {

		RoleExample roleExample = new RoleExample();
		RoleExample.Criteria c = roleExample.createCriteria();
		if(null != role && !StringUtils.isEmpty(role.getRolename())){
			c.andRolenameLike('%'+role.getRolename()+'%');
		}
		
		List<Role> list =  roleMapper.selectByExample(roleExample);
		if(!CollectionUtils.isEmpty(list)){
			return list.size();
		}
		return 0;
	}

	@Override
	public Role queryRoleByRoleName(String rolename) {
		
		RoleExample roleExample = new RoleExample();
		RoleExample.Criteria c = roleExample.createCriteria();
		if(!StringUtils.isEmpty(rolename)){
			c.andRolenameEqualTo(rolename);
			
			List<Role> list = roleMapper.selectByExample(roleExample);
			if(!CollectionUtils.isEmpty(list)){
				return list.get(0);
			}
			
		}
		return null;
	}

	@Override
	public Role queryRoleNotRepeatByRoleName(String rolename, Integer id) {
		
				RoleExample example = new RoleExample();
				RoleExample.Criteria c = example.createCriteria();
				c.andRolenameEqualTo(rolename);
				c.andIdNotEqualTo(id);
				List<Role> list =  roleMapper.selectByExample(example);
				if(!CollectionUtils.isEmpty(list)){
					return list.get(0);
				}
				return null;
	}

}
