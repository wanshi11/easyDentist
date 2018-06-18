package com.dentist.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dentist.entity.User;
import com.dentist.entity.UserExample;
import com.dentist.exception.FormException;
import com.dentist.service.UserService;


@Controller
@RequestMapping(value = "/admin/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/toBgUser", method = RequestMethod.GET)
	public String toBgUser(Model model) {

		List<User> list = null;
		try {
			 list = userService.getList(null);
		} catch (FormException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("userlist", list);
		
		return "/admin/user/user_list";
	}
	
	
	@RequestMapping(value = "/userList")
	public String userList(HttpServletRequest request,UserExample example,Map<String, String> params) {
		List<User> list = null;
		try {
			 list = userService.getList(null);
		} catch (FormException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
       return "/admin/user/list";
	}
	

}
