package com.dentist.controller.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dentist.cfg.Constant;
import com.dentist.entity.Menu;
import com.dentist.entity.User;
import com.dentist.service.MenuService;
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
	 * 到修改页面 
	 */
	@RequestMapping(value = "/toEdit")
	public String editMenu(Model model,int id){
		
		Menu m = menuService.queryMenuById(id);
		if(m.getParentid() == null){
			model.addAttribute("isParentMenu", "1");
		}else{
			List<Menu> list = menuService.getAllParentMenus();
			model.addAttribute("parentMenus", list);
			model.addAttribute("isParentMenu", "0");
		}
		
		model.addAttribute("menu", m);
		
		return "/admin/menu/menu_edit";
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
	 * 修改菜单
	 */
	@RequestMapping(value = "/edit",method=RequestMethod.POST)
	@ResponseBody
	public String edit(Menu m,HttpServletRequest request){
		String result = "";
		
		User u = (User)request.getSession().getAttribute(Constant.LOGIN_USER);
		
		Menu menu1 = menuService.queryMenuNotRepeatByMenuName(m.getMenuname(),m.getId());	
		Menu me = menuService.queryMenuById(m.getId());
		if(menu1 != null){
			result = "MENU_NAME_EXIST";
			return result;
		}
		if(!StringUtils.isEmpty(m.getUrl())){
		Menu menu2 = menuService.queryMenuNotRepeatByMenuUrl(m.getUrl(),m.getId());
		if(menu2 != null){
			result = "MENU_URL_EXIST";
			return result;
		}
		}
		 me.setMenudescribe(m.getMenudescribe());
		 me.setCreatetime(new Date());
		 me.setOperatorid(u.getId());
		 me.setMenuname(m.getMenuname());
		 me.setParentid(m.getParentid());
			int num = menuService.update(me);
			if(num !=0){
				result = "EDIT_SUCCESS";
			}else{
				result = "EDIT_FAIL";
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
