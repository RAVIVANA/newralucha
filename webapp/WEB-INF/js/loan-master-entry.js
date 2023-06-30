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
	});*/

function showRow() {
	var loanType = document.getElementById("loan-type").value;

	$.ajax({
		url: "getSelectedLoanDetails",
		type: "GET",
		data: { loanType: loanType },
		success: function(response) {
			$('#resultTable').html(response);
		},
		error: function(xhr, status, error) {
			// Handle error response
			console.log("Error occurred while retrieving loan types");
		}
	});


	// Hide all rows initially
	$("#resultTable tbody tr").hide();

	// Show rows that match the selected loan type
	$("#resultTable tbody tr[data-loan-type='" + loanType + "']").show();
}


function adddescription() {
	var modal = document.getElementById("descriptionForm");
	modal.style.display = "block";
}

function showLoanTypeForm() {
	var modal = document.getElementById("loanTypeModal");
	modal.style.display = "block";
}

function closeModal() {
	var modals = document.querySelectorAll("#loanTypeModal, #descriptionForm");
	modals.forEach(function(modal) {
		modal.style.display = "none";
	});
}
$(document).ready(function() {
	$.ajax({
		url: "getLoanTypes",
		type: "GET",
		success: function(response) {
			$('#loan-type').html(response);
		},
		error: function(xhr, status, error) {
			// Handle error response
			console.log("Error occurred while retrieving loan types");
		}
	});
});


function saveLoanType() {
	var loanId = document.getElementById("loan_id").value;
	var loanTitle = document.getElementById("loan_title").value;
	var loanDesc = document.getElementById("loan_desc").value;

	var formData = {
		LoanId: loanId,
		LoanType: loanTitle,
		DescriptionForm: loanDesc,
	};

	$.ajax({
		url: "loanDataSave",
		type: "POST",
		data: formData,
		success: function(response) {

			console.log("Form data saved successfully");
			location.reload();

		},
		error: function(xhr, status, error) {
			// Handle error response
			console.log("Error occurred while saving form data");
		}
	});

	console.log('Loan Type ID:', loanId);
	console.log('Loan Type Title:', loanTitle);
	console.log('Loan Type Description:', loanDesc);

	var table = document.getElementById("myTable");
	var newRow = table.insertRow();

	var cell1 = newRow.insertCell();
	var cell2 = newRow.insertCell();
	var cell3 = newRow.insertCell();

	cell1.innerHTML = loanId;
	cell2.innerHTML = loanTitle;
	cell3.innerHTML = loanDesc;

	addLoanTypeOption(loanTitle, loanTitle); // Add the new option

	closeModal();
}

function addLoanTypeOption(title, selectedLoanType) {
	var loanTypeSelect = document.getElementById("loan-type");
	var option = document.createElement("option");
	option.value = title.toLowerCase().replace(/\s+/g, "-");
	option.text = title;
	loanTypeSelect.add(option);

	// Set the selected option if it matches the selectedLoanType
	if (selectedLoanType && option.value === selectedLoanType.toLowerCase().replace(/\s+/g, "-")) {
		option.selected = true;
	}
}