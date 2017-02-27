package com.nts.intern.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nts.intern.todo.message.ErrorMessage;
import com.nts.intern.todo.model.tag.CustomTag;
import com.nts.intern.todo.model.tag.Tag;
import com.nts.intern.todo.service.TagService;
import com.nts.intern.todo.util.constant.CookieConstant;
import com.nts.intern.todo.util.crypto.AES256Cipher;
import com.nts.intern.todo.util.validation.InputValidationUtil;

@Controller
@RequestMapping("/tag")
public class TagController {
	@Autowired
	TagService tagService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createTag(Tag tag, @CookieValue(value = CookieConstant.COOKIE_NAME) String ecnLoginId, Model model) {
		if (InputValidationUtil.createTag(tag) == false) {
			model.addAttribute("errorMessage", ErrorMessage.INPUT_FORMAT_EXCEPTION.getMessage());
			return "errorPage";
		}

		String userId = AES256Cipher.getLoginId(ecnLoginId);
		tagService.createTag(tag, userId);
		return "redirect:/tag/search";
	}

	@RequestMapping(value = "/delete/{tagId}", method = RequestMethod.GET)
	public String deleteTag(@PathVariable int tagId, @CookieValue(value = CookieConstant.COOKIE_NAME) String ecnLoginId,
			Model model) {
		String userId = AES256Cipher.getLoginId(ecnLoginId);
		tagService.deleteTag(tagId, userId);
		return "redirect:/tag/search";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyTag(Tag tag, Model model) {
		if (InputValidationUtil.modifyTag(tag) == false) {
			model.addAttribute("errorMessage", ErrorMessage.INPUT_FORMAT_EXCEPTION.getMessage());
			return "errorPage";
		}

		tagService.modifyTag(tag);
		return "redirect:/tag/search";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchTagList(@CookieValue(value = CookieConstant.COOKIE_NAME) String ecnLoginId, Model model) {
		String userId = AES256Cipher.getLoginId(ecnLoginId);
		List<CustomTag> tagList = tagService.searchAllTagList(userId);

		model.addAttribute("tagList", tagList);
		return "tag/tagPage";
	}
}