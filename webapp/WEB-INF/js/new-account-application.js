function approveAccountApplication(applicationId, button) {
	var row = button.parentNode.parentNode;
	var ApplicationId = row.cells[0].textContent;
	var CustomerId = row.cells[1].textContent;
	var ApplicationNomineeFirstName = row.cells[2].textContent;
	var ApplicationNomineeLastName = row.cells[3].textContent;
	var AccountTypeId = row.cells[4].textContent;
	var CreatedBy = row.cells[5].textContent;
	var ApplicationDate = row.cells[6].textContent;
	var CreatedDate = row.cells[7].textContent;
	var ProcessedBy = row.cells[8].textContent;




	// AJAX call to the first server
	$.ajax({
		url: 'saveToAccountDatabase',
		type: 'POST',
		data: {
			ApplicationId: ApplicationId,
			AccountTypeId: AccountTypeId,
			ApplicationNomineeFirstName: ApplicationNomineeFirstName,
			ApplicationNomineeLastName: ApplicationNomineeLastName,
			CustomerId: CustomerId,
			CreatedDate: CreatedDate,
			CreatedBy: CreatedBy,
			ProcessedBy: ProcessedBy
		},
		success: function(response) {
			// Handle the success response
			console.log('First server request success:', response);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			// Handle the error
			console.error('First server request error:', textStatus, errorThrown);
		}
	});

	$.ajax({
		url: 'saveToAccountDocumentsDatabase',
		type: 'POST',
		data: {
			ApplicationId: ApplicationId,
			aadhar: row.cells[9].textContent,
			pan: row.cells[10].textContent,
			passport: row.cells[11].textContent,
			driving: row.cells[12].textContent,
			jobcard: row.cells[13].textContent
		},
		success: function(response) {
			// Handle the success response
			console.log('Second server request success:', response);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			// Handle the error
			console.error('Second server request error:', textStatus, errorThrown);
		}
	});
	
	/*$.ajax({
		url: 'changeTheStatusOfAccountApp',
		type: 'POST',
		data: {
			ApplicationId: ApplicationId
		},
		success: function(response) {
			// Handle the success response
			console.log('Third server request success:', response);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			// Handle the error
			console.error('Third server request error:', textStatus, errorThrown);
		}
	});*/

	$.ajax({
		url: 'saveToCustomerDatabase',
		type: 'POST',
		data: {
			CustomerId: CustomerId
		},
		success: function(response) {
			// Handle the success response
			console.log('Third server request success:', response);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			// Handle the error
			console.error('Third server request error:', textStatus, errorThrown);
		}
	});
	
	
	
	  button.innerText = "Approved";
	  button.disabled = true;
  
	


}
function rejectAccountApplication(applicationId) {
	// Function logic for rejecting an application
	console.log('Reject application with ID:', applicationId);
}