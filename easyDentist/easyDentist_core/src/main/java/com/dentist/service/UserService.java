package com.dentist.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dentist.entity.User;
import com.dentist.entity.UserExample;
import com.dentist.utils.LayuiPage;

public interface UserService extends IBaseService<User> {
	
	//根据用户名查用户
	User queryUserByUserName(String userName);

	
	LayuiPage<User> selectWithPageByExample(@Param("example") UserExample example,@Param("params") Map<String, String> params);
	
	//根据ID名查用户
	User queryUserById(Integer id);

	

}
