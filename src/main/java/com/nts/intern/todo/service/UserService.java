package com.nts.intern.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.intern.todo.dao.CustomTagDao;
import com.nts.intern.todo.dao.UserDao;
import com.nts.intern.todo.model.tag.CustomTag;
import com.nts.intern.todo.model.user.User;
import com.nts.intern.todo.util.constant.TagConstant;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	@Autowired
	CustomTagDao customTagDao;

	@Transactional
	public boolean createUser(User user) {
		userDao.insertUser(user);
		CustomTag defaultTag = new CustomTag(TagConstant.DEFAULT_TAG_ID, user.getUserId(), TagConstant.TAG_WRITER);
		return customTagDao.insertCustomTag(defaultTag);
	}

	public User searchUser(String userId) {
		return userDao.selectUser(userId);
	}

	public boolean isUserExist(String userId) {
		return userDao.selectUserId(userId) != null;
	}

	public boolean checkLoginInfo(User user) {
		return userDao.selectUserIdByUserInfo(user) != null;
	}
}
