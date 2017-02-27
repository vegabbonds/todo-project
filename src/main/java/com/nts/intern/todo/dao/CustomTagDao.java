package com.nts.intern.todo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.nts.intern.todo.model.tag.CustomTag;

@Mapper
public interface CustomTagDao {
	public boolean insertCustomTag(CustomTag customTag);

	public Integer deleteCustomTag(Integer tagId);

	public Integer deleteSharedCustomTag(CustomTag customTag);
	
	public Integer selectCustomTag(CustomTag customTag);
}
