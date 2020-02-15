package com.dentist.controller.home;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dentist.entity.Doctor;
import com.dentist.service.DoctorService;
import com.dentist.utils.SCaptcha;


/**
 * 前台医生团队控制
 */
@Controller
@RequestMapping(value ="/doctor")
public class HomeDoctorController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeDoctorController.class);
	
	@Autowired
	private DoctorService doctorService;

	
	
	
	/**
	 * 医生加分
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/addPoint", method=RequestMethod.POST)
    @ResponseBody
	public String add(String doctorId){
		
		Doctor doctor = doctorService.queryDoctorById(Integer.parseInt(doctorId));
        		  
		doctor.setPoint(doctor.getPoint()+1);
		doctorService.update(doctor);
		
		return doctor.getPoint().toString();
	}
	
	
	
	
	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	@RequestMapping(value = "/verification", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public void verification(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        // 设置响应的类型格式为图片格式
       response.setContentType("image/jpeg");
       // 禁止图像缓存。
       response.setHeader("Pragma", "no-cache");
       response.setHeader("Cache-Control", "no-cache");
       response.setDateHeader("Expires", 0);
       //实例生成验证码对象
       SCaptcha instance = new SCaptcha();
       //将验证码存入session
       session.setAttribute("verification", instance.getCode());
       
       //向页面输出验证码图片
       instance.write(response.getOutputStream());
   }
	
	/**
	 * 校验验证码
	 */
	@RequestMapping(value = "/checkVcode", method = RequestMethod.POST)
    @ResponseBody
    public String checkVcode(HttpServletRequest request, HttpServletResponse response, String vcode, HttpSession session) {
      
		String sessionVcode = (String)session.getAttribute("verification");
		logger.info(sessionVcode);
		
		//session中去除验证码 
		session.removeAttribute("verification");
		if(vcode.equalsIgnoreCase(sessionVcode)){
			return "1";
		}else{
			return "0";
		}
	
   }

}
