$(function() {
	$("#login_form").validate({
		rules : {
			userId : {
				required : true,
				minlength : 4,
				maxlength : 15,
				alphanumeric : true

			},
			userPassword : {
				required : true,
				minlength : 4,
				maxlength : 15
			}
		},
		messages : {
			userId : {
				required : "아이디를 입력하세요.",
				minlength : "id는 4자리 이상입니다.",
				maxlength : "id는 15자리 이내입니다.",
				alphanumeric : "알파벳과 숫자만 입력가능 합니다."
			},
			userPassword : {
				required : "이름을 입력하세요",
				minlength : "password는 4자리 이상입니다.",
				maxlength : "password는 15자리 이내입니다."
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	})

	$("#login_fail_form").validate({
		rules : {
			userId : {
				required : true,
				minlength : 4,
				maxlength : 15,
				alphanumeric : true
			},
			userPassword : {
				required : true,
				minlength : 4,
				maxlength : 15
			}
		},
		messages : {
			userId : {
				required : "아이디를 입력하세요.",
				minlength : "id는 4자리 이상입니다.",
				maxlength : "id는 15자리 이내입니다.",
				alphanumeric : "알파벳과 숫자만 입력가능 합니다."
			},
			userPassword : {
				required : "이름을 입력하세요",
				minlength : "password는 4자리 이상입니다.",
				maxlength : "password는 15자리 이내입니다."
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	})

	$("#signUpForm").validate({
		rules : {
			userId : {
				required : true,
				minlength : 4,
				maxlength : 15,
				alphanumeric : true
			},
			userPassword : {
				required : true,
				minlength : 4,
				maxlength : 15
			},
			userName : {
				required : true,
				minlength : 4,
				maxlength : 15,
				userNameFormat : true
			},
			userBirth : {
				required : true,
				dateISO : true,
				dateFormat : true
			}
		},
		messages : {
			userId : {
				required : "아이디를 입력하세요.",
				minlength : "id는 4자리 이상입니다.",
				maxlength : "id는 15자리 이내입니다.",
				alphanumeric : "알파벳과 숫자만 입력가능 합니다."
			},
			userPassword : {
				required : "이름을 입력하세요",
				minlength : "password는 4자리 이상입니다.",
				maxlength : "password는 15자리 이내입니다."
			},
			userName : {
				required : "이름을 입력하세요",
				minlength : "이름은 4자리 이상입니다.",
				maxlength : "이름은 15자리 이내입니다.",
				userNameFormat : "한글, 영어로 올바르게 입력하십시오."
			},
			userBirth : {
				required : "올바른 날짜 형식을 입력하십시오.",
				dateISO : "올바른 날짜 형식을 입력하십시오.",
				dateFormat : "1900년도 이상의 날짜를 입력하십시오."
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	})

	$("#tag_create_form").validate({
		rules : {
			tagName : {
				required : true,
				minlength : 2,
				maxlength : 10,
				nameFormat : true
			}
		},
		messages : {
			tagName : {
				required : "이름을 입력하세요",
				minlength : "태그는 2자리 이상입니다.",
				maxlength : "태그는 10자리 이내입니다.",
				nameFormat : "특수 문자, 공백은 사용할 수 없습니다."
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	})

	$("#tag_modify_form").validate({
		rules : {
			tagName : {
				required : true,
				minlength : 2,
				maxlength : 10,
				nameFormat : true
			}
		},
		messages : {
			tagName : {
				required : "이름을 입력하세요",
				minlength : "태그명은 2자리 이상입니다.",
				maxlength : "태그명은 10자리 이내입니다.",
				nameFormat : "특수 문자, 공백은 사용할 수 없습니다."
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	})

	$("#todo_create_form").validate({
		rules : {
			todoName : {
				required : true,
				minlength : 2,
				maxlength : 10,
				nameFormat : true
			},
			startDate : {
				required : true,
				dateISO : true
			},
			endDate : {
				required : true,
				dateISO : true
			},
			tagId : {
				required : true
			}
		},
		messages : {
			todoName : {
				required : "이름을 입력하세요",
				minlength : "투두명은 2자리 이상입니다.",
				maxlength : "투두명은 10자리 이내입니다.",
				nameFormat : "특수 문자, 공백은 사용할 수 없습니다."
			},
			startDate : {
				required : "시작 날짜를 입력하십시오."
			},
			endDate : {
				required : "시작 날짜를 입력하십시오."
			},
			tagId : {
				required : "태그를 검색하십시오. 지우고 검색어를 입력하시면 됩니다."
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	})

	$("#todo_modify_form").validate({
		rules : {
			todoName : {
				required : true,
				minlength : 2,
				maxlength : 10,
				nameFormat : true
			},
			startDate : {
				required : true,
				dateISO : true
			},
			endDate : {
				required : true,
				dateISO : true
			},
			tagId : {
				required : true,
				digits : true
			}
		},
		messages : {
			todoName : {
				required : "이름을 입력하세요",
				minlength : "투두명은 2자리 이상입니다.",
				maxlength : "투두명은 10자리 이내입니다."
			},
			startDate : {
				required : "시작 날짜를 입력하십시오."
			},
			endDate : {
				required : "시작 날짜를 입력하십시오."
			},
			tagId : {
				required : "태그를 검색하십시오. 지우고 검색어를 입력하시면 됩니다.",
				digits : "태그를 검색하십시오. 지우고 검색어를 입력하시면 됩니다."
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	})

})

jQuery.validator.setDefaults({

	onkeyup : false,
	onclick : false,
	onfocusout : false,
	showErrors : function(errorMap, errorList) {
		if (this.numberOfInvalids()) {
			alert(errorList[0].message);
		}
	}
});

jQuery.validator.addMethod("alphanumeric", function(value, element) {
	return this.optional(element) || /^[a-zA-Z0-9]+$/.test(value);
});

jQuery.validator.addMethod("nameFormat", function(value, element) {
	return this.optional(element) || /^[a-zA-Z가-힣ㄱ-ㅎ0-9]+$/.test(value);
});

jQuery.validator.addMethod("userNameFormat", function(value, element) {
	return this.optional(element) || /^[a-zA-Z가-힣]+$/.test(value);
});

jQuery.validator.addMethod("dateFormat", function(value, element) {
	return this.optional(element)
			|| /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/
					.test(value);
});
