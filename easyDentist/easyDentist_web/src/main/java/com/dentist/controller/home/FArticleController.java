package com.dentist.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dentist.entity.Article;
import com.dentist.service.ArticleExtService;
import com.dentist.service.ArticleService;
import com.dentist.utils.Page;


/**
 * 
 * 新闻中心控制器
 */
@RequestMapping("/news")
@Controller
public class FArticleController {
	
	@Autowired
	private  ArticleService articleService;
	@Autowired
	private ArticleExtService articleExtService;

	
	
	@GetMapping("/getPageInfo")
	public String getPages(Model model,String type,Integer currentPage) {
		
		Page<Article> pager = articleService.queryArticlesByType(type,currentPage);
		
		model.addAttribute("pager", pager);
		
		return "/home/newcenter";
	}
}
