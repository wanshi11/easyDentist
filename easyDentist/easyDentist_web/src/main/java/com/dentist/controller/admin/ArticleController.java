package com.dentist.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dentist.service.ArticleService;

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

}
