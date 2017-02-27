package com.nts.intern.todo.util.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import com.nts.intern.todo.model.tag.Tag;
import com.nts.intern.todo.model.todo.SharedTodo;
import com.nts.intern.todo.model.todo.Todo;
import com.nts.intern.todo.model.user.User;

public class InputValidationUtil {
	private static final String REGEXP_USER_ID = "^[a-zA-Z0-9]{4,15}$";
	private static final String REGEXP_USER_NAME = "^[가-힣a-zA-Z0-9]{4,15}$";
	private static final String REGEXP_DATE = "^((19|20)\\d\\d)?([- /.])?(0[1-9]|1[012])([- /.])?(0[1-9]|[12][0-9]|3[01])$";
	private static final String REGEXP_TAG_NAME = "^[가-힣ㄱ-ㅎa-zA-Z0-9]{2,10}$";
	private static final String REGEXP_TODO_NAME = "^[가-힣ㄱ-ㅎa-zA-Z0-9]{2,10}$";
	private static final Integer PASSWORD_MIN_LENGTH = 4;
	private static final Integer PASSWORD_MAX_LENGTH = 15;

	public static boolean createUser(User user) {
		if (Pattern.matches(REGEXP_USER_ID, user.getUserId()) == false) {
			return false;
		} else if (Pattern.matches(REGEXP_USER_NAME, user.getUserName()) == false) {
			return false;
		} else if (user.getUserPassword().length() < PASSWORD_MIN_LENGTH
				|| user.getUserPassword().length() > PASSWORD_MAX_LENGTH) {
			return false;
		} else if (Pattern.matches(REGEXP_DATE, user.getUserBirth()) == false) {
			return false;
		}
		return true;
	}

	public static boolean createSharedUser(SharedTodo shareTodo) {
		if (Pattern.matches(REGEXP_USER_ID, shareTodo.getReaderId()) == false) {
			return false;
		} else if (Pattern.matches(REGEXP_USER_ID, shareTodo.getWriterId()) == false) {
			return false;
		}
		return true;
	}

	public static boolean login(User user) {
		if (Pattern.matches(REGEXP_USER_ID, user.getUserId()) == false) {
			return false;
		} else if (user.getUserPassword().length() < PASSWORD_MIN_LENGTH
				|| user.getUserPassword().length() > PASSWORD_MAX_LENGTH) {
			return false;
		}
		return true;
	}

	public static boolean createTag(Tag tag) {
		if (Pattern.matches(REGEXP_TAG_NAME, tag.getTagName())) {
			return true;
		}
		return false;
	}

	public static boolean createTodo(Todo todo) {
		if (Pattern.matches(REGEXP_TODO_NAME, todo.getTodoName()) == false) {
			return false;
		} else if (Pattern.matches(REGEXP_DATE, todo.getStartDate()) == false) {
			return false;
		} else if (Pattern.matches(REGEXP_DATE, todo.getEndDate()) == false) {
			return false;
		}

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate = transFormat.parse(todo.getStartDate());
			Date endDate = transFormat.parse(todo.getEndDate());
			if (startDate.compareTo(endDate) > 0) {
				return false;
			}
		} catch (ParseException e) {
			return false;
		}

		return true;
	}

	public static boolean modifyTag(Tag tag) {
		if (Pattern.matches(REGEXP_TAG_NAME, tag.getTagName()) == false) {
			return false;
		} else if (tag.getTagId() == null) {
			return false;
		}
		return true;
	}

	public static boolean modifyTodo(Todo todo) {
		if (Pattern.matches(REGEXP_TODO_NAME, todo.getTodoName()) == false) {
			return false;
		} else if (Pattern.matches(REGEXP_DATE, todo.getStartDate()) == false) {
			return false;
		} else if (Pattern.matches(REGEXP_DATE, todo.getEndDate()) == false) {
			return false;
		} else if (todo.getTodoId() == null) {
			return false;
		}

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate = transFormat.parse(todo.getStartDate());
			Date endDate = transFormat.parse(todo.getEndDate());
			if (startDate.compareTo(endDate) > 0) {
				return false;
			}
		} catch (ParseException e) {
			return false;
		}

		return true;
	}
}
