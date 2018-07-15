package com.dentist.controller.home;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dentist.cfg.Constant;
import com.dentist.entity.Banner;
import com.dentist.service.BannerService;



/**
 * 主页控制器
 */
@Controller
public class IndexController {
	
	@Autowired
	 private BannerService bannerService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(Model model) {
		logger.info("Enter the home ...");
		
		ModelAndView mv = new ModelAndView("/home/home");

		List<Banner> honor_banners = bannerService.queryBannerByType(Constant.BANNER_HOROR);
		List<Banner> envir_banners = bannerService.queryBannerByType(Constant.BANNER_ENVIRONMENT);
		List<Banner> facility_banners = bannerService.queryBannerByType(Constant.BANNER_FACILITY);
		List<Banner> lunbo_banners = bannerService.queryBannerByType(Constant.BANNER_LUNBO);
		
		
		mv.addObject("lunbo_banners", lunbo_banners);
		mv.addObject("honor_banners", honor_banners);
		mv.addObject("envir_banners", envir_banners);
		mv.addObject("facility_banners", facility_banners);
		return mv;
	}

}
