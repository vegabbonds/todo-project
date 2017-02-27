function deleteTodo(some){
	var todoId = $(some).val();

	$.ajax({
		type : 'POST',
		data : "todoId=" + todoId,
		dataType : 'text',
		url : '/todo/delete',
		success : function(rData, textStatus, xhr) {
			var checkResult = rData;
			$("#todoList"+todoId).remove();
		},
		error : function(xhr, status, e) {
			alert(e);
		}
	});	
}