package com.dentist.controller.admin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dentist.entity.Role;
import com.dentist.entity.User;
import com.dentist.service.RoleService;
import com.dentist.utils.Constant;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;


@Controller
@RequestMapping(value = "/admin/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	 
	
	/**
	 * 到角色列表页 
	 */
	@RequestMapping(value="/toRoles", method = RequestMethod.GET)
	public String  toRoles(){
		
		return "/admin/role/role_list";
	}

	/**
	 * 查询角色列表 
	 */
	@RequestMapping(value = "/roleList",method=RequestMethod.POST)
	@ResponseBody
	public LayuiPage<Role> userList(Role u,LayuiPageParam param) {
	
		return roleService.page(u, param);
	}
	
	/**
	 * 到添加页面 
	 */
	@RequestMapping(value = "/toAdd")
	public String addRole(){
		
		return "/admin/role/role_add";
	}
	
	/**
	 * 到修改页面 
	 */
	@RequestMapping(value = "/toEdit")
	public String editRole(Model model,int id){
		
		Role r = roleService.queryRoleById(id);
		model.addAttribute("role", r);
		
		return "/admin/role/role_edit";
	}
	
	/**
	 * 到赋予角色页面
	 */
	@RequestMapping(value = "/toGiveRoles",method=RequestMethod.GET)
	public String toGiveRoles(Model model){
		
		return "/admin/role/role_give";
	}
	
	/**
	 * 添加角色
	 */
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ResponseBody
	public String add(Role r,HttpServletRequest request){
		String result = "";
		
		    User u = (User)request.getSession().getAttribute(Constant.LOGIN_USER);
			r.setOperationtime(new Date());
			r.setOperatorid(u.getId());
			int num = roleService.add(r);
			if(num !=0){
				result = "ADD_SUCCESS";
			}else{
				result = "ADD_FAIL";
			}
	
		return result;
	}
	
	
	/**
	 * 修改角色
	 */
	@RequestMapping(value = "/edit",method=RequestMethod.POST)
	@ResponseBody
	public String edit(Role r,HttpServletRequest request){
		String result = "";
		
		User u = (User)request.getSession().getAttribute(Constant.LOGIN_USER);
		
		Role role = roleService.queryRoleNotRepeatByRoleName(r.getRolename(),r.getId());
		Role ro = roleService.queryRoleById(r.getId());
		if(role != null){
			result = "ROLE_EXIST";
			return result;
		}
		 ro.setDescription(r.getDescription());
		 ro.setOperationtime(new Date());
		 ro.setOperatorid(u.getId());
		 ro.setRolename(r.getRolename());
			int num = roleService.update(ro);
			if(num !=0){
				result = "EDIT_SUCCESS";
			}else{
				result = "EDIT_FAIL";
			}
	
		return result;
	}
	
	
	/**
	 * 删除用户
	 */
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(Integer id){
		String result = "";
		Role r = roleService.queryRoleById(id);
		int num = roleService.delete(r);
		if(num > 0){
			result="DELETE_SUCCESS";
		}else{
			result="DELETE_FAIL";
		}
	
		return result;
	}
	
	
	
	/**
	 * 校验角色名保证唯一 
	 */
	@RequestMapping(value = "/checkRoleName",method=RequestMethod.POST)
	@ResponseBody
	public String checkRoleName(String rolename){
		
		Role r = roleService.queryRoleByRoleName(rolename);
		if(r != null){  //已有该用户
			return "1";
		}
		return "0";
	}
	
	
	
	
}
