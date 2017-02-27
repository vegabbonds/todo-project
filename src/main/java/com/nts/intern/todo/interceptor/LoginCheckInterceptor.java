package com.nts.intern.todo.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nts.intern.todo.util.constant.CookieConstant;
import com.nts.intern.todo.util.crypto.AES256Cipher;

public class LoginCheckInterceptor implements HandlerInterceptor {

	final static Logger logger = LoggerFactory.getLogger(LoginCheckInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}

		try {
			Cookie[] cookies = request.getCookies();

			for (Cookie c : cookies) {
				if (c.getName().equals(CookieConstant.COOKIE_NAME)) {
					String encData = c.getValue();
					try {
						String decData = AES256Cipher.aesDecode(encData);
						String key[] = decData.split(CookieConstant.DELIMITER);
						if (key[1].equals(AES256Cipher.getKey())) {
							return true;
						}
					} catch (Exception e) {
						logger.info("Exception occured in LoginCheckInterceptor");
					}
				}
			}

			logger.info("admin check fail");
			response.sendRedirect("/user/login/form");
			return false;
		} catch (NullPointerException e) {
			logger.info("admin check fail");
			response.sendRedirect("/user/login/form");
			return false;
		}
	}
}
