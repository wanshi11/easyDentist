package com.dentist.service;

import java.util.List;

import com.dentist.entity.UserRole;

public interface UserRoleService extends IBaseService<UserRole> {

	List<UserRole> queryRolesByUserId(String userId);

}
