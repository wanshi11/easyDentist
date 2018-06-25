package com.dentist.service;

import java.util.List;

import com.dentist.entity.Role;
import com.dentist.entity.User;
import com.dentist.utils.LayuiPageParam;

public interface RoleService extends IBaseService<Role> {
	
	
	
	//根据条件查询分页数据
    List<Role> selectWithPageByExample(Role role,LayuiPageParam param);
	
	//根据ID名
	Role queryRoleById(Integer id);
	
	//根据条件查询总数据条数
	int selectCountByExample(Role role);
	

	Role queryRoleByRoleName(String rolename);

}
