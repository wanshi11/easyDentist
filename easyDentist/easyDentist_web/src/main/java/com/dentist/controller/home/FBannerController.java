package com.dentist.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dentist.entity.ArticleExt;
import com.dentist.entity.Banner;
import com.dentist.service.BannerService;


/**
 * 
 * 前台BANNER控制器
 */
@RequestMapping("/activity")
@Controller
public class FBannerController {
	
	@Autowired
	private  BannerService bannerService;	
	
	
	/**
	 * 查看轮播活动
	 */
	@RequestMapping(value = "/showContentById")
	public String showContentById(Model model,int acId){
		
		Banner banner = bannerService.queryBannerById(acId);
		banner.setReadvalue(banner.getReadvalue()+1);
		bannerService.update(banner);
		
		
		model.addAttribute("banner", banner);
		
		return "/home/ac_detail";
	}
}
