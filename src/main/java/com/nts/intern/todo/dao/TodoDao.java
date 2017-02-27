package com.nts.intern.todo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nts.intern.todo.model.todo.DetailTodo;
import com.nts.intern.todo.model.todo.Todo;

@Mapper
public interface TodoDao {
	public boolean insertTodo(Todo todo);

	public Integer deleteTodo(@Param("todoId") Integer todoId, @Param("writerId") String writerId);

	public Integer updateTodo(Todo todo);

	public Integer selectTagId(Integer todoId);

	public Todo selectTodo(Integer todoId);

	public List<Todo> selectTodoListByTagId(@Param("tagId") Integer tagId, @Param("writerId") String writerId);

	public List<DetailTodo> selectNotCompleteTodoList(String userId);

	public List<DetailTodo> selectTodayTodoList(String userId);

	public List<DetailTodo> selectTodoListWithinAWeek(String userId);

	public List<DetailTodo> selectTodoListWithinAMonth(String userId);

	public List<DetailTodo> selectLaterTodoList(String userId);

	public List<DetailTodo> selectCompleteTodoList(String userId);
}
