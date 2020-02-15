package com.dentist.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dentist.entity.Article;
import com.dentist.entity.ArticleExt;
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
	
	
	
	/**
	 * 查看文章
	 */
	@RequestMapping(value = "/showNewById")
	public String showArticleById(Model model,int articleId){
		
		Article art = articleService.queryArticleById(articleId);
		ArticleExt artE = articleExtService.queryArticleExtByarticleId(articleId);
		
		artE.setReadvalue(artE.getReadvalue()+1);
		articleExtService.update(artE);
		
		//上一篇
		Article preAticle = articleService.queryThePreArticle(articleId);
		//下一篇
		Article nextAticle = articleService.queryTheNextArticle(articleId);
	
		model.addAttribute("art", art);
		model.addAttribute("artE", artE);
		model.addAttribute("preAticle", preAticle);
		model.addAttribute("nextAticle", nextAticle);
		
		return "/home/news_detail";
	}
}
