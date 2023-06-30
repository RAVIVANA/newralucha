function editRow(button) {
	var row = button.parentNode.parentNode;
	var accountId = row.id.split('-')[1];

	var formContainer = document.getElementById('edit-form-container');
	formContainer.innerHTML = '';

	// Generate form fields dynamically
	var formFields = [
		{ label: 'Customer ID', value: row.cells[1].textContent },
		{ label: 'Application Date', value: row.cells[2].textContent },
		{ label: 'Loan Type ID', value: row.cells[3].textContent },
		{ label: 'Amount', value: row.cells[4].textContent },
		{ label: 'EMI Limit From', value: row.cells[5].textContent },
		{ label: 'EMI Limit To', value: row.cells[6].textContent },
		{ label: 'Tenure Requested', value: row.cells[7].textContent },
		{ label: 'Nominee', value: row.cells[8].textContent },
		{ label: 'Created By', value: row.cells[9].textContent },
		{ label: 'Created Date', value: row.cells[10].textContent },
		{ label: 'Processed By', value: row.cells[11].textContent },
		{ label: 'Process Date', value: row.cells[12].textContent },
		{ label: 'Processed Status', value: row.cells[13].textContent },
		{ label: 'Last Updated Date', value: row.cells[14].textContent },
		{ label: 'Last Updated User', value: row.cells[15].textContent },
		{ label: 'Status', value: row.cells[16].textContent },
		{ label: 'Remarks', value: row.cells[17].textContent },
		{ label: 'Document', value: row.cells[18].textContent },
		{ label: 'interest', value: row.cells[19].textContent }
	];

	formFields.forEach(function(field) {
		var label = document.createElement('label');
		label.textContent = field.label;

		var input = document.createElement('input');
		input.type = 'text';
		input.value = field.value;

		formContainer.appendChild(label);
		formContainer.appendChild(input);
	});

	var saveButton = document.createElement('button');
	saveButton.textContent = 'Save';
	saveButton.onclick = function() {
		saveFormData(accountId);
	};

	formContainer.appendChild(saveButton);

	// Open the form popup
	var popup = document.getElementById('edit-popup');
	popup.style.display = 'block';
}

function saveFormData(accountId) {
	// Retrieve updated values from the form fields
	var formContainer = document.getElementById('edit-form-container');
	var formInputs = formContainer.getElementsByTagName('input');
	var updatedData = {};

	for (var i = 0; i < formInputs.length; i++) {
		var input = formInputs[i];
		updatedData[input.previousSibling.textContent.trim()] = input.value;
	}
	console.log(updatedData['Customer ID']);
	var ID = document.getElementById('loanId').textContent;
	var customerId = updatedData['Customer ID'];
	var applicationDate = updatedData['Application Date'];
	var loanTypeId = updatedData['Loan Type ID'];
	var loanAmount = updatedData['Amount'];
	var interest = updatedData['interest'];
	var emiLimitFrom = updatedData['EMI Limit From'];
	var emiLimitTo = updatedData['EMI Limit To'];
	var tenureRequested = updatedData['Tenure Requested'];
	var nominee = updatedData['Nominee'];
	var createdBy = updatedData['Created By'];
	var createdDate = updatedData['Created Date'];
	var processedBy = updatedData['Processed By'];
	var processDate = updatedData['Process Date'];
	var processedStatus = updatedData['Processed Status'];
	var lastUpdatedDate = updatedData['Last Updated Date'];
	var lastUpdatedUser = updatedData['Last Updated User'];
	var status = updatedData['Status'];
	var remarks = updatedData['Remarks'];
	var attachment = updatedData['Document'];

	// Perform the AJAX request to update the data
	$.ajax({
		url: 'update_application',
		type: 'post',
		data: {
			ID: ID,
			CustId: customerId,
			ApplicationDate: applicationDate,
			LoanTypeId: loanTypeId,
			Amount: loanAmount,
			Intrest: interest,
			EmiLimitFrom: emiLimitFrom,
			EmiLimitTo: emiLimitTo,
			TenureRequested: tenureRequested,
			nominee: nominee,
			CreatedBy: createdBy,
			CreatedDate: createdDate,
			ProcessedBy: processedBy,
			ProcessDate: processDate,
			ProcessedStatus: processedStatus,
			LastUpdatedDate: lastUpdatedDate,
			LastUpdatedUser: lastUpdatedUser,
			status: status,
			remarks: remarks,
			Attachment: attachment
		},
		success: function(resultText) {
			$('#r1').html(resultText);
		},
		error: function(jqXHR, exception) {
			console.log('Error occurred!');
		}
	});

	// Close the form popup
	var popup = document.getElementById('edit-popup');
	popup.style.display = 'none';
}
function rejected() {
	var row = event.target.parentNode.parentNode;
	var loanId = row.cells[0].textContent;

	// Send AJAX request to delete the row
	$.ajax({
		url: 'deleteLoan',
		type: 'post',
		data: { loanId: loanId },
		success: function(resultText) {
			// Remove the row from the table
			row.parentNode.removeChild(row);
		},
		error: function(jqXHR, exception) {
			console.log('Error occurred while deleting the row!');
		}
	});
}