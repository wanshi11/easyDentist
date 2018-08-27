package com.dentist.interceptor;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dentist.cfg.Constant;
import com.dentist.entity.Menu;
import com.dentist.entity.User;
import com.dentist.pojo.MenuPermitView;
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
		
		logger.info("请求的地址==》"+request.getRequestURI());
		HttpSession session = request.getSession();
		
		// 判断接口是否需要登录
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		RequiredPermission methodAnnotation = method.getAnnotation(RequiredPermission.class);
		if(methodAnnotation == null)   //没有注解的方法不进行逻辑判断
			return true; 
		
		String requetUrl = request.getRequestURI();
		//根据用户名称查询该用户所拥有的菜单的url
		User u = (User)session.getAttribute(Constant.LOGIN_USER);
		//List<Menu> menus = userService.queryMenusByUserId(u.getId());
		@SuppressWarnings("unchecked")
		List<MenuPermitView> list = (List<MenuPermitView>)session.getAttribute(Constant.LOGIN_MENUPERMITLIST);
		boolean flag = false;
		lableA:
		for (MenuPermitView menuPermitView : list) {
			List<Menu> menus = menuPermitView.getChildrens();
			for (int i = 0; !CollectionUtils.isEmpty(menus) && i < menus.size(); i++) {
				if (menus.get(i).getUrl().equals(requetUrl)) {
					flag = true;
					break lableA;
				}
			}
		}
		
		if (!flag) { //没有权限
			//跳转权限不足的页面
            response.sendRedirect("/admin/permission_error");
			return false;
		}else{
			return true;
		}
		
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
