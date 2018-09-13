package com.dentist.controller.home;

import io.swagger.models.Contact;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dentist.cfg.Constant;
import com.dentist.entity.Article;
import com.dentist.entity.Banner;
import com.dentist.entity.Doctor;
import com.dentist.service.ArticleService;
import com.dentist.service.BannerService;
import com.dentist.service.DoctorService;
import com.dentist.utils.Page;



/**
 * 主页控制器
 */
@Controller
@RequestMapping(value ="/home")
public class IndexController {
	
	@Autowired
	private BannerService bannerService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private ArticleService articleService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(Model model) {
		logger.info("Enter the home ...");
		
		ModelAndView mv = new ModelAndView("/home/home");

		List<Banner> honor_banners = bannerService.queryBannerByType(Constant.BANNER_HOROR);
		List<Banner> envir_banners = bannerService.queryBannerByType(Constant.BANNER_ENVIRONMENT);
		List<Banner> facility_banners = bannerService.queryBannerByType(Constant.BANNER_FACILITY);
		List<Banner> lunbo_banners = bannerService.queryBannerByType(Constant.BANNER_LUNBO);
		
		//查询医生信息集合
		List<Doctor> doctors = doctorService.getAllList();
		
		
		mv.addObject("lunbo_banners", lunbo_banners);
		mv.addObject("honor_banners", honor_banners);
		mv.addObject("envir_banners", envir_banners);
		mv.addObject("facility_banners", facility_banners);
		mv.addObject("doctors", doctors);
		return mv;
	}
	
	/**
	 * 到地图页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/tomap", method = RequestMethod.GET)
	public String toMap(Model model) {
		
		return "/home/map";
	}
	
	/**
	 * 到公司简介页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/introduction", method = RequestMethod.GET)
	public String introduction(Model model) {
		
		return "/home/introduction";
	}
	
	/**
	 * 到患者预约页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/makeAppointment", method = RequestMethod.GET)
	public String makeAppointment(Model model) {
		
		return "/home/mk_appointment";
	}
	
	/**
	 * 到新闻中心页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/newCenter", method = RequestMethod.GET)
	public ModelAndView newCenter(Model model,@Param("articleType") String articleType,@Param("page") Integer page) {
		
		
		ModelAndView mv = new ModelAndView("/home/newcenter");

		List<Banner> lunbo_banners = bannerService.queryBannerByType(Constant.BANNER_LUNBO);
		
		//查询医生信息集合
		List<Doctor> doctors = doctorService.getAllList();
		
		//新闻分页
        Page<Article> pager = articleService.queryArticlesByType(articleType,page);
		
        mv.addObject("articleType", articleType);
		mv.addObject("pager", pager);
		mv.addObject("lunbo_banners", lunbo_banners);
		return mv;
	}
	
	/**
	 * 到口腔技术介绍页（牙齿矫正）
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/oral/ycjz", method = RequestMethod.GET)
	public String ycjz(Model model) {
		
		return "/home/oralTechnology/ycjz";
	}

}
