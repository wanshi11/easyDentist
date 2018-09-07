package com.dentist.controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dentist.entity.Article;
import com.dentist.service.ArticleExtService;
import com.dentist.service.ArticleService;
import com.dentist.utils.Pager;


/**
 * 
 * 前台新闻中心
 */
@RequestMapping("/news")
public class FArticleController {
	
	@Autowired
	private  ArticleService articleService;
	@Autowired
	private ArticleExtService articleExtService;

	
	
	@PostMapping("/getPage")
	public Pager<Article> getPages(String type) {
		
		Pager<Article> pager = articleService.queryArticlesByType(type);
		
		return pager;
	}
}
