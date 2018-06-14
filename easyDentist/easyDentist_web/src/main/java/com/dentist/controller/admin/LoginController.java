package com.dentist.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dentist.entity.User;
import com.dentist.service.UserService;
import com.dentist.utils.StringUtil;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String LoginGet() {

		return "/admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String LoginPost(User user, Model model) {

		if (user == null || StringUtil.isEmptyStr(user.getUsername())
				|| StringUtil.isEmptyStr(user.getPassword())) {
			model.addAttribute("loginErr", "用户名或密码为空！");
			return "/admin/login";
		}

		User u = (User) userService.queryUserByUserName(user.getUsername());
		if (null == u || !u.getPassword().equals(user.getPassword())) {
			model.addAttribute("loginErr", "用户名或密码错误！");
			return "/admin/login";
		} 
		//查询菜单列表

		return "/admin/index";
	}

}
