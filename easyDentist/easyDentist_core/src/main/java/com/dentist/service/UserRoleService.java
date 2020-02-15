package com.dentist.service;

import java.util.List;

import com.dentist.entity.Role;
import com.dentist.entity.UserRole;

public interface UserRoleService extends IBaseService<UserRole> {

	List<Role> queryRolesByUserId(String userId);
	
	int deleteMoreByUserId(Integer userId);

}
