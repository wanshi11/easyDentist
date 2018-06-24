package com.dentist.service;

import java.util.List;

import com.dentist.entity.User;
import com.dentist.utils.LayuiPageParam;

public interface UserService extends IBaseService<User> {
	
	//根据用户名查用户
	User queryUserByUserName(String userName);

	//根据条件查询分页数据
    List<User> selectWithPageByExample(User user,LayuiPageParam param);
	
	//根据ID名查用户
	User queryUserById(Integer id);
	
	//根据条件查询总数据条数
	int selectCountByExample(User user);

	//排除当前用户查询
	User queryUserNotRepeatByUserName(String username,Integer id);
	

	

}
