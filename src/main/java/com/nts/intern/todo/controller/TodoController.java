package com.nts.intern.todo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nts.intern.todo.message.ErrorMessage;
import com.nts.intern.todo.model.tag.CustomTag;
import com.nts.intern.todo.model.tag.Tag;
import com.nts.intern.todo.model.todo.DetailTodo;
import com.nts.intern.todo.model.todo.Todo;
import com.nts.intern.todo.service.TagService;
import com.nts.intern.todo.service.TodoService;
import com.nts.intern.todo.util.constant.CookieConstant;
import com.nts.intern.todo.util.crypto.AES256Cipher;
import com.nts.intern.todo.util.validation.InputValidationUtil;

@Controller
@RequestMapping("/todo")
public class TodoController {
	@Autowired
	TodoService todoService;

	@Autowired
	TagService tagService;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String getTodoForm(@CookieValue(value = CookieConstant.COOKIE_NAME) String encLoginId, Model model) {
		String userId = AES256Cipher.getLoginId(encLoginId);
		List<CustomTag> tagList = tagService.searchMyTagList(userId);
		model.addAttribute("tagList", tagList);
		return "todo/todoCreateForm";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createTodo(Todo todo, @CookieValue(value = CookieConstant.COOKIE_NAME) String encLoginId,
			Model model) {
		if (InputValidationUtil.createTodo(todo) == false) {
			model.addAttribute("errorMessage", ErrorMessage.INPUT_FORMAT_EXCEPTION.getMessage());
			return "errorPage";
		}

		String userId = AES256Cipher.getLoginId(encLoginId);
		todo.setWriterId(userId);
		todoService.createTodo(todo);
		return "redirect:/tag/search";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteTodo(Integer todoId, @CookieValue(value = CookieConstant.COOKIE_NAME) String encLoginId,
			Model model) {
		String userId = AES256Cipher.getLoginId(encLoginId);
		return todoService.deleteTodo(todoId, userId);
	}

	@RequestMapping(value = "/modify/form/{todoId}", method = RequestMethod.GET)
	public String getModifyTodoForm(@PathVariable int todoId,
			@CookieValue(value = CookieConstant.COOKIE_NAME) String encLoginId, Model model) {
		String userId = AES256Cipher.getLoginId(encLoginId);
		List<CustomTag> tagList = tagService.searchMyTagList(userId);
		Todo todo = todoService.searchTodo(todoId);

		model.addAttribute("tagList", tagList);
		model.addAttribute("todo", todo);
		return "todo/todoModifyForm";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyTodo(Todo todo, Model model) {
		if (InputValidationUtil.modifyTodo(todo) == false) {
			model.addAttribute("errorMessage", ErrorMessage.INPUT_FORMAT_EXCEPTION.getMessage());
			return "errorPage";
		}

		todoService.modifyTodo(todo);
		return "redirect:/tag/search";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchTodoList(Tag tag, @CookieValue(value = CookieConstant.COOKIE_NAME) String encLoginId,
			Model model) {
		String userId = AES256Cipher.getLoginId(encLoginId);
		List<Todo> todoList = todoService.searchTodoList(tag.getTagId(), userId);

		model.addAttribute("tag", tag);
		model.addAttribute("todoList", todoList);
		return "todo/todoPage";
	}

	@RequestMapping(value = "/search/all", method = RequestMethod.GET)
	public String searchAllTodoList(Tag tag, @CookieValue(value = CookieConstant.COOKIE_NAME) String encLoginId,
			Model model) {
		String userId = AES256Cipher.getLoginId(encLoginId);
		HashMap<String, List<DetailTodo>> classifiedTodo;
		classifiedTodo = todoService.searchAllTodoList(userId);

		model.addAttribute("todoList", classifiedTodo);
		model.addAttribute("userId", userId);
		return "todo/allTodoPage";
	}
}
