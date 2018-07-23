package com.dentist.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dentist.service.DoctorService;



@Controller
@RequestMapping(value = "/admin/doctor")
public class DoctorController {

	
	@Autowired
	private DoctorService doctorService;
	
	
	/**
	 * 到医生列表页面 
	 */
	@RequestMapping(value = "/toDoctors", method = RequestMethod.GET)
	public String toDoctorList(Model model) {

	
		return "/admin/doctor/doctor_list";
	}
	
	/**
	 * 到添加页面 
	 */
	@RequestMapping(value = "/toAdd")
	public String addDoctor(){
		
		return "/admin/doctor/doctor_add";
	}
}
