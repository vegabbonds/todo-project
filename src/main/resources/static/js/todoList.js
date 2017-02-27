function deleteTodo(some) {
	var todoId = $(some).val();

	$.ajax({
		type : 'POST',
		data : "todoId=" + todoId,
		dataType : 'text',
		url : '/todo/delete',
		success : function(rData, textStatus, xhr) {
			var checkResult = rData;
			if (checkResult === 'true') {
				$("#todoListBody #todoList" + todoId).remove();
			} else {
				alert(checkResult);
			}
		},
		error : function(xhr, status, e) {
			alert(e);
		} 
	});
}

function deleteCompleteTodo(some) {
	var todoId = $(some).val();

	$.ajax({
		type : 'POST',
		data : "todoId=" + todoId,
		dataType : 'text',
		url : '/todo/delete',
		success : function(rData, textStatus, xhr) {
			var checkResult = rData;
			if (checkResult === 'true') {
				$("#todoList" + todoId).remove();
			} else {
				alert(checkResult);
			}
		},
		error : function(xhr, status, e) {
			alert(e);
		}
	});
}