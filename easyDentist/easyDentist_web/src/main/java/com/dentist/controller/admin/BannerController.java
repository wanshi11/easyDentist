package com.dentist.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dentist.service.BannerService;

/**
 * 
 * 轮播器管理
 */
@Controller
@RequestMapping(value = "/admin/banner")
public class BannerController {
	
	@Autowired
	private BannerService bannerService;
	
	/**
	 * 到banner列表页 
	 */
	@RequestMapping(value="/toBanners", method = RequestMethod.GET)
	public String  toBanners(){
		
		return "/admin/banner/banner_list";
	}

}
