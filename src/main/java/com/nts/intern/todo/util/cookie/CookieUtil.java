package com.nts.intern.todo.util.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.nts.intern.todo.model.user.User;
import com.nts.intern.todo.util.constant.CookieConstant;
import com.nts.intern.todo.util.crypto.AES256Cipher;

@Service
public class CookieUtil {

	public void makeCookie(HttpServletResponse response, User user) throws Exception {
		String encUserId = AES256Cipher.aesEncode(user.getUserId());
		Cookie cookie = new Cookie(CookieConstant.COOKIE_NAME, encUserId);
		cookie.setMaxAge(CookieConstant.LIVE_TIME);
		cookie.setPath(CookieConstant.DEFAULT_PATH);
		response.addCookie(cookie);
	}

	public void deleteCookie(HttpServletResponse response) {
		Cookie deletedCookie = new Cookie(CookieConstant.COOKIE_NAME, null);
		deletedCookie.setMaxAge(0);
		deletedCookie.setPath(CookieConstant.DEFAULT_PATH);
		response.addCookie(deletedCookie);
	}
}
