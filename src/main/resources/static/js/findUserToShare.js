$("#shareButton").click(function() {
	var readerId = $('#readerId').val();
	var todoId = $('#todoId').val();

	var allData = {
		"readerId" : readerId,
		"todoId" : todoId
	};

	if ($('#readerId').val() == '') {
		alert('검색어를 입력하십시오.');
		return;
	}	

	$.ajax({
		type : 'POST',
		data : allData,
		url : '/todo/share/create',
		success : function(rData, textStatus, xhr) {
			var newShareUser = rData;
			if(newShareUser == 'false'){
				alert("이미 추가했거나 가입되지 않은 회원입니다.");
				return;
			}
			$("#sharedUserListBody").append(newShareUser);
		},
		error : function(xhr, status, e) {
			alert("이미 추가했거나 가입되지 않은 회원입니다.");
		}
	});
});