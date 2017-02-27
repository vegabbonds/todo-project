package com.nts.intern.todo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nts.intern.todo.model.tag.CustomTag;
import com.nts.intern.todo.model.tag.Tag;

@Mapper
public interface TagDao {
	public boolean insertTag(Tag tag);

	public Integer deleteTag(@Param("tagId") Integer tagId, @Param("writerId") String writerId);

	public Integer updateTag(Tag tag);

	public List<CustomTag> selectTagListExceptDefaultTag(String userId);

	public List<CustomTag> selectTagListByWriter(String userId);
}
