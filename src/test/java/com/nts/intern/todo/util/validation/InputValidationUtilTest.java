package com.nts.intern.todo.util.validation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.junit.Test;

import com.nts.intern.todo.model.tag.Tag;

public class InputValidationUtilTest {
	private static final String REGEXP_USER_ID = "^[a-zA-Z0-9]{4,15}$";
	private static final String REGEXP_USER_NAME = "^[가-힣a-zA-Z0-9]{4,15}$";
	private static final String REGEXP_DATE = "^((19|20)\\d\\d)?([- /.])?(0[1-9]|1[012])([- /.])?(0[1-9]|[12][0-9]|3[01])$";
	private static final String REGEXP_TAG_NAME = "^[가-힣ㄱ-ㅎa-zA-Z0-9]{2,10}$";
	private static final String REGEXP_TODO_NAME = "^[가-힣ㄱ-ㅎa-zA-Z0-9]{2,10}$";
	private static final Integer PASSWORD_MIN_LENGTH = 4;
	private static final Integer PASSWORD_MAX_LENGTH = 15;

	@Test
	public void 유저아이디테스트() {
		// given
		String correctUserId1 = "dddd";
		String correctUserId2 = "asfdsddsddddd";
		String correctUserId3 = "a8a8a8";

		String unCorrectUserId1 = "dd";
		String unCorrectUserId2 = "ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ";
		String unCorrectUserId3 = "**@우너너";

		// when
		boolean result1 = Pattern.matches(REGEXP_USER_ID, correctUserId1);
		boolean result2 = Pattern.matches(REGEXP_USER_ID, correctUserId2);
		boolean result3 = Pattern.matches(REGEXP_USER_ID, correctUserId3);
		boolean result4 = Pattern.matches(REGEXP_USER_ID, unCorrectUserId1);
		boolean result5 = Pattern.matches(REGEXP_USER_ID, unCorrectUserId2);
		boolean result6 = Pattern.matches(REGEXP_USER_ID, unCorrectUserId3);

		// then
		assertThat(result1, is(true));
		assertThat(result2, is(true));
		assertThat(result3, is(true));
		assertThat(result4, is(false));
		assertThat(result5, is(false));
		assertThat(result6, is(false));
	}

	@Test
	public void 유저이름테스트() {
		// given
		String correctUserName1 = "dddd";
		String correctUserName2 = "안뇽안뇽하세요";
		String correctUserName3 = "헤헤헤헤아";

		String unCorrectUserName1 = "dd";
		String unCorrectUserName2 = "ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ";
		String unCorrectUserName3 = "**@우너너";

		// when
		boolean result1 = Pattern.matches(REGEXP_USER_NAME, correctUserName1);
		boolean result2 = Pattern.matches(REGEXP_USER_NAME, correctUserName2);
		boolean result3 = Pattern.matches(REGEXP_USER_NAME, correctUserName3);
		boolean result4 = Pattern.matches(REGEXP_USER_NAME, unCorrectUserName1);
		boolean result5 = Pattern.matches(REGEXP_USER_NAME, unCorrectUserName2);
		boolean result6 = Pattern.matches(REGEXP_USER_NAME, unCorrectUserName3);

		// then
		assertThat(result1, is(true));
		assertThat(result2, is(true));
		assertThat(result3, is(true));
		assertThat(result4, is(false));
		assertThat(result5, is(false));
		assertThat(result6, is(false));
	}

	@Test
	public void 유저비밀번호테스트() {
		// given
		String correctUserPassword1 = "dddd";
		String correctUserPassword2 = "dddddeeeeekkkkk";

		String unCorrectUserPassword1 = "dd";
		String unCorrectUserPassword2 = "ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ";

		// when
		boolean result1 = correctUserPassword1.length() >= PASSWORD_MIN_LENGTH
				&& correctUserPassword1.length() <= PASSWORD_MAX_LENGTH;
		boolean result2 = correctUserPassword2.length() >= PASSWORD_MIN_LENGTH
				&& correctUserPassword2.length() <= PASSWORD_MAX_LENGTH;
		boolean result3 = unCorrectUserPassword1.length() >= PASSWORD_MIN_LENGTH
				&& unCorrectUserPassword1.length() <= PASSWORD_MAX_LENGTH;
		boolean result4 = unCorrectUserPassword2.length() >= PASSWORD_MIN_LENGTH
				&& unCorrectUserPassword2.length() <= PASSWORD_MAX_LENGTH;

		// then
		assertThat(result1, is(true));
		assertThat(result2, is(true));

		assertThat(result3, is(false));
		assertThat(result4, is(false));
	}

