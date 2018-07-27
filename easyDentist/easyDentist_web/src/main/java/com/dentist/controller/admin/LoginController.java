package com.dentist.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dentist.cfg.Constant;
import com.dentist.entity.Menu;
import com.dentist.entity.User;
import com.dentist.entity.UserRole;
import com.dentist.pojo.MenuPermitView;
import com.dentist.service.MenuService;
import com.dentist.service.RoleMenuService;
import com.dentist.service.UserRoleService;
import com.dentist.service.UserService;
import com.dentist.utils.MD5Util;
import com.dentist.utils.StringUtil;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleMenuService roleMunuService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private MenuService menuService;
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String LoginGet() {

		return "/admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String LoginPost(Model model,HttpServletRequest request) {
		
		logger.info("执行方法---> /login");
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");

		if ( StringUtil.isEmptyStr(name)
				|| StringUtil.isEmptyStr(pwd)) {
			model.addAttribute("loginErr", "用户名或密码为空！");
			return "/admin/login";
		}

		User u = (User) userService.queryUserByUserName(name);
		if (null == u || !u.getPassword().equals(MD5Util.string2MD5(pwd))) {
			model.addAttribute("loginErr", "用户名或密码错误！");
			return "/admin/login";
		} 
		
		if(u.getAdmin() == true){ //超级管理员拥有所有权限
			List<Menu> menus = menuService.getAllMenus();
			List<MenuPermitView> list = toMenuPermitList(menus);
			request.getSession().setAttribute(Constant.LOGIN_MENUPERMITLIST, list);
			request.getSession().setAttribute(Constant.LOGIN_USER, u);
			return "/admin/index";
		}
		
		//根据用户ID查询所有的角色集合
		UserRole ur = new UserRole();
		ur.setUserid(u.getId());
		
		List<UserRole> userRoles =  userRoleService.getList(ur);
		
		//根据角色Id查询出所有的菜单集合
		List<Menu> _menus = roleMunuService.queryMenusByRoles(userRoles);
		//对菜单集合进行组装程List<MenuPermitView>
		List<MenuPermitView> list = toMenuPermitList(_menus);
	
		
		request.getSession().setAttribute(Constant.LOGIN_MENUPERMITLIST, list);
		request.getSession().setAttribute(Constant.LOGIN_USER, u);
		return "/admin/index";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		
	    request.getSession().removeAttribute(Constant.LOGIN_USER);
	    request.getSession().removeAttribute(Constant.LOGIN_MENUPERMITLIST);
	    return "redirect:/admin/login";
	  }
	
	
	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request) {
		//TODO查询统计数据
		
	    return "/admin/index";
	  }
	
	
	/**
	 * @param menus
	 * @return  将菜单列表转成父子菜单集合
	 */
	private List<MenuPermitView> toMenuPermitList(List<Menu> menus){
		
		List<MenuPermitView> list = new ArrayList<MenuPermitView>();
		 for (int i = 0; i < menus.size(); i++) {
			Menu menu = menus.get(i);
			MenuPermitView mp = new MenuPermitView();
			if(null == menu.getParentid()){
				mp.setMenuId(menu.getId());
				mp.setMenuName(menu.getMenuname());
				mp.setMenuDescribe(menu.getMenudescribe());
				mp.setUrl(menu.getUrl());
				mp.setChildrens(new ArrayList<Menu>());
				list.add(mp);
				
				menus.remove(i);
				i--;
			}
		}
		
		for (MenuPermitView menuPermitView : list) { 
				 for (int i = 0; i < menus.size(); i++) {
								Menu menu = menus.get(i);
						if(null != menu.getParentid() && menuPermitView.getMenuId().equals(menu.getParentid())){
							menuPermitView.getChildrens().add(menu);
							
							menus.remove(menu);
							i--;
						}
				 }
		}
		return list;
	}

}
