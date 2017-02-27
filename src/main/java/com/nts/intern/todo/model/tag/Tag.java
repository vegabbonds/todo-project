package com.nts.intern.todo.model.tag;

public class Tag {
	protected Integer tagId;
	protected String tagName;

	public Tag() {
	}

	public Tag(Integer tagId, String tagName) {
		this.tagId = tagId;
		this.tagName = tagName;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
}
