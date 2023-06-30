function showRow() {
	var accountType = document.getElementById("account-type").value;

	$.ajax({
		url: "getSelectedAccountDetails",
		type: "GET",
		data: { accountType: accountType },
		success: function(response) {
			$('#resultTable').html(response);
		},
		error: function(xhr, status, error) {

			console.log("Error occurred while retrieving account types");
		}
	});


	// Hide all rows initially
	$("#resultTable tbody tr").hide();

	// Show rows that match the selected loan type
	$("#resultTable tbody tr[data-account-type='" + accountType + "']").show();
}


function adddescription() {
	var modal = document.getElementById("descriptionForm");
	modal.style.display = "block";
}

function showAccountTypeForm() {
	var modal = document.getElementById("accountTypeModal");
	modal.style.display = "block";
}

function closeModal() {
	var modals = document.querySelectorAll("#accountTypeModal, #descriptionForm");
	modals.forEach(function(modal) {
		modal.style.display = "none";
	});
}

$(document).ready(function() {
	$.ajax({
		url: "getAccountTypes",
		type: "GET",
		success: function(response) {
			$('#account-type').html(response);
		},
		error: function(xhr, status, error) {
			// Handle error response
			console.log("Error occurred while retrieving account types");
		}
	});
});


function saveAccountType() {
	var accountId = document.getElementById("account_id").value;
	var accountTitle = document.getElementById("account_title").value;
	var accountDesc = document.getElementById("account_desc").value;

	var formData = {
		AccountId: accountId,
		AccountType: accountTitle,
		DescriptionForm: accountDesc,
	};

	$.ajax({
		url: "accountDataSave",
		type: "POST",
		data: formData,
		success: function(response) {
			// Handle success response
			console.log("Form data saved successfully");
			location.reload();
		},
		error: function(xhr, status, error) {
			// Handle error response
			console.log("Error occurred while saving form data");
			location.reload();

		}
	});

	console.log('Account Type ID:', accountId);
	console.log('Account Type Title:', accountTitle);
	console.log('Account Type Description:', accountDesc);

	var table = document.getElementById("myTable");
	var newRow = table.insertRow();

	var cell1 = newRow.insertCell();
	var cell2 = newRow.insertCell();
	var cell3 = newRow.insertCell();

	cell1.innerHTML = accountId;
	cell2.innerHTML = accountTitle;
	cell3.innerHTML = accountDesc;

	addAccountTypeOption(accountTitle, accountTitle); // Add the new option

	closeModal();
}

function addAccountTypeOption(title, selectedAccountType) {
	var accountTypeSelect = document.getElementById("account-type");
	var option = document.createElement("option");
	option.value = title.toLowerCase().replace(/\s+/g, "-");
	option.text = title;
	accountTypeSelect.add(option);

	// Set the selected option if it matches the selectedLoanType
	if (selectedAccountType && option.value === selectedAccountType.toLowerCase().replace(/\s+/g, "-")) {
		option.selected = true;
	}
}

/*$(document).ready(function(){
	  $.ajax({
	    url: "get_loan_details",
	    type: "GET",
	    success: function(response) {
	      $('#resultTable').html(response);
	    },
	    error: function(xhr, status, error) {
	      // Handle error response
	      console.log("Error occurred while retrieving loan types");
	    }
	  });
	});*/s