package com.dentist.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.dentist.entity.User;
import com.dentist.entity.UserExample;
import com.dentist.mapper.UserMapper;
import com.dentist.service.UserService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	


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

		UserExample example = new UserExample();
		UserExample.Criteria c = example.createCriteria();
		c.andIdEqualTo(id);
		List<User> list =  userMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<User> selectWithPageByExample(User user,
			LayuiPageParam param) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		UserExample.Criteria c  = example.createCriteria();
		if(null != user && user.getUsername() != null){
			c.andUsernameLike(user.getUsername());
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
		if(null != user && user.getUsername() != null){
			c.andUsernameLike(user.getUsername());
		}
		List<User> list =  userMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)){
			return list.size();
		}
		return 0;
	}

}
