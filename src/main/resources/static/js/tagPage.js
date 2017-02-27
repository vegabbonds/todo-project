function getTagModifyForm(some) {
	var modifyId = $(some).val();
	$("#tagId").val(modifyId);
	$('#modifyTagForm').modal();
}