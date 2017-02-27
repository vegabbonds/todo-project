package com.nts.intern.todo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.nts.intern.todo.model.user.User;

@Mapper
public interface UserDao {
	public boolean insertUser(User user);

	public User selectUser(String userId);

	public String selectUserId(String userId);

	public String selectUserIdByUserInfo(User user);
}
