package com.dentist.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dentist.entity.Appoint;
import com.dentist.interceptor.RequiredPermission;
import com.dentist.service.AppointService;
import com.dentist.service.UserService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;


/**
 * 
 *  预约控制器
 */

@Controller
@RequestMapping(value = "/admin/appoint")
public class AppointController {
	
	@Autowired
	private AppointService appointService;
	
	@Autowired
	private UserService userService;
	
	 
	
	/**
	 * 到预约列表页 
	 */
	@RequiredPermission
	@RequestMapping(value="/toAppoints", method = RequestMethod.GET)
	public String  toAppoints(){
		
		return "/admin/appoint/appoint_list";
	}

	/**
	 * 查询预约列表 
	 */
	@RequestMapping(value = "/appointList",method=RequestMethod.POST)
	@ResponseBody
	public LayuiPage<Appoint> appointList(Appoint appoint,LayuiPageParam param) {
	
		return appointService.page(appoint, param);
	}
	
	
	/**
	 * 到回访、回复页面 
	 */
	@RequestMapping(value = "/toEdit")
	public String editAppoint(Model model,int id){
		
		Appoint appoint = appointService.queryAppointById(id);
		model.addAttribute("appoint", appoint);
		
		return "/admin/appoint/appoint_edit";
	}
	
	
	
	/**
	 * 进行处理预约
	 */
	/*@RequestMapping(value = "/edit",method=RequestMethod.POST)
	@ResponseBody
	public String edit(QuestionA qA,HttpServletRequest request){
		String result = "";
		
		User u = (User)request.getSession().getAttribute(Constant.LOGIN_USER);
		
		QuestionA qa = qaService.queryQuestionANotRepeatByQuestion(qA.getQuestion(), qA.getId());
		if(qa != null){
			result = "QUESTION_EXIST";
			return result;
		}
		qA.setTime(new Date());
		qA.setOperatorid(u.getId());
			int num = qaService.update(qA);
			if(num !=0){
				result = "EDIT_SUCCESS";
			}else{
				result = "EDIT_FAIL";
			}
	
		return result;
	}*/
	
	
	/**
	 * 删除消息
	 */
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(Integer id){
		String result = "";
		int num =  appointService.deleteById(id);
		if(num > 0){
			result="DELETE_SUCCESS";
		}else{
			result="DELETE_FAIL";
		}
	
		return result;
	}	
	
	
	
}
