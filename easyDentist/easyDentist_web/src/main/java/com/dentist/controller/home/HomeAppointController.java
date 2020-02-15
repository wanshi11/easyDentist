package com.dentist.controller.home;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dentist.cfg.Constant;
import com.dentist.entity.Appoint;
import com.dentist.service.AppointService;
import com.dentist.utils.Page;
import com.dentist.utils.SCaptcha;


/**
 * 前台预约控制器
 */
@Controller
@RequestMapping(value ="/appoint")
public class HomeAppointController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeAppointController.class);
	
	@Autowired
	private AppointService appointService;
	
	
	
	/**
	 * 到留言回复页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/appointReply", method = RequestMethod.GET)
	public ModelAndView appointReply(@Param("messageType") String messageType,
			@Param("patientName") String patientName,
			@Param("phone") String phone,@Param("page") Integer page) {
		
		
		ModelAndView mv = new ModelAndView("/home/appoint_reply");
		
		//留言分页
        Page<Appoint> pager = appointService.queryAppointByMessageTypeAndPatientNameAndPhoneAndStatus
        		(messageType,null,patientName,phone,page);
		
        
        if(pager.getList() != null && pager.getList().size() > 0){
        for (int i = 0; i < pager.getList().size(); i++) {
			Appoint appoint = pager.getList().get(i);
			String nameString = appoint.getPatientname();
			appoint.setPhone(appoint.getPhone().replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
			appoint.setPatientname(nameString.replace(nameString.charAt(nameString.length()-1)+"","*"));
		}
        
        }

		mv.addObject("pager", pager);
		return mv;
	}
	
	
	
	@RequestMapping(value = "/addAppoint", method=RequestMethod.POST)
    @ResponseBody
	public String add(Appoint app,HttpServletRequest request){
		String result = "";
		
		    try {
		    	app.setStatus(Constant.WAITING_REPLY);
			    app.setCreatetime(new Date());
				int num = appointService.add(app);
				if(num !=0){
					result = "ADD_SUCCESS";
				}else{
					result = "ADD_FAIL";
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	
		return result;
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
