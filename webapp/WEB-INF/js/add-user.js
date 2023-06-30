$(document).ready(function() {
	$('#bankUserForm').submit(function(event) {
		event.preventDefault(); // Prevent default form submission

		var form = $(this);
		$.ajax({
			type: form.attr('method'),
			url: form.attr('action'),
			data: form.serialize(),
			success: function(response) {
				$('#successMessage').text(response).fadeIn();

				setTimeout(function() {
					$('#successMessage').fadeOut();
				}, 3000);

				form.trigger('reset'); // Optional: Reset the form after successful submission
			},
			error: function() {
				alert('An error occurred.'); // Handle error case if needed
			}
		});
	});

	$('#busr_desg').change(function() {
		if ($(this).val() !== "") {
			$(this).find('option:first').attr('disabled', 'disabled').hide();
		}
	});
});