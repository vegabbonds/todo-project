$(document).ready(function() {

	$('.jquery-on-container').on('click', '.js-open-target', function(e) {
		e.preventDefault();
		var target_selector = $(this).data('target');
		$(target_selector).slideDown();
		$(this).removeClass('js-open-target').addClass('js-close-target');
	});

	$('.jquery-on-container').on('click', '.js-close-target', function(e) {
		e.preventDefault();
		var target_selector = $(this).data('target');
		$(target_selector).slideUp();
		$(this).removeClass('js-close-target').addClass('js-open-target');
	})

	$('.js-open-target').each(function() {
		var target_selector = $(this).data('target');
		$(target_selector).hide();
	});
});

