package com.dentist.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dentist.entity.RoleMenu;
import com.dentist.entity.User;
import com.dentist.entity.UserRole;
import com.dentist.exception.FormException;
import com.dentist.pojo.MenuPermitView;
import com.dentist.service.RoleMenuService;
import com.dentist.service.UserRoleService;
import com.dentist.service.UserService;
import com.dentist.utils.StringUtil;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleMenuService roleMunuService;
	
	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String LoginGet() {

		return "/admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String LoginPost(User user, Model model,HttpServletRequest request) {

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
		
		
		
		//根据用户ID查询所有的角色集合
		UserRole ur = new UserRole();
		ur.setUserid(u.getId());
		try {
			List<UserRole> userRoles =  userRoleService.getList(ur);
		} catch (FormException e) {
			e.printStackTrace();
		}
		//根据角色Id查询出所有的菜单集合
		
		//对菜单集合进行组装程List<MenuPermitView>
		
		
		
		
		
		
        request.getSession().setAttribute("user", u);
		return "/admin/index";
	}

}
