package com.dentist.controller.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dentist.entity.User;
import com.dentist.entity.UserExample;
import com.dentist.service.UserService;
import com.dentist.utils.IPUtils;


@Controller
@RequestMapping(value = "/admin/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 到后台用户列表页面 
	 */
	@RequestMapping(value = "/toBgUser", method = RequestMethod.GET)
	public String toBgUser(Model model) {

		List<User>  list = userService.getList(null);
		model.addAttribute("userlist", list);
		return "/admin/user/user_list";
	}
	
	
	/**
	 * 查询用户列表 
	 */
	@RequestMapping(value = "/userList")
	@ResponseBody
	public List<User> userList(HttpServletRequest request,UserExample example,Map<String, String> params) {
		List<User>  list = userService.getList(null);
		
       return list;
	}
	
	
	/**
	 * 到添加或者修改用户页面 
	 */
	@RequestMapping(value = "/toEdit")
	public String editUser(){
		
		return "/admin/user/user_edit";
	}
	
	/**
	 * 添加或者修改用户
	 */
	@RequestMapping(value = "/edit",method=RequestMethod.POST)
	@ResponseBody
	public String edit(User u){
		String result = "";
		
		if(u.getId() == null){ //新增
			u.setCreatetime(new Date());
			u.setAdmin(false);
			u.setIp(IPUtils.getLocalHostLANAddress().getHostAddress());
			int num = userService.add(u);
			if(num !=0){
				result = "ADD_SUCCESS";
			}else{
				result = "ADD_FAIL";
			}
		}else{ //修改
			 u.setCreatetime(new Date());
			 userService.update(u);
			 result = "UPD_SUCCESS";
		}
		return result;
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
