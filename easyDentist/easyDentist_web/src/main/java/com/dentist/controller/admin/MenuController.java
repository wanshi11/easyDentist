package com.dentist.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dentist.cfg.Constant;
import com.dentist.entity.Menu;
import com.dentist.entity.Role;
import com.dentist.entity.User;
import com.dentist.pojo.TreeMenuView;
import com.dentist.service.MenuService;
import com.dentist.service.RoleMenuService;
import com.dentist.service.RoleService;
import com.dentist.utils.JsonUtils;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;


@Controller
@RequestMapping(value = "/admin/menu")
public class MenuController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleMenuService roleMenuService;
	
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
	
//==========分配菜单=====
	
	/**
	 * 到分配菜单页
	 */
	@RequestMapping(value="/toAllotMenus", method = RequestMethod.GET)
	public String  toAllotMenus(Model model){
		
		List<Role> roles =roleService.getList(null);
		
		
		model.addAttribute("roles", roles);
		return "/admin/menu/allot_menus";
	}
	
	@RequestMapping(value="/queryAllTreeMenuView")
	@ResponseBody
	public List<TreeMenuView> quertAllTreeMenuView(){
		
		List<TreeMenuView> treeMenus = new ArrayList<TreeMenuView>();
		List<Menu> menus = menuService.getAllMenus();
		
		for (Menu menu : menus) {
			if(menu.getParentid() == null){
				TreeMenuView treeMenuView  = new TreeMenuView();
				treeMenuView.setTitle(menu.getMenuname());
				treeMenuView.setValue(menu.getId()+"");
				treeMenuView.setData(new ArrayList<TreeMenuView>());
				treeMenus.add(treeMenuView);
			}
		}
		
		Iterator<TreeMenuView> iter = treeMenus.iterator();
		while(iter.hasNext()){
			TreeMenuView parent = iter.next();
			for (Menu menu : menus) {
				if(menu.getParentid() != null && parent.getValue().equals(menu.getParentid()+"")){
					TreeMenuView treeMenuView  = new TreeMenuView();
					treeMenuView.setValue(menu.getId()+"");
					treeMenuView.setTitle(menu.getMenuname());
					treeMenuView.setData(new ArrayList<TreeMenuView>());
					List<TreeMenuView> list = parent.getData();
					list.add(treeMenuView);
					parent.setData(list);
				}
			}
		}
		
		
		return treeMenus;
	}
	
	
	@RequestMapping(value="/allotMenus",method = RequestMethod.POST)
	@ResponseBody
	public String allotMenus(HttpServletRequest request){
		User u = (User)request.getSession().getAttribute(Constant.LOGIN_USER);
		
		String list = request.getParameter("menuIdArray");
		List<String> menuIdArray = JsonUtils.stringToList(list, String.class);
		String roleId = request.getParameter("roleId");
		
		if(StringUtils.isEmpty(roleId)){
			return "NO_ROLE";
		}
		
		Set<String> menus = new HashSet<>(menuIdArray);
		try {
			roleMenuService.allotMenusByRoleId(roleId,menus,u);
		} catch (Exception e) {
			logger.error("分配菜单报错！！roleId:"+roleId+"menuIds:"+menus);
			e.printStackTrace();
			return "FAIL";
		}
		
		return "SUCCESS";
	}
	
	
}
