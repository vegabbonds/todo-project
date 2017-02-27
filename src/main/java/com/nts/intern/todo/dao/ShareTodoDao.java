package com.nts.intern.todo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nts.intern.todo.model.todo.SharedTodo;
import com.nts.intern.todo.model.todo.Todo;
import com.nts.intern.todo.model.user.User;

@Mapper
public interface ShareTodoDao {
	public boolean insertSharedUser(SharedTodo sharedTodo);

	public Integer deleteSharedUser(@Param("todoId") Integer todoId, @Param("readerId") String readerId);

	public List<User> selectSharedUser(@Param("todoId") Integer todoId, @Param("writerId") String writerId);

	public List<Todo> selectSharedTodoListByTagId(@Param("tagId") Integer tagId, @Param("readerId") String readerId);
}
