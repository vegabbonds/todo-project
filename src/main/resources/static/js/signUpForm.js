function chkDupId() {
	var userId = $('#userId').val();

	if ($('#userId').val() == '') {
		alert('ID를 입력해주세요.');
		return;
	}

	$.ajax({
		type : 'POST',
		data : "userId=" + userId,
		dataType : 'text',
		url : '/user/signUp/checkDupId',
		success : function(rData, textStatus, xhr) {
			var checkResult = rData;
			if (checkResult == 0) {
				alert("등록 가능 합니다.");
				$("#idChk").val('Y');
			} else {
				alert("중복 되어 있습니다.");
				$("#idChk").val('N');
			}
		},
		error : function(xhr, status, e) {
			alert(e);
		}
	});
}

$("#userId").keyup(function() {
	var userId = $('#userId').val();

	if ($('#userId').val() == '') {
		$("#checkId").val('ID를 입력해주세요.');
		return;
	}

	$.ajax({
		type : 'POST',
		data : "userId=" + userId,
		dataType : 'text',
		url : '/user/signUp/checkDupId',
		success : function(rData, textStatus, xhr) {
			var checkResult = rData;
			if (checkResult == 'true') {
				$("#checkId").val('등록 가능한 ID입니다.');
				$("#idChk").val('Y');
			} else {
				$("#checkId").val('중복되어 있는 ID입니다.');
				$("#idChk").val('N');
			}
		},
		error : function(xhr, status, e) {
			alert(e);
		}
	});
});

function submitCheck() {

	if ($("#idChk").val() == 'N') {
		alert('ID체크를 해주세요.');
		return;
	}

	$("#signUpForm").submit();
}
