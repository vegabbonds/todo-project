package com.nts.intern.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.intern.todo.dao.CustomTagDao;
import com.nts.intern.todo.dao.TagDao;
import com.nts.intern.todo.model.tag.CustomTag;
import com.nts.intern.todo.model.tag.Tag;
import com.nts.intern.todo.util.constant.TagConstant;

@Service
public class TagService {
	@Autowired
	TagDao tagDao;

	@Autowired
	CustomTagDao customTagDao;

	@Transactional
	public boolean createTag(Tag tag, String userId) {
		tagDao.insertTag(tag);
		CustomTag customTag = new CustomTag(tag.getTagId(), userId, TagConstant.TAG_WRITER);
		return customTagDao.insertCustomTag(customTag);
	}

	@Transactional
	public boolean deleteTag(Integer tagId, String userId) {
		return tagDao.deleteTag(tagId, userId) > 0;
	}

	public boolean modifyTag(Tag tag) {
		return tagDao.updateTag(tag) > 0;
	}

	public List<CustomTag> searchAllTagList(String userId) {
		return tagDao.selectTagListExceptDefaultTag(userId);
	}

	public List<CustomTag> searchMyTagList(String userId) {
		return tagDao.selectTagListByWriter(userId);
	}
}
