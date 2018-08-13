package com.dentist.controller.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dentist.cfg.PermissionConstants;
import com.dentist.entity.User;
import com.dentist.interceptor.RequiredPermission;
import com.dentist.service.UserService;
import com.dentist.utils.IPUtils;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;
import com.dentist.utils.MD5Util;


@Controller
@RequestMapping(value = "/admin/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 到后台用户列表页面 
	 */
	@RequiredPermission(PermissionConstants.ADMIN_PRODUCT_LIST) // 权限注解
	@RequestMapping(value = "/toBgUser", method = RequestMethod.GET)
	public String toBgUser(Model model) {

	
		return "/admin/user/user_list";
	}
	
	
	/**
	 * 查询用户列表 
	 */
	@RequestMapping(value = "/userList",method=RequestMethod.POST)
	@ResponseBody
	public LayuiPage<User> userList(User u,LayuiPageParam param) {
	
		return userService.page(u, param);
	}
	
	
	/**
	 * 到添加页面 
	 */
	@RequestMapping(value = "/toAdd")
	public String addUser(){
		
		return "/admin/user/user_add";
	}
	
	/**
	 * 到修改页面 
	 */
	@RequestMapping(value = "/toEdit")
	public String editUser(Model model,int id){
		
		User u = userService.queryUserById(id);
		model.addAttribute("user", u);
		
		return "/admin/user/user_edit";
	}
	
	/**
	 * 添加用户
	 */
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ResponseBody
	public String add(User u){
		String result = "";
		
		User user = userService.queryUserByUserName(u.getUsername());
		if(user != null){
			result = "USER_EXIST";
			return result;
		}
		    u.setPassword(MD5Util.string2MD5(u.getPassword()));
			u.setCreatetime(new Date());
			u.setAdmin(false);
			u.setIp(IPUtils.getLocalHostLANAddress().getHostAddress());
			int num = userService.add(u);
			if(num !=0){
				result = "ADD_SUCCESS";
			}else{
				result = "ADD_FAIL";
			}
	
		return result;
	}
	
	
	
	/**
	 * 修改用户
	 */
	@RequestMapping(value = "/edit",method=RequestMethod.POST)
	@ResponseBody
	public String edit(User u){
		String result = "";
		
		User user = userService.queryUserNotRepeatByUserName(u.getUsername(),u.getId());
		User us = userService.queryUserById(u.getId());
		if(user != null){
			result = "USER_EXIST";
			return result;
		}
		    us.setCreatetime(new Date());
		    us.setIp(IPUtils.getLocalHostLANAddress().getHostAddress());
		    us.setUsername(u.getUsername());
		    us.setRealname(u.getRealname());
		    us.setPhoneno(u.getPhoneno());
		    us.setSex(u.getSex());
		    us.setQq(u.getQq());
			int num = userService.update(us);
			if(num !=0){
				result = "EDIT_SUCCESS";
			}else{
				result = "EDIT_FAIL";
			}
	
		return result;
	}
	
	
	/**
	 * 修改用户
	 */
	@RequestMapping(value = "/changePassword",method=RequestMethod.POST)
	@ResponseBody
	public String changePassword(User u,String oldpwd,String newpwd,String newpwdagin){
		
		User user = userService.queryUserById(u.getId());
		if(!MD5Util.string2MD5(oldpwd).equals(user.getPassword())){
			//原始密码错误
			return "PWD_WRONG";
		}
		if(!newpwd.equals(newpwdagin)){
			//新密码两次输入不一致
			return "PWD_INCONSISTENT";
		}
		
		user.setPassword(MD5Util.string2MD5(newpwd));
		int num = userService.update(user);
	
		return num > 0 ? "SUCCESS":"FAIL";
	}
	
	/**
	 * 删除用户
	 */
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(Integer id){
		
		int num = userService.deleteById(id);
		return num > 0 ? "DELETE_SUCCESS":"DELETE_FAIL";
	}
	
	/**
	 * 校验用户名保证唯一 
	 */
	@RequestMapping(value = "/checkUserName",method=RequestMethod.POST)
	@ResponseBody
	public String checkUserName(String username){
		
		User u = userService.queryUserByUserName(username);
		if(u != null){  //已有该用户
			return "1";
		}
		return "0";
	}

}
