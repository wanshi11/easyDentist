package com.dentist.controller.admin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dentist.entity.Article;
import com.dentist.entity.ArticleExt;
import com.dentist.entity.Role;
import com.dentist.entity.User;
import com.dentist.service.ArticleService;
import com.dentist.utils.Constant;

@Controller
@RequestMapping(value = "/admin/article")
public class ArticleController {
	
	@Autowired
	private  ArticleService articleService;
	
	
	/**
	 * 到文章列表页 
	 */
	@RequestMapping(value="/toArticles", method = RequestMethod.GET)
	public String  toArticles(){
		
		return "/admin/article/article_list";
	}
	
	/**
	 * 到添加页面 
	 */
	@RequestMapping(value = "/toAdd")
	public String addArticle(Model model){
		
		return "/admin/article/article_add";
	}
	
	
	/**
	 * 添加文章
	 */
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ResponseBody
	public String add(Article article,ArticleExt articleExt,HttpServletRequest request){
		String result = "";
		
		    User u = (User)request.getSession().getAttribute(Constant.LOGIN_USER);
			
			/*if(num !=0){
				result = "ADD_SUCCESS";
			}else{
				result = "ADD_FAIL";
			}*/
	
		return result;
	}

}
