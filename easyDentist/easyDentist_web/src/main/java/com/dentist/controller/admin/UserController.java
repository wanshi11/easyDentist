package com.dentist.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dentist.service.UserService;


@Controller
@RequestMapping(value = "/admin/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/toBgUser", method = RequestMethod.GET)
	public String toBgUser() {

		return "/admin/bguser";
	}

}
