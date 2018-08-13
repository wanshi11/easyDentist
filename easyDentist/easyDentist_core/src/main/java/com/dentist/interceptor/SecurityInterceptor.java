package com.dentist.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dentist.service.UserService;

/**
 *  
 * 请求权限过滤
 */
public class SecurityInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);
	
	 @Autowired
	 private UserService userService;
	 


	/**
	 * 前置过滤
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		logger.info(request.getContextPath());
		logger.info(request.getRequestURI());
		logger.info(request.getHeader("reffer"));
        
        return true;
	}

    
    
    
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
