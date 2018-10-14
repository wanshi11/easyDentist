package com.dentist.controller.home;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dentist.cfg.Constant;
import com.dentist.entity.Appoint;
import com.dentist.service.AppointService;
import com.dentist.utils.SCaptcha;


/**
 * 前台预约控制器
 */
@Controller
@RequestMapping(value ="/appoint")
public class HomeAppointController {
	
	@Autowired
	private AppointService appointService;
	
	
	
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
		System.out.println(sessionVcode);
		/*try {
			this.verification( request,  response,  session);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if(vcode.equals(sessionVcode)){
			return "1";
		}else{
			return "0";
		}
	
   }

}
