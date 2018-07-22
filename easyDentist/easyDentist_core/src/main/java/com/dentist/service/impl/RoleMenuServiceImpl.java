package com.dentist.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.dentist.cfg.Constant;
import com.dentist.entity.Menu;
import com.dentist.entity.MenuExample;
import com.dentist.entity.RoleExample;
import com.dentist.entity.RoleMenu;
import com.dentist.entity.RoleMenuExample;
import com.dentist.entity.User;
import com.dentist.entity.UserRole;
import com.dentist.mapper.MenuMapper;
import com.dentist.mapper.RoleMenuMapper;
import com.dentist.service.RoleMenuService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;
import com.mysql.fabric.xmlrpc.base.Array;

@Transactional
@Service("roleMenuService")
public class RoleMenuServiceImpl implements RoleMenuService {
	
	@Autowired
	private RoleMenuMapper roleMenuMapper;
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public int add(RoleMenu model)  {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(RoleMenu model)  {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(RoleMenu model)  {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RoleMenu detail(RoleMenu model)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleMenu> getList(RoleMenu model)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LayuiPage<RoleMenu> page(RoleMenu model, LayuiPageParam param)
			 {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void allotMenusByRoleId(String roleId, Set<String> menus,User u) {
		
        RoleMenuExample example = new RoleMenuExample();
        RoleMenuExample.Criteria c = example.createCriteria();
		//根据roleId 删除记录
        c.andRoleidEqualTo(Integer.parseInt(roleId));
		roleMenuMapper.deleteByExample(example);
		
		//根据roleId 新增记录
		if(!CollectionUtils.isEmpty(menus)){
		Iterator iter = menus.iterator();
		while (iter.hasNext()) {
		   String menuId = (String) iter.next();
		   
		    RoleMenu rm = new RoleMenu();
			rm.setRoleid(Integer.parseInt(roleId));
			rm.setOperationtime(new Date());
			rm.setOperatorid(u.getId());
			rm.setMenuid(Integer.parseInt(menuId));
			roleMenuMapper.insert(rm);
		}
		}
	
	}

	@Override
	public List<Menu> queryMenusByRoles(List<UserRole> userRoles) {
		RoleMenuExample roleMenuExample = new RoleMenuExample();
		RoleMenuExample.Criteria c = roleMenuExample.createCriteria();
		
		List<RoleMenu> list = new ArrayList<RoleMenu>();
		for (UserRole userRole : userRoles) {
			c.andRoleidEqualTo(userRole.getRoleid());
			List<RoleMenu> roleMenus = roleMenuMapper.selectByExample(roleMenuExample);
			list.addAll(roleMenus);
		}
		
		List<Integer> menuIds = new ArrayList<>();
		MenuExample menuExample  = new MenuExample();
		MenuExample.Criteria mc = menuExample.createCriteria(); 
		Iterator<RoleMenu> iter = new HashSet(list).iterator();
		while(iter.hasNext()){
			RoleMenu rm = iter.next();
			menuIds.add(rm.getMenuid());
		}
		mc.andIdIn(menuIds);
		List<Menu> menus = menuMapper.selectByExample(menuExample);
		
		return menus;
	}

}
