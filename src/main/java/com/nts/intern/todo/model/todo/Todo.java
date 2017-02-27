package com.nts.intern.todo.model.todo;

public class Todo {
	private Integer todoId;
	private String todoName;
	private String writerId;
	private String startDate;
	private String endDate;
	private Integer tagId;
	private boolean complete;

	public Todo() {

	}

	public Todo(Integer todoId, String todoName, String writerId, String startDate, String endDate, Integer tagId) {
		this.todoId = todoId;
		this.todoName = todoName;
		this.writerId = writerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.tagId = tagId;
	}

	public Integer getTodoId() {
		return todoId;
	}

	public void setTodoId(Integer todoId) {
		this.todoId = todoId;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public boolean getComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public String toString() {
		return todoName + " " + writerId + " " + startDate + " " + endDate + " " + tagId;
	}
}
