$(function() {
	$.datepicker.regional['ko'] = {
		dateFormat : 'yy-mm-dd'
	};

	$.datepicker.setDefaults($.datepicker.regional['ko']);
	
	$('#startDate').datepicker();
	$('#startDate').datepicker("option", "maxDate", $("#endDate").val());
	$('#startDate').datepicker("option", "onClose", function(selectedDate) {
		$("#endDate").datepicker("option", "minDate", selectedDate);
	});

	$('#endDate').datepicker();
	$('#endDate').datepicker("option", "minDate", $("#startDate").val());
	$('#endDate').datepicker("option", "onClose", function(selectedDate) {
		$("#startDate").datepicker("option", "maxDate", selectedDate);
	});
});