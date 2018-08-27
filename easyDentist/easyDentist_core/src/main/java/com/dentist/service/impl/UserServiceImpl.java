package com.dentist.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.dentist.entity.Menu;
import com.dentist.entity.MenuExample;
import com.dentist.entity.RoleMenu;
import com.dentist.entity.RoleMenuExample;
import com.dentist.entity.User;
import com.dentist.entity.UserExample;
import com.dentist.entity.UserRole;
import com.dentist.entity.UserRoleExample;
import com.dentist.mapper.MenuMapper;
import com.dentist.mapper.RoleMenuMapper;
import com.dentist.mapper.UserMapper;
import com.dentist.mapper.UserRoleMapper;
import com.dentist.service.UserService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Autowired
	private RoleMenuMapper roleMenuMapper;
	
	@Autowired
	private MenuMapper menuMapper;


	public int add(User model) {
		// TODO Auto-generated method stub
		return userMapper.insert(model);
	}

	public int delete(User model){
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(model.getId());
	}

	public int update(User model)  {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(model);
	}

	public User detail(User model) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(model.getId());
	}

	public List<User> getList(User model) {
		UserExample example = new UserExample();
		/*UserExample.Criteria c = example.createCriteria();
		if(model.getUsername() != null){
			c.andUsernameLike("%" + model.getUsername() + "%");
		}*/
		
		return userMapper.selectByExample(example);
	}

	public LayuiPage<User> page(User model, LayuiPageParam param) {
		// TODO Auto-generated method stub
		LayuiPage<User> layuiPage = new LayuiPage<>();
		layuiPage.setData(selectWithPageByExample(model, param));
		layuiPage.setCount(selectCountByExample(model));
		return layuiPage;
	}

	@Override
	public User queryUserByUserName(String userName) {
		
		UserExample example = new UserExample();
		UserExample.Criteria c = example.createCriteria();
		c.andUsernameEqualTo(userName);
		List<User> list =  userMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}



	@Override
	public User queryUserById(Integer id) {
		return  userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> selectWithPageByExample(User user,
			LayuiPageParam param) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		UserExample.Criteria c  = example.createCriteria();
		if(null != user && !StringUtils.isEmpty(user.getUsername())){
			c.andUsernameLike('%'+user.getUsername()+'%');
		}
		
		Map<String, String> params = new HashMap<>();
		params.put("order", param.getOrder());
		params.put("sort", param.getSort());	
		params.put("rowStart", (param.getPage()-1)*param.getLimit()+"");	
		params.put("pageSize", param.getLimit()+"");	
		
		
		
		return userMapper.selectWithPageByExample(example, params);
	}

	@Override
	public int selectCountByExample(User user) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		UserExample.Criteria c  = example.createCriteria();
		if(null != user && !StringUtils.isEmpty(user.getUsername())){
			c.andUsernameLike('%'+user.getUsername()+'%');
		}
		return  userMapper.countByExample(example);
		
	}

	@Override
	public User queryUserNotRepeatByUserName(String username, Integer id) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		UserExample.Criteria c = example.createCriteria();
		c.andUsernameEqualTo(username);
		c.andIdNotEqualTo(id);
		List<User> list =  userMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Menu> queryMenusByUserId(Integer id) {
		// TODO Auto-generated method stub
		UserRoleExample userRoleExample = new UserRoleExample();
		UserRoleExample.Criteria c = userRoleExample.createCriteria();
		c.andUseridEqualTo(id);
		List<UserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
		
		if (!CollectionUtils.isEmpty(userRoles)) {
			
			List<Integer> menuIds = new ArrayList<>();
			RoleMenuExample roleMenuExample = new RoleMenuExample();
			RoleMenuExample.Criteria c1 = roleMenuExample.createCriteria();
			for (int i = 0; i < userRoles.size(); i++) {
				Integer roleId = userRoles.get(i).getRoleid();
				c1.andRoleidEqualTo(roleId);
				
				List<RoleMenu> roleMenus = roleMenuMapper.selectByExample(roleMenuExample);
				for (int j = 0; !CollectionUtils.isEmpty(roleMenus) && j < roleMenus.size(); j++) {
					menuIds.add(roleMenus.get(j).getMenuid());
				}
			}
			//ListÈ¥ÖØ¸´
			Set<Integer> menuIdSet = new HashSet<>(menuIds);
			menuIds.clear();
			menuIds.addAll(menuIdSet);
			
			List<Menu> menus = new ArrayList<>();
			MenuExample menuExample = new MenuExample();
			MenuExample.Criteria c2 = menuExample.createCriteria();
			for (int K = 0;!CollectionUtils.isEmpty(menuIds) && K < menuIds.size(); K++) {
				Integer menuId = menuIds.get(K);
				c2.andIdEqualTo(menuId);
				Menu mes = menuMapper.selectByPrimaryKey(menuId);
				menus.add(mes);
			}
			
			return menus;
		}
		return null;
	}

}
