package com.nts.intern.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.intern.todo.dao.CustomTagDao;
import com.nts.intern.todo.dao.ShareTodoDao;
import com.nts.intern.todo.dao.TodoDao;
import com.nts.intern.todo.dao.UserDao;
import com.nts.intern.todo.model.tag.CustomTag;
import com.nts.intern.todo.model.todo.SharedTodo;
import com.nts.intern.todo.model.todo.Todo;
import com.nts.intern.todo.model.user.User;
import com.nts.intern.todo.util.constant.TagConstant;

@Service
public class ShareTodoService {
	@Autowired
	TodoDao todoDao;

	@Autowired
	ShareTodoDao shareTodoDao;

	@Autowired
	CustomTagDao customTagDao;

	@Autowired
	UserDao userDao;

	@Transactional
	public boolean createSharedUser(SharedTodo sharedTodo) {
		if (sharedTodo.getWriterId().equals(sharedTodo.getReaderId())) {
			return false;
		}

		if (userDao.selectUserId(sharedTodo.getReaderId()) == null) {
			return false;
		}

		shareTodoDao.insertSharedUser(sharedTodo);
		Integer tagId = todoDao.selectTagId(sharedTodo.getTodoId());
		CustomTag customTag = new CustomTag(tagId, sharedTodo.getReaderId(), TagConstant.TAG_READER);
		if (customTagDao.selectCustomTag(customTag) == null) {
			return customTagDao.insertCustomTag(customTag);
		}
		return true;
	}

	@Transactional
	public boolean deleteSharedUser(Integer todoId, String readerId) {
		Integer tagId = todoDao.selectTagId(todoId);
		CustomTag customTag = new CustomTag(tagId, readerId, TagConstant.TAG_READER);
		customTagDao.deleteSharedCustomTag(customTag);
		return shareTodoDao.deleteSharedUser(todoId, readerId) > 0;
	}

	public List<Todo> searchSharedTodoList(Integer tagId, String readerId) {
		return shareTodoDao.selectSharedTodoListByTagId(tagId, readerId);
	}

	public List<User> searchSharedUser(Integer todoId, String writerId) {
		return shareTodoDao.selectSharedUser(todoId, writerId);
	}
}
