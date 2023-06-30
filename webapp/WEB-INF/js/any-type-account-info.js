var selectedRow;

// Function to open the form popup for editing a row
function editRow(button) {
	selectedRow = button.parentNode.parentNode;
	var cells = selectedRow.getElementsByTagName("td");
	document.getElementById("edit_acnt_acap_id").value = cells[0].innerText;
	document.getElementById("edit_acnt_acty_id").value = cells[1].innerText;
	document.getElementById("edit_account_first_nominee").value = cells[2].innerText;
	document.getElementById("edit_account_last_nominee").value = cells[3].innerText;
	document.getElementById("edit_acnt_cust_id").value = cells[4].innerText;
	document.getElementById("edit_acnt_cdate").value = cells[5].innerText;
	document.getElementById("edit_account_createdBy").value = cells[6].innerText;
	document.getElementById("edit_acnt_processedy").value = cells[7].innerText;
	document.getElementById("edit_cust_Title").value = cells[8].innerText;
	document.getElementById("edit_cust_phoneNo").value = cells[9].innerText;
	document.getElementById("edit_cust_Current_address").value = cells[10].innerText;
	document.getElementById("editForm").style.display = "block";
}


  


// Function to update the edited row
function updateRow() {
	var cells = selectedRow.getElementsByTagName("td");
	cells[0].innerText = document.getElementById("edit_acnt_acap_id").value;
	cells[1].innerText = document.getElementById("edit_acnt_acty_id").value;
	cells[2].innerText = document.getElementById("edit_account_first_nominee").value;
	cells[3].innerText = document.getElementById("edit_account_last_nominee").value;
	cells[4].innerText = document.getElementById("edit_acnt_cust_id").value;
	cells[5].innerText = document.getElementById("edit_acnt_cdate").value;
	cells[6].innerText = document.getElementById("edit_account_createdBy").value;
	cells[7].innerText = document.getElementById("edit_acnt_processedy").value;
	cells[8].innerText = document.getElementById("edit_cust_Title").value;
	cells[9].innerText = document.getElementById("edit_cust_phoneNo").value;
	cells[10].innerText = document.getElementById("edit_cust_Current_address").value;

	// Prepare the data to send in the AJAX request
	var customerId = document.getElementById("edit_acnt_cust_id").value;
	var customerTitle = document.getElementById("edit_cust_Title").value;
	var customerPhoneNo = document.getElementById("edit_cust_phoneNo").value;
	var customerAddress = document.getElementById("edit_cust_Current_address").value;

	var requestData = {
		CustomerId: customerId,
		Title: customerTitle,
		PhoneNo: customerPhoneNo,
		Address: customerAddress
	};

	// Send the AJAX request
	$.ajax({
		url: 'saveToCustomersubDatabase',
		type: 'POST',
		data: requestData,
		success: function(response) {
			// Handle the success response
			console.log('Third server request success:', response);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			// Handle the error
			console.error('Third server request error:', textStatus, errorThrown);
		}
	});

	closeForm();
}


// Function to close the form popup
function closeForm() {
	document.getElementById("editForm").style.display = "none";
}

function deleteRow(button) {
	
    var row = button.parentNode.parentNode;
    var cells = row.getElementsByTagName("td");
    var statusCell = row.cells[12]; 
    statusCell.textContent = "Inactive";
    button.disabled = true;
    
    var num = cells[0].innerText;
    $.ajax({
		url: 'chnageTheStatusOfAccount',
		type: 'POST',
		data: {
			num: num
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
    
    
}

function activeRow(button) {
	
    var row = button.parentNode.parentNode;
    var cells = row.getElementsByTagName("td");
    var statusCell = row.cells[12]; 
    statusCell.textContent = "Active";
    button.disabled = true;
    
    var num = cells[0].innerText;
    $.ajax({
		url: 'chnageTheStatusOfAccountToActive',
		type: 'POST',
		data: {
			num: num
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
    
    
}

