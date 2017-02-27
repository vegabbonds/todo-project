$("#modify_submit_button").click(function() {
	var complete_status = $('#completeStatus').is(":checked");
	
	if (complete_status == true) {
		$('#complete').val('true');
	} else {
		$('#complete').val('false');
	}
	
	$('#todo_modify_form').submit();
});
