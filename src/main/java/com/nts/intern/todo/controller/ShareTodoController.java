package com.nts.intern.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nts.intern.todo.model.tag.Tag;
import com.nts.intern.todo.model.todo.SharedTodo;
import com.nts.intern.todo.model.todo.Todo;
import com.nts.intern.todo.model.user.User;
import com.nts.intern.todo.service.ShareTodoService;
import com.nts.intern.todo.service.TodoService;
import com.nts.intern.todo.service.UserService;
import com.nts.intern.todo.util.constant.CookieConstant;
import com.nts.intern.todo.util.crypto.AES256Cipher;
import com.nts.intern.todo.util.validation.InputValidationUtil;

@Controller
@RequestMapping("/todo/share")
public class ShareTodoController {
	@Autowired
	UserService userService;

	@Autowired
	TodoService todoService;

	@Autowired
	ShareTodoService shareTodoService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createSharedUser(SharedTodo shareTodo,
			@CookieValue(value = CookieConstant.COOKIE_NAME) String encLoginId, Model model) {
		String userId = AES256Cipher.getLoginId(encLoginId);
		shareTodo.setWriterId(userId);
		if (InputValidationUtil.createSharedUser(shareTodo) == false) {
			return "false";
		}

		if (shareTodoService.createSharedUser(shareTodo) == false) {
			return "false";
		}

		User readerUser = userService.searchUser(shareTodo.getReaderId());
		model.addAttribute("readerUser", readerUser);
		model.addAttribute("shareTodo", shareTodo);
		return "/common/form/todo/newSharedUser";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewSharedTodoForm(int todoId, String tagName, Model model) {
		Todo todo = todoService.searchTodo(todoId);

		model.addAttribute("tagName", tagName);
		model.addAttribute("todo", todo);
		return "todo/sharedTodoDetailPage";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteSharedUser(Integer todoId, String readerId, Model model) {
		String redirectUrl = "redirect:/todo/share/" + todoId;
		shareTodoService.deleteSharedUser(todoId, readerId);
		return redirectUrl;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchSharedTodoList(Tag tag, @CookieValue(value = CookieConstant.COOKIE_NAME) String encLoginId,
			Model model) {
		String userId = AES256Cipher.getLoginId(encLoginId);
		List<Todo> shareTodoList = shareTodoService.searchSharedTodoList(tag.getTagId(), userId);

		model.addAttribute("tag", tag);
		model.addAttribute("todoList", shareTodoList);
		return "todo/sharedTodoPage";
	}

	@RequestMapping(value = "/{todoId}", method = RequestMethod.GET)
	public String findUserToShare(@PathVariable Integer todoId,
			@CookieValue(value = CookieConstant.COOKIE_NAME) String encLoginId, Model model) {
		String userId = AES256Cipher.getLoginId(encLoginId);
		List<User> sharedUserList = shareTodoService.searchSharedUser(todoId, userId);

		model.addAttribute("todoId", todoId);
		model.addAttribute("writerId", userId);
		model.addAttribute("sharedUserList", sharedUserList);
		return "todo/findUserToShare";
	}
}
