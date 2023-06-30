function saveData(busr_id) {
	var busr_title = $("#busr_title-" + busr_id).val();
	var busr_desg = $("#busr_desg-" + busr_id).val();
	var busr_email = $("#busr_email-" + busr_id).val();

	var formData = {
		busr_id: busr_id,
		busr_title: busr_title,
		busr_desg: busr_desg,
		busr_email: busr_email
	};
	console.log(busr_id);
	var saveChangesBtn = $("#saveChangesBtn-" + busr_id);
	var cancelBtn = $("#editModal-" + busr_id + " .modal-footer .btn-secondary");
	var okBtn = $("#okBtn-" + busr_id);
	var successMessage = $("#successMessage-" + busr_id);

	$.ajax({
		url: "saveUserData",
		method: "POST",
		data: formData,
		success: function(response) {
			// Display success message
			successMessage.text(response).show();


			// Hide the Save Changes and Cancel buttons, and show the OK button
			saveChangesBtn.hide();
			cancelBtn.hide();
			okBtn.show();

			// Change OK button color to black
			okBtn.removeClass("btn-secondary").addClass("btn-primary");

			// Reload the page on OK button click
			okBtn.on("click", function() {
				location.reload();
			});
		},
		error: function(xhr, status, error) {
			console.log("Error occurred while saving form data");
		}
	});
}

function filterUsers() {
	var designation = $("#designation").val();
	var tableRows = $("tbody tr");

	tableRows.show(); // Show all rows by default

	if (designation !== "") {
		tableRows.each(function() {
			var rowDesignation = $(this).find("td:nth-child(3)").text();

			if (rowDesignation !== designation) {
				$(this).hide(); // Hide rows that don't match the selected designation
			}
		});
	}
}