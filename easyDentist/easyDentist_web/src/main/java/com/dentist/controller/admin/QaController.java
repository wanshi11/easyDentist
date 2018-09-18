package com.dentist.controller.admin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dentist.cfg.Constant;
import com.dentist.entity.QuestionA;
import com.dentist.entity.User;
import com.dentist.interceptor.RequiredPermission;
import com.dentist.service.QaService;
import com.dentist.service.UserService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;


@Controller
@RequestMapping(value = "/admin/qa")
public class QaController {
	
	@Autowired
	private QaService qaService;
	
	@Autowired
	private UserService userService;
	
	 
	
	/**
	 * 到问答列表页 
	 */
	@RequiredPermission
	@RequestMapping(value="/toQas", method = RequestMethod.GET)
	public String  toQas(){
		
		return "/admin/qa/qa_list";
	}

	/**
	 * 查询问答列表 
	 */
	@RequestMapping(value = "/qaList",method=RequestMethod.POST)
	@ResponseBody
	public LayuiPage<QuestionA> qaList(QuestionA qA,LayuiPageParam param) {
	
		return qaService.page(qA, param);
	}
	
	/**
	 * 到添加页面 
	 */
	@RequestMapping(value = "/toAdd")
	public String addRole(){
		
		return "/admin/qa/qa_add";
	}
	
	/**
	 * 到修改页面 
	 */
	@RequestMapping(value = "/toEdit")
	public String editQa(Model model,int id){
		
		QuestionA qa = qaService.queryQaById(id);
		model.addAttribute("qa", qa);
		
		return "/admin/qa/qa_edit";
	}
	
	
	/**
	 * 添加问答
	 */
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ResponseBody
	public String add(QuestionA questionA,HttpServletRequest request){
		String result = "";
		
		    User u = (User)request.getSession().getAttribute(Constant.LOGIN_USER);
		    questionA.setTime(new Date());
		    questionA.setOperatorid(u.getId());
			int num = qaService.add(questionA);
			if(num !=0){
				result = "ADD_SUCCESS";
			}else{
				result = "ADD_FAIL";
			}
	
		return result;
	}
	
	
	/**
	 * 修改问答
	 */
	@RequestMapping(value = "/edit",method=RequestMethod.POST)
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
	}
	
	
	/**
	 * 删除问答
	 */
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(Integer id){
		String result = "";
		int num =  qaService.deleteById(id);
		if(num > 0){
			result="DELETE_SUCCESS";
		}else{
			result="DELETE_FAIL";
		}
	
		return result;
	}
	
	
	
	/**
	 * 校验问题保证唯一 
	 */
	@RequestMapping(value = "/checkQuestion",method=RequestMethod.POST)
	@ResponseBody
	public String checkQuestion(String question){
		
		QuestionA qa = qaService.queryByQuestion(question);
		if(qa != null){  //已有该角色
			return "1";
		}
		return "0";
	}	
	
	
	
}
