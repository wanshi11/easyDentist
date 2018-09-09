package com.dentist.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dentist.entity.Article;
import com.dentist.service.ArticleExtService;
import com.dentist.service.ArticleService;
import com.dentist.utils.Pager;


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

	
	
	@PostMapping("/getPageInfo")
	public Pager<Article> getPages(String type,Integer currentPage) {
		
		Pager<Article> pager = articleService.queryArticlesByType(type,currentPage);
		
		return pager;
	}
}
