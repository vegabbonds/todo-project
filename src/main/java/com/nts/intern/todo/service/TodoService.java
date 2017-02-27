package com.nts.intern.todo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.intern.todo.dao.TodoDao;
import com.nts.intern.todo.model.todo.DetailTodo;
import com.nts.intern.todo.model.todo.Todo;

@Service
public class TodoService {
	@Autowired
	TodoDao todoDao;

	public boolean createTodo(Todo todo) {
		return todoDao.insertTodo(todo);
	}

	@Transactional
	public boolean deleteTodo(Integer todoId, String writerId) {
		return todoDao.deleteTodo(todoId, writerId) > 0;
	}

	public boolean modifyTodo(Todo todo) {
		return todoDao.updateTodo(todo) > 0;
	}

	public Todo searchTodo(Integer todoId) {
		return todoDao.selectTodo(todoId);
	}

	public List<Todo> searchTodoList(Integer tagId, String userId) {
		return todoDao.selectTodoListByTagId(tagId, userId);
	}

	public HashMap<String, List<DetailTodo>> searchAllTodoList(String userId) {
		HashMap<String, List<DetailTodo>> classifiedTodo = new HashMap<String, List<DetailTodo>>();

		List<DetailTodo> notCompleteTodoList = todoDao.selectNotCompleteTodoList(userId);
		List<DetailTodo> todayTodoList = todoDao.selectTodayTodoList(userId);
		List<DetailTodo> todoListWithinAWeek = todoDao.selectTodoListWithinAWeek(userId);
		List<DetailTodo> todoListWithinAMonth = todoDao.selectTodoListWithinAMonth(userId);
		List<DetailTodo> laterTodoList = todoDao.selectLaterTodoList(userId);
		List<DetailTodo> completeTodoList = todoDao.selectCompleteTodoList(userId);

		classifiedTodo.put("notComplete", notCompleteTodoList);
		classifiedTodo.put("today", todayTodoList);
		classifiedTodo.put("withinAWeek", todoListWithinAWeek);
		classifiedTodo.put("withinAMonth", todoListWithinAMonth);
		classifiedTodo.put("later", laterTodoList);
		classifiedTodo.put("complete", completeTodoList);
		return classifiedTodo;
	}
}
