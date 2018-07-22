package com.dentist.service;

import java.util.List;
import java.util.Set;

import com.dentist.entity.Menu;
import com.dentist.entity.RoleMenu;
import com.dentist.entity.User;
import com.dentist.entity.UserRole;

public interface RoleMenuService extends IBaseService<RoleMenu>  {

	void allotMenusByRoleId(String roleId, Set<String> menus,User u);

	List<Menu> queryMenusByRoles(List<UserRole> userRoles);

}
