package com.dentist.controller.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dentist.entity.Menu;
import com.dentist.entity.Role;
import com.dentist.entity.User;
import com.dentist.service.MenuService;
import com.dentist.utils.Constant;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;


@Controller
@RequestMapping(value = "/admin/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * 到菜单列表页 
	 */
	@RequestMapping(value="/toMenus", method = RequestMethod.GET)
	public String  toMenus(){
		
		return "/admin/menu/menu_list";
	}
	 
	
	/**
	 * 查询菜单列表 
	 */
	@RequestMapping(value = "/menuList",method=RequestMethod.POST)
	@ResponseBody
	public LayuiPage<Menu> userList(Menu u,LayuiPageParam param) {
	
		return menuService.page(u, param);
	}
	
	/**
	 * 到添加页面 
	 */
	@RequestMapping(value = "/toAdd")
	public String addMenu(Model model){
		
		List<Menu> list = menuService.getAllParentMenus();
		
		model.addAttribute("parentMenus", list);
		
		return "/admin/menu/menu_add";
	}
	
	
	/**
	 * 添加菜单
	 */
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ResponseBody
	public String add(Menu m,HttpServletRequest request){
		String result = "";
		
		    User u = (User)request.getSession().getAttribute(Constant.LOGIN_USER);
			m.setCreatetime(new Date());
			m.setOperatorid(u.getId());
			
			int num = menuService.add(m);
			if(num !=0){
				result = "ADD_SUCCESS";
			}else{
				result = "ADD_FAIL";
			}
		return result;
	}
	
	
	/**
	 * 删除菜单
	 */
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(Integer id){
		String result = "";
		Menu m = menuService.queryMenuById(id);
		int num = menuService.delete(m);
		if(num > 0){
			result="DELETE_SUCCESS";
		}else{
			result="DELETE_FAIL";
		}
	
		return result;
	}
	
	
	
	/**
	 * 校验菜单名称 保证唯一 
	 */
	@RequestMapping(value = "/checkMenuName",method=RequestMethod.POST)
	@ResponseBody
	public String checkRoleName(String menuname){
		
		Menu m = menuService.checkMenuName(menuname);
		if(m != null){  //已有该菜单
			return "1";
		}
		return "0";
	}
	
	
	/**
	 * 校验菜单url 保证唯一 
	 */
	@RequestMapping(value = "/checkUrl",method=RequestMethod.POST)
	@ResponseBody
	public String checkUrl(String url){
		
		Menu m = menuService.checkUrl(url);
		if(m != null){  //已有该菜单
			return "1";
		}
		return "0";
	}
	
	
	
}