	@Test
	public void 유저생일테스트() {
		// given
		String correctUserBirth1 = "1990-03-02";
		String correctUserBirth2 = "2012-04-26";
		String correctUserBirth3 = "2099-02-12";

		String unCorrectUserBirth1 = "199003-026";
		String unCorrectUserBirth2 = "1990-0382";
		String unCorrectUserBirth3 = "19950-03-02";
		String unCorrectUserBirth4 = "1995-03-72";

		// when
		boolean result1 = Pattern.matches(REGEXP_DATE, correctUserBirth1);
		boolean result2 = Pattern.matches(REGEXP_DATE, correctUserBirth2);
		boolean result3 = Pattern.matches(REGEXP_DATE, correctUserBirth3);
		boolean result4 = Pattern.matches(REGEXP_DATE, unCorrectUserBirth1);
		boolean result5 = Pattern.matches(REGEXP_DATE, unCorrectUserBirth2);
		boolean result6 = Pattern.matches(REGEXP_DATE, unCorrectUserBirth3);
		boolean result7 = Pattern.matches(REGEXP_DATE, unCorrectUserBirth4);

		// then
		assertThat(result1, is(true));
		assertThat(result2, is(true));
		assertThat(result3, is(true));
		assertThat(result4, is(false));
		assertThat(result5, is(false));
		assertThat(result6, is(false));
		assertThat(result7, is(false));
	}

	@Test
	public void 태그이름테스트() {
		// given
		Tag correctTag1 = new Tag();
		Tag correctTag2 = new Tag();
		Tag correctTag3 = new Tag();
		Tag unCorrectTag1 = new Tag();
		Tag unCorrectTag2 = new Tag();
		Tag unCorrectTag3 = new Tag();

		correctTag1.setTagName("aaaa");
		correctTag2.setTagName("aaa가");
		correctTag3.setTagName("aaaa666677");

		unCorrectTag1.setTagName("b");
		unCorrectTag2.setTagName("bb**");
		unCorrectTag3.setTagName("aaaa66667788");

		// when
		boolean result1 = Pattern.matches(REGEXP_TAG_NAME, correctTag1.getTagName());
		boolean result2 = Pattern.matches(REGEXP_TAG_NAME, correctTag2.getTagName());
		boolean result3 = Pattern.matches(REGEXP_TAG_NAME, correctTag3.getTagName());
		boolean result4 = Pattern.matches(REGEXP_TAG_NAME, unCorrectTag1.getTagName());
		boolean result5 = Pattern.matches(REGEXP_TAG_NAME, unCorrectTag2.getTagName());
		boolean result6 = Pattern.matches(REGEXP_TAG_NAME, unCorrectTag3.getTagName());

		// then
		assertThat(result1, is(true));
		assertThat(result2, is(true));
		assertThat(result3, is(true));
		assertThat(result4, is(false));
		assertThat(result5, is(false));
		assertThat(result6, is(false));
	}

	@Test
	public void 투두이름테스트() {
		// given
		String correctTodoName1 = "dddd";
		String correctTodoName2 = "안뇽안뇽하세요";
		String correctTodoName3 = "헤헤헤헤아";

		String unCorrectTodoName1 = "d";
		String unCorrectTodoName2 = "ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ";
		String unCorrectTodoName3 = "**@우너너";

		// then
		boolean result1 = Pattern.matches(REGEXP_TODO_NAME, correctTodoName1);
		boolean result2 = Pattern.matches(REGEXP_TODO_NAME, correctTodoName2);
		boolean result3 = Pattern.matches(REGEXP_TODO_NAME, correctTodoName3);
		boolean result4 = Pattern.matches(REGEXP_TODO_NAME, unCorrectTodoName1);
		boolean result5 = Pattern.matches(REGEXP_TODO_NAME, unCorrectTodoName2);
		boolean result6 = Pattern.matches(REGEXP_TODO_NAME, unCorrectTodoName3);

		// then
		assertThat(result1, is(true));
		assertThat(result2, is(true));
		assertThat(result3, is(true));
		assertThat(result4, is(false));
		assertThat(result5, is(false));
		assertThat(result6, is(false));
	}

	@Test
	public void 투두날짜비교테스트() throws Exception {
		// given
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String stringStartDate = "1990-03-02";
		String stringEndDate = "1990-03-02";

		String stringStartDate1 = "1990-03-04";
		String stringEndDate1 = "1990-03-08";
		int result1;
		int result2;

		// when
		Date startDate = transFormat.parse(stringStartDate);
		Date endDate = transFormat.parse(stringEndDate);

		Date startDate1 = transFormat.parse(stringStartDate1);
		Date endDate1 = transFormat.parse(stringEndDate1);

		result1 = startDate.compareTo(endDate);
		result2 = startDate1.compareTo(endDate1);

		// then
		assertThat(result1 > 0, is(false));
		assertThat(result2 < 0, is(true));
	}

}
