package com.dentist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.dentist.entity.User;
import com.dentist.entity.UserExample;
import com.dentist.exception.FormException;
import com.dentist.mapper.UserMapper;
import com.dentist.service.UserService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	


	public int add(User model) throws FormException {
		// TODO Auto-generated method stub
		return userMapper.insert(model);
	}

	public int delete(User model) throws FormException {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(model.getId());
	}

	public int update(User model) throws FormException {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(model);
	}

	public User detail(User model) throws FormException {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(model.getId());
	}

	public List<User> getList(User model) throws FormException {
		UserExample example = new UserExample();
		UserExample.Criteria c = example.createCriteria();
		if(model.getUsername() != null){
			c.andUsernameLike("%" + model.getUsername() + "%");
		}
		// TODO Auto-generated method stub
		return userMapper.selectByExample(example);
	}

	public LayuiPage<User> page(User model, LayuiPageParam param)
			throws FormException {
		// TODO Auto-generated method stub
		return null;
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

}
