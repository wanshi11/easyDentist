package com.dentist.service;

import com.dentist.entity.User;

public interface UserService extends IBaseService<User> {
	
	//根据用户名查询用户
	User queryUserByUserName(String userName);

}
