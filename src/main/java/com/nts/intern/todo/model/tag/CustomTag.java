package com.nts.intern.todo.model.tag;

public class CustomTag extends Tag {
	private String userId;
	private boolean writer;

	public CustomTag() {

	}

	public CustomTag(Integer tag_id, String user_id, boolean writer) {
		this.tagId = tag_id;
		this.userId = user_id;
		this.writer = writer;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean getWriter() {
		return writer;
	}

	public void setWriter(boolean writer) {
		this.writer = writer;
	}
}
