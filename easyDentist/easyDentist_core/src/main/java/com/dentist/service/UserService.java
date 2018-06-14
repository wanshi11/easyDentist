package com.dentist.service;

public interface UserService<User> extends IBaseService<User> {
	
	//根据用户名查询用户
	User queryUserByUserName(String userName);

}
