package com.nts.intern.todo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nts.intern.todo.message.ErrorMessage;
import com.nts.intern.todo.model.user.User;
import com.nts.intern.todo.service.UserService;
import com.nts.intern.todo.util.cookie.CookieUtil;
import com.nts.intern.todo.util.validation.InputValidationUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	CookieUtil cookieUtil;

	@RequestMapping(value = "/signUp/form", method = RequestMethod.GET)
	public String getSignUpForm() {
		return "signUp/signUpForm";
	}

	@RequestMapping(value = "/signUp/submit", method = RequestMethod.POST)
	public String createUser(User user, Model model) {
		if (InputValidationUtil.createUser(user) == false) {
			model.addAttribute("errorMessage", ErrorMessage.INPUT_FORMAT_EXCEPTION.getMessage());
			return "errorPage";
		}
		userService.createUser(user);
		return "login/loginForm";
	}

	@RequestMapping(value = "/signUp/checkDupId", method = RequestMethod.POST)
	@ResponseBody
	public boolean checkIdDuplicated(String userId) throws IOException {
		if (userService.isUserExist(userId) == true) {
			return false;
		}
		return true;
	}

	@RequestMapping(value = "/login/form", method = RequestMethod.GET)
	public String getLoginForm() {
		return "login/loginForm";
	}

	@RequestMapping(value = "/login/submit", method = RequestMethod.POST)
	public String submitLoginForm(User user, HttpServletResponse response, Model model) throws Exception {
		if (InputValidationUtil.login(user) == false) {
			model.addAttribute("errorMessage", ErrorMessage.INPUT_FORMAT_EXCEPTION.getMessage());
			return "errorPage";
		}
		if (userService.checkLoginInfo(user)) {
			cookieUtil.makeCookie(response, user);
			return "redirect:/tag/search";
		}
		return "login/loginFailForm";
	}

	@RequestMapping(value = "/login/logout", method = RequestMethod.GET)
	public String logout(HttpServletResponse response) {
		cookieUtil.deleteCookie(response);
		return "login/loginForm";
	}
}
