package com.nts.intern.todo.message;

public enum ErrorMessage {
	RUNTIME_EXCEPTION("프로그램 실행 도중 에러가 발생하였습니다. 기본페이지로 이동합니다."), DUPLICATED_KEY_EXCEPTION(
			"프로그램 실행 도중 에러가 발생하였습니다. 입력값이 중복되었습니다."), INPUT_FORMAT_EXCEPTION("잘못된 입력값을 입력하셨습니다. 값을 확인해 주십시오.");

	private String message;

	private ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
